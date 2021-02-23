package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


public class ContactModificationTests extends TestBase {
  @Test
  public void modificationContactTest() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup(By.name("selected[]"))) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact(By.xpath("//img[@alt='Edit']"))) {
      app.getContactHelper().createContact(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 10", "4959880012", "9660001213", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), true);
    }
    app.getContactHelper().selectContact("//img[@alt='Edit']");
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Amina", "Bespalova", "Moscow Lenina 25", "4959880012", "0001120003", "some@some.mail", "some2@some.mail", "5", "May", "1987", "test notes"), false);
    app.getContactHelper().submit("(//input[@name='update'])[2]");

    //wd.findElement(By.xpath("//img[@alt='Edit']")).click();
//    wd.findElement(By.name("address")).click();
//    wd.findElement(By.name("address")).clear();
//    wd.findElement(By.name("address")).sendKeys("Moscow Lenina 25");
//    wd.findElement(By.xpath("//form[@action='edit.php']")).click();
//    wd.findElement(By.name("mobile")).clear();
//    wd.findElement(By.name("mobile")).sendKeys("111223346");
//    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click(), "(//input[@name='submit'])[2]";
  }

}

