package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final GroupHelper groupHelper = new GroupHelper();

  public void init() {
    groupHelper.wd = new ChromeDriver();
    groupHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper.wd.get("http://localhost/addressbook/index.php");
    login("admin", "secret");
  }

  public void login(String userName, String password) {
    groupHelper.wd.findElement(By.name("user")).clear();
    groupHelper.wd.findElement(By.name("user")).sendKeys(userName);
    groupHelper.wd.findElement(By.name("pass")).click();
    groupHelper.wd.findElement(By.name("pass")).clear();
    groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
    groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logout() {
    groupHelper.wd.findElement(By.linkText("Logout")).click();
  }

  public void goToGroupPage() {
    groupHelper.wd.findElement(By.linkText("groups")).click();
  }

  public void goToHomePage() {
    groupHelper.wd.findElement(By.linkText("home")).click();
  }

  public void submitContactCreation() {
    groupHelper.wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    groupHelper.wd.findElement(By.name("firstname")).click();
    groupHelper.wd.findElement(By.name("firstname")).clear();
    groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    groupHelper.wd.findElement(By.name("middlename")).click();
    groupHelper.wd.findElement(By.name("middlename")).clear();
    groupHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    groupHelper.wd.findElement(By.name("lastname")).click();
    groupHelper.wd.findElement(By.name("lastname")).clear();
    groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    groupHelper.wd.findElement(By.name("address")).click();
    groupHelper.wd.findElement(By.name("address")).clear();
    groupHelper.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    groupHelper.wd.findElement(By.name("home")).click();
    groupHelper.wd.findElement(By.name("home")).clear();
    groupHelper.wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
    groupHelper.wd.findElement(By.name("mobile")).click();
    groupHelper.wd.findElement(By.name("mobile")).clear();
    groupHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
    groupHelper.wd.findElement(By.name("email")).click();
    groupHelper.wd.findElement(By.name("email")).clear();
    groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getFerstEmail());
    groupHelper.wd.findElement(By.name("email3")).click();
    groupHelper.wd.findElement(By.name("email3")).clear();
    groupHelper.wd.findElement(By.name("email3")).sendKeys(contactData.getThirdEmail());
    groupHelper.wd.findElement(By.name("bday")).click();
    new Select(groupHelper.wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    groupHelper.wd.findElement(By.name("bmonth")).click();
    new Select(groupHelper.wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    groupHelper.wd.findElement(By.name("byear")).click();
    groupHelper.wd.findElement(By.name("byear")).clear();
    groupHelper.wd.findElement(By.name("byear")).sendKeys(contactData.getByear());
    groupHelper.wd.findElement(By.name("new_group")).click();
    new Select(groupHelper.wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getAddGroup());
    groupHelper.wd.findElement(By.name("notes")).click();
    groupHelper.wd.findElement(By.name("notes")).clear();
    groupHelper.wd.findElement(By.name("notes")).sendKeys(contactData.getNotesText());
  }

  public void goToContactCreatForm(String s) {
    groupHelper.wd.findElement(By.linkText(s)).click();
  }

  public void stop() {
    groupHelper.wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
