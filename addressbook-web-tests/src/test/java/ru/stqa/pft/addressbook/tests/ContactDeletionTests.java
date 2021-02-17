package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
  @Test
  public void deletionContactTest(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact( "(//input[@name='selected[]'])");
    app.getContactHelper().deleteSelectedContact("//input[@value='Delete']");
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();

  }

}
