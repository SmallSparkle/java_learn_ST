package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().createGroup(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testUntitledTestCase() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("Anna").withMiddlename("Amina").withLastname("Bespalova")
            .withAddress("Moscow Lenina 10").withHomePhone("4959880012")
            .withMobilePhone("9660001213").withFerstEmail("some@some.mail")
            .withThirdEmail("some2@some.mail").withBday("5").withBmonth("May")
            .withByear("1987").withNotesText("test notes");
    app.contact().createContact(contact, true);

    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
