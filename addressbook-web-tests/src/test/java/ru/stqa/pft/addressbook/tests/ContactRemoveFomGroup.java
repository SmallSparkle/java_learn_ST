package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ContactRemoveFomGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().createGroup(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.contact().createMinContact(new ContactData()
              .withLastname("Bespalova")
              .withAddress("Moscow Lenina 10")
              .withMobilePhone("9660001213")
              .withNotesText("test notes"), true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testRemoveContactFromGroup() {
    Groups groups = app.db().groups();
    int groupID = 0;
    int contactId = 0;
    for (GroupData gr : groups) {
      if (gr.getContacts().size() == 0) {
        groupID = gr.getId();
        ContactData contact = app.db().contacts().iterator().next();
        contactId = contact.getId();
        app.goTo().homePage();
        app.contact().addToGroup(contact, gr);
        app.goTo().homePage();
      } else {
    //ищем группу в которой есть контакты
    Optional<GroupData> groupWithContacts = groups
            .stream()
            .filter((g) -> g.getContacts().size() > 0)
            .findFirst();
    assertTrue(groupWithContacts.isPresent());
    groupID = groupWithContacts.get().getId();
    contactId = groupWithContacts.get().getContacts()
            .stream()
            .findFirst().get().getId();
      }
    }

    //удаляем контакт из группы
    app.group().removeContact(groupID, contactId);

    //убеждаемся что группа и контакт не удалены
    int finalGroupID = groupID;
    Optional<GroupData> group = app.db().groups()
            .stream()
            .filter((g) -> g.getId() == finalGroupID)
            .findFirst();

    int finalContactId = contactId;
    Optional<ContactData> contact = app.db().contacts()
            .stream()
            .filter((c) -> c.getId() == finalContactId)
            .findFirst();

    assertThat(finalGroupID, equalTo(group.get().getId()));
    assertThat(finalContactId, equalTo(contact.get().getId()));
    //убеждаемся что контакт не входит в группу
    assertFalse(contact.get().getGroups().contains(group));


  }


}
