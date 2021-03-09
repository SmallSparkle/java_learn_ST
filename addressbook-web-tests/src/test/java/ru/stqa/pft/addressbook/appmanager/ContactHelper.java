package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void update() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void submit() {
    click(By.xpath("(//input[@name='submit'])[2]"));
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
      new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
    } else {
      Assert.assertFalse((isElementPresent(By.name("new_group"))));
    }
    type(By.name("notes"), contactData.getNotesText());

  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("(//input[@name='selected[]'])")).get(index).click();

  }

  public void selectEditContact(int index) {
    wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();
//    "entry"
//    id="maintable"
//    class name="entry"
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void goToContactCreateForm(String s) {
    click(By.linkText(s));
  }

  public void createContact(ContactData contact, boolean creation) {
    goToContactCreateForm("add new");
    fillContactForm(contact, creation);
    submit();
    returnToPage("home page");
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("(//input[@name='selected[]'])")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
//    List<WebElement> elements2 = wd.findElements(By.cssSelector("tr.entry td[2]"));
//    for (WebElement element2 : elements2) {
      for (WebElement element:elements) {
        String name = element.getText();
        ContactData contact = new ContactData(name, null);
        contacts.add(contact);
      }
//      String middlename = element2.getText();
//      ContactData contact = new ContactData(null, middlename);
//      contacts.add(contact);

//    }
    return contacts;
  }
}
