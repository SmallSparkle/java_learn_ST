package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;


public class ContactHelper extends HelperBase {

  private Contacts contactCache = null;

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
    attach(By.name("photo"), contactData.getPhoto());
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

  public void fillModifyForm(ContactData contactData, boolean creation) {
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("notes"), contactData.getNotesText());
  }

  public int count() {
    return wd.findElements(By.xpath("(//input[@name='selected[]'])")).size();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();

  }

  public void selectEditContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).findElement(By.xpath("./../..")).
            findElement(By.cssSelector("img[title='Edit']")).click();
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

  public void createMinContact(ContactData contact, boolean creation) {
    goToContactCreateForm("add new");
    fillModifyForm(contact, creation);
    submit();
    contactCache = null;
    returnToPage("home page");
  }

  public void createContact(ContactData contact, boolean creation) {
    goToContactCreateForm("add new");
    fillContactForm(contact, creation);
    submit();
    contactCache = null;
    returnToPage("home");
  }

  public void modifyContact(ContactData contact) {
    selectEditContactById(contact.getId());
    fillModifyForm(contact, false);
    update();
    contactCache = null;
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    closeAlert();
  }

  public Contacts all() {
    if (contactCache != null) {
      return contactCache;
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cols = element.findElements(By.tagName("td"));
      String name = cols.get(2).getText();
      String lastname = cols.get(1).getText();
      String allPhones = cols.get(5).getText();
      String allEmails = cols.get(4).getText();
      String address = cols.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails)
              .withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    selectEditContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String home2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String emailFirst = wd.findElement(By.name("email")).getAttribute("value");
    String emailSecond = wd.findElement(By.name("email2")).getAttribute("value");
    String emailThird = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withSecondHomePhone(home2)
            .withFerstEmail(emailFirst).withSecondEmail(emailSecond).withThirdEmail(emailThird)
            .withAddress(address);
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    wd.findElement(By.name("to_group")).click();
    new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
    wd.findElement(By.name("add")).click();
  }

  public ContactData findFreeContact(Groups groups, Contacts contacts) {
    ContactData foundContact = null;
    // обходим контакты и пытаемся найти контакт который не во всех группах
    for (ContactData contact : contacts) {
      foundContact = contact;
      if (contact.getGroups().size() != groups.size()) {
        break;
      }
    }

    return foundContact;
  }

}
