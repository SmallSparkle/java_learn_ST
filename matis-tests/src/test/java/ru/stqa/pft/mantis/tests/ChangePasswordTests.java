package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.models.User;

import javax.mail.MessagingException;
import java.util.Optional;

public class ChangePasswordTests extends TestBase {
  private Optional<User> user;

  @BeforeMethod
  public void before() {
//    старт почтового клиента
    app.mail().start();
//    саздать пользоватеоля по http -> найти его в базе и полусить его Id
    user = app.data().createUser();


  }


  @Test
  public void testLoginAfterChangedPassword() throws ClassNotFoundException, InterruptedException {
//    Администратор входит в систему
    app.loginUI();

//    переходит на страницу управления пользователями
//    выбирает заданного пользователя и нажимает кнопку Reset Password
    app.admin().changePassword(user);

//    Отправляется письмо на адрес пользователя,
//    тесты должны получить это письмо,
//    извлечь из него ссылку для смены пароля,
//    пройти по этой ссылке и изменить пароль.
//    Затем тесты должны проверить, что пользователь может войти в систему с новым паролем.
  }

  @AfterMethod
  public void after() throws MessagingException {
//    стоп почтового клиента
    app.mail().stop();
//    удалить пользователя из базы

  }

}
