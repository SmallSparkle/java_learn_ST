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
      app.contact().createContact(new ContactData()
              .withName("Anna").withMiddlename("Amina").withLastname("Bespalova")
              .withAddress("Moscow Lenina 10").withHomePhone("4959880012")
              .withMobilePhone("9660001213").withFerstEmail("some@some.mail")
              .withThirdEmail("some2@some.mail").withBday("5").withBmonth("May")
              .withByear("1987").withNotesText("test notes"), true);
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
