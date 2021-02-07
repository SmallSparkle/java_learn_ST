package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
  @Test
  public void testUntitledTestCase() throws Exception {
    app.getNavigationHelper().goToContactCreatForm("add new");
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test1", "test notes"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
    //добавила шаг т.к. нужна проверка что контакт добавлен и отображается но я пока не знаю как это написать
    app.logout();
  }
}
