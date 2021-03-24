package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactModificationTests extends TestBase {

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
  public void modificationContactTest() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();

    // модифицируем контакт
    modifiedContact
            .withName("Anna")
            .withLastname("Kortikova")
            .withAddress("Vien 1030 Landstrasse 40")
            .withMobilePhone("10106001213")
            .withNotesText("Lastname and address have changed");

    // формируем список контактов за исключением того, что мы модифицировали
    List<ContactData> originalListExceptModified = before
            .stream()
            .filter(c -> c.getId() != modifiedContact.getId())
            .collect(Collectors.toList());

    // меняем контакт
    app.contact().modifyContact(modifiedContact);
    app.goTo().homePage();

    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();

    // выбираем из базы ТОЛЬКО модифицированный контакт
    Optional<ContactData> edited = after.
            stream()
            .filter(c -> c.getId() == modifiedContact.getId())
            .findFirst();

    assertTrue(edited.isPresent());
    assertThat(modifiedContact, equalTo(edited.get()));

    // второй раз выбираем из базы все контакты, КРОМЕ модифицированного
    List<ContactData> afterListExceptModified = after
            .stream()
            .filter(c -> c.getId() != modifiedContact.getId())
            .collect(Collectors.toList());

    assertThat(afterListExceptModified, equalTo(originalListExceptModified));
  }
}

