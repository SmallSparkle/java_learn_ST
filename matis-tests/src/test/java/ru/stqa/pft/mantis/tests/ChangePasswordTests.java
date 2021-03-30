package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;

public class ChangePasswordTests extends TestBase {
  private String userId;

  @BeforeMethod
  public void before() {
//    старт почтового клиента
    app.mail().start();
//    саздать пользоватеоля по http -> найти его в базе и полусить его Id
    userId = Integer.toString(app.data().createUser().get().getId());


  }


  @Test
  public void testLoginAfterChangedPassword() throws ClassNotFoundException {
//    Администратор входит в систему
    app.loginUI();

//    переходит на страницу управления пользователями
//    выбирает заданного пользователя и нажимает кнопку Reset Password
    app.admin().changePassword(userId);

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
