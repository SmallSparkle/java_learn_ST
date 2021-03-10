package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.group().createGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void deletionsGroupTest() {
    List<GroupData> before = app.group().List();
    int index = before.size() - 1;
    app.group().selectGroup(index);
    app.group().deleteSelectedGroups();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().List();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}


