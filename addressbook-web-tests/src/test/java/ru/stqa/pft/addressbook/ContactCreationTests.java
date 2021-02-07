package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{
  @Test
  public void testUntitledTestCase() throws Exception {
    app.goToContactCreatForm("add new");
    app.fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test1", "test notes"));
    app.submitContactCreation();
    app.goToHomePage();
    //добавила шаг т.к. нужна проверка что контакт добавлен и отображается но я пока не знаю как это написать
    app.logout();
  }
}
