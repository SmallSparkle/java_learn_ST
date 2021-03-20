package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {}.getType());//List<GroupData>.class
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test
  public void testUntitledTestCase(ContactData contact) {
    Contacts before = app.contact().all();
//    File photo = new File("src/test/resources/asd. jpg");
//    ContactData contact = new ContactData()
//            .withName("Anna").withMiddlename("Amina").withLastname("Bespalova").withPhoto(photo)
//            .withAddress("Moscow Lenina 10").withHomePhone("4959880012")
//            .withMobilePhone("9660001213").withFerstEmail("some@some.mail")
//            .withThirdEmail("some2@some.mail").withBday("5").withBmonth("May")
//            .withByear("1987").withNotesText("test notes");
    app.contact().createContact(contact, true);

    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
