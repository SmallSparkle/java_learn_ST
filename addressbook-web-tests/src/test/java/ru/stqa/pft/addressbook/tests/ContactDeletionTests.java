package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase{
  @Test
  public void deletionContactTest(){
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test1", "test notes"), true);
    }
    app.getContactHelper().selectContact( "(//input[@name='selected[]'])");
    app.getContactHelper().deleteSelectedContact("//input[@value='Delete']");
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();

  }

}
