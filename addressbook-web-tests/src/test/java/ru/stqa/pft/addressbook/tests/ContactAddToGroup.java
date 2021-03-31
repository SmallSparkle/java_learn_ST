package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Optional;

import static org.testng.Assert.*;

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
    Groups originalListGroups = app.db().groups();
    Contacts originalListContacts = app.db().contacts();
    ContactData foundContact = app.contact().findFreeContact(originalListGroups, originalListContacts);
    // обходим все группы в поисках той; которой нет у контакта
    GroupData foundGroup = app.group().findFreeGroup(originalListGroups, foundContact);

    if (foundGroup == null) {
      // надо создать группу и присвоить её в переменную foundGroup
      app.goTo().groupPage();
      app.group().createGroupObject(new GroupData().withName("test1"));
      foundGroup = app.db().groups().stream().skip(originalListGroups.size()).findFirst().get();
    }

    app.goTo().homePage();
    app.contact().addToGroup(foundContact, foundGroup);

    //проверяем что спсок контактов не изменился
    Contacts afterListContacts = app.db().contacts();
    assertEquals(originalListContacts.size(), afterListContacts.size());
    System.out.println(foundGroup);
    System.out.println(foundContact);

    // нам нужно еще раз выбрать контакт из базы потому что foundContact не содержит новых групп
    int id = foundContact.getId();
    Optional<ContactData> updatedContact = afterListContacts
            .stream()
            .filter((c) -> c.getId() == id)
            .findFirst();

    //проверяем что в списке групп контакта есть добавленная группа
    assertTrue(updatedContact.get().getGroups().contains(foundGroup));
  }

}


