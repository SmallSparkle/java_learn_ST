package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup(By.name("selected[]"))) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("modification", "test modif", "Test"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToPage("group page");
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }

}
