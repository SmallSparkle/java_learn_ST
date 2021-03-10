package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().createGroup(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().createContact(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), true);
    }
    app.goTo().homePage();
  }

  @Test
  public void deletionContactTest() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().deleteContact(index);
    app.goTo().homePage();
    app.getHelper().find();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
