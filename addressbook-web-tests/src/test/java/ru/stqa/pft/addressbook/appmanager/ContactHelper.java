package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submit(String locator) {
    click(By.xpath(locator));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getFerstEmail());
    type(By.name("email3"), contactData.getThirdEmail());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());
    if (creation) {
      if (! isElementPresent(By.name("new_group").getText().equals("test1"))
       {
        new GroupHelper(wd).createGroup(new GroupData("test1", null, null));
      }
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getAddGroup());
    } else {
      Assert.assertFalse((isElementPresent(By.name("new_group"))));
    }
    type(By.name("notes"), contactData.getNotesText());

  }

  public void selectContact(String locator) {
    submit(locator);
  }

  public void deleteSelectedContact(String locator) {
    click(By.xpath(locator));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void goToContactCreatForm(String s) {
    click(By.linkText(s));
  }

  public void createContact(ContactData contact, boolean creation) {
    goToContactCreatForm("add new");
    fillContactForm(contact, creation);
    submit("(//input[@name='submit'])[2]");
    returnToGroupPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
  }
}
