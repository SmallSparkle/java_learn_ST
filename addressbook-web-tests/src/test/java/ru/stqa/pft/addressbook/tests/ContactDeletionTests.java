package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
      if(app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().createGroup(new GroupData().withName("test1"));
      }
      if(app.db().contacts().size() == 0) {
        app.contact().createContact(new ContactData()
                .withName("Anna").withMiddlename("Amina").withLastname("Bespalova")
                .withPhoto(new File("src/test/resources/asd.jpg"))
                .withAddress("Moscow Lenina 10").withHomePhone("4959880012")
                .withMobilePhone("9660001213").withFerstEmail("some@some.mail")
                .withThirdEmail("some2@some.mail").withBday("5").withBmonth("May")
                .withByear("1987").withNotesText("test notes"), true);
      }
      app.goTo().homePage();
    }

  @Test
  public void deletionContactTest() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContact(deletedContact);
    app.goTo().homePage();
   // app.getHelper().find();

    assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.db().contacts();
    MatcherAssert.assertThat(after, equalTo(before.without(deletedContact)));
  }

}
