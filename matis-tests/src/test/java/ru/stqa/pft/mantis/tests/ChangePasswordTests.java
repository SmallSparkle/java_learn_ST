package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.models.MailMessage;
import ru.stqa.pft.mantis.models.User;
import ru.stqa.pft.mantis.models.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertTrue;


public class ChangePasswordTests extends TestBase {
  private Optional<User> user;

  @BeforeMethod
  public void before() {
//    старт почтового клиента
    app.mail().start();


  }

  @Test
  public void testLoginAfterChangedPassword() throws ClassNotFoundException, InterruptedException, IOException {
//    найти пользователя в базе
    Users users = app.db().users();
    Optional<User> user = users
            .stream().filter((u) -> u.getUsername() != "administrator")
            .findAny();
    assertTrue(user.isPresent());
    app.data().loginUI();
    app.session().changePassword(user);
    HttpSession session = app.newSession();
    session.logout();
//    Ожидаем письмо и берем ссылку для сброса пароля
    List<MailMessage> mailMessages = app.mail().waiTForMail(1, 10000);
    String confirmationLink = app.registration()
            .findLinkFromMailWithText(mailMessages, user.get().getEmail(), "Your password has been reset");
    //    пройти по этой ссылке и изменить пароль.
    String passwordNew = String.format("password%s", user.get().getId());
    app.session().updateUserPassword(confirmationLink, user, passwordNew);

    //Логин по http протоколу с новым паролем
    Assert.assertTrue(session.login(user.get().getUsername(), passwordNew));
    Assert.assertTrue(session.isLoggedInAs(user.get().getUsername()));
  }

  @AfterMethod
  public void after() throws MessagingException {
//    стоп почтового клиента
    app.mail().stop();
//    удалить пользователя из базы

  }

}
