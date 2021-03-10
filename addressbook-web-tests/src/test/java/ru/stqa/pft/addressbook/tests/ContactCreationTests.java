package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().createGroup(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testUntitledTestCase() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withName("Anna").withMiddlename("Amina").withLastname("Bespalova")
            .withAddress("Moscow Lenina 10").withHomePhone("4959880012")
            .withMobilePhone("9660001213").withFerstEmail("some@some.mail")
            .withThirdEmail("some2@some.mail").withBday("5").withBmonth("May")
            .withByear("1987").withNotesText("test notes");
    app.contact().createContact(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
