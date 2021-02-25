package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


public class ContactModificationTests extends TestBase {
  @Test
  public void modificationContactTest() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup(By.name("selected[]"))) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact(By.xpath("//img[@alt='Edit']"))) {
      app.getContactHelper().createContact(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 25", "4959880012", "0001120003", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), false);
    app.getContactHelper().submit("(//input[@name='update'])[2]");
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}

