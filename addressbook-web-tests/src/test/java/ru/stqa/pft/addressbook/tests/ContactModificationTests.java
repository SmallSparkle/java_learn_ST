package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactModificationTests extends TestBase {
  @Test
  public void modificationContactTest() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), true);
    }
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
//    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectEditContact(before.size() - 1);
    //изменить метод выбора контакта для редактирования
    //добавить новый с поиском по сиблингу - возможно
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 25", "4959880012", "0001120003", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), false);
    app.getContactHelper().update();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
//    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before.size(), after.size());
  }
}

