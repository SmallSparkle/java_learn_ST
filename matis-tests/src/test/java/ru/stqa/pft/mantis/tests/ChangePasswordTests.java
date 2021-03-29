package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ChangePasswordTests extends TestBase{

  @Test
  public void testLoginAfterChangedPassword() throws ClassNotFoundException {
//    Администратор входит в систему
    app.loginUI();

//    получить  список пользователей из базы и выбрать из них рандомного

//    переходит на страницу управления пользователями
//    выбирает заданного пользователя и нажимает кнопку Reset Password
    app.admin().changePassword();

//    Отправляется письмо на адрес пользователя,
//    тесты должны получить это письмо,
//    извлечь из него ссылку для смены пароля,
//    пройти по этой ссылке и изменить пароль.
//    Затем тесты должны проверить, что пользователь может войти в систему с новым паролем.
  }
}
