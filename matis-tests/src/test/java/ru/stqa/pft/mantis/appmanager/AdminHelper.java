package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AdminHelper extends HelperBase {
  protected ApplicationManager app;
  protected WebDriver wd;

  public AdminHelper(ApplicationManager app) {
    super(app);
  }

//  public AdminHelper(ApplicationManager app) {
//    this.app = app;
//    this.wd = app.getDriver();
//  }

  public void changePassword(String userID) {
    goToMenu("//div[@id='sidebar']/ul/li[6]");
    wd.findElements(By.cssSelector("ul[class='nav.nav-tabs.padding-18']>li")).get(1).click();
    wd.findElement(By.linkText(String.format("manage_user_edit_page.php?user_id=%s" + userID))).click();
    click(By.cssSelector("//input[@value='Сбросить пароль']"));
  }

  public void goToMenu(String s) {
    wd.findElement(By.xpath(s)).click();
  }
}
