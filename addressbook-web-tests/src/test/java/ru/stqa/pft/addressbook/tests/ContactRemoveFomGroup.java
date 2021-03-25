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
    Groups groups = app.db().groups();
    for (GroupData g : groups) {
      if (g.getContacts().size() == 0) {
        ContactData contact = app.db().contacts().iterator().next();
        app.goTo().homePage();
        app.contact().addToGroup(contact, g);
      }
    }
    app.goTo().homePage();
  }

  @Test
  public void testRemoveContactFromGroup() {
    //ищем группу в которой есть контакты
    Groups groups = app.db().groups();
    Optional<GroupData> groupWithContacts = groups
            .stream()
            .filter((g) -> g.getContacts().size() > 0)
            .findFirst();
    assertTrue(groupWithContacts.isPresent());
    int groupID = groupWithContacts.get().getId();
    int contactId = groupWithContacts.get().getContacts()
            .stream()
            .findFirst().get().getId();

    //удаляем контакт из группы
    app.group().removeContact(groupID, contactId);

    //убеждаемся что группа и контакт не удалены
    Optional<GroupData> group = app.db().groups()
            .stream()
            .filter((g) -> g.getId() == groupID)
            .findFirst();
    System.out.println("!!!!!!");
    System.out.println(groupID);
    System.out.println(group.get().getId());

    Optional<ContactData> contact = app.db().contacts()
            .stream()
            .filter((c) -> c.getId() == contactId)
            .findFirst();
    System.out.println("!!!!!!");
    System.out.println(contactId);
    System.out.println(contact.get().getId());

    assertThat(groupID, equalTo(group.get().getId()));
    assertThat(contactId, equalTo(contact.get().getId()));
    //убеждаемся что контакт не входит в группу
    assertFalse(contact.get().getGroups().contains(group));


  }


}
