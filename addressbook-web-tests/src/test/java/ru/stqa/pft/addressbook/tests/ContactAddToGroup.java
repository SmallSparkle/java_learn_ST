package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactAddToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().createGroup(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
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
  public void testAddContactToGroup() {
    Contacts originalListContacts = app.db().contacts();
    ContactData addedContact = originalListContacts.iterator().next();
    Groups originalListGroups = app.db().groups();
    GroupData group = originalListGroups.iterator().next();
    app.contact().addToGroup(addedContact, group);

    //проверяем что спсок контактов не изменился
    Contacts afterListContacts = app.db().contacts();
    assertEquals(originalListContacts.size(), afterListContacts.size());

    //проверяем что в списке групп контакта есть добавленная группа
    assertTrue(addedContact.getGroups().contains(group));
  }

}


