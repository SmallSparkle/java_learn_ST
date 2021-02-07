package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests extends TestBase{
  @Test
  public void testUntitledTestCase() throws Exception {
    goToContactCreatForm("add new");
    fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test1", "test notes"));
    submitContactCreation();
    goToHomePage();
    //добавила шаг т.к. нужна проверка что контакт добавлен и отображается но я пока не знаю как это написать
    logout();
  }
}
