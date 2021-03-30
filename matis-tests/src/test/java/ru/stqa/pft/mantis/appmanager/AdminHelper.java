package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.models.UserData;

import java.util.Optional;


public class AdminHelper extends HelperBase {
  public AdminHelper(ApplicationManager app) {
    super(app);
  }

//  public AdminHelper(ApplicationManager app) {
//    this.app = app;
//    this.wd = app.getDriver();
//  }

  public void changePassword(Optional<UserData> user) throws InterruptedException {
    wd.findElement(By.cssSelector("a[href*='manage_overview_page']")).click();
    wd.findElements(By.cssSelector(".nav-tabs > li")).get(1).click();
//    wd.navigate().refresh();
//    Thread.sleep(3000);
    wd.findElement(By.linkText(String.format("manage_user_edit_page.php?user_id=%s", user.get().getId()))).click();
    click(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input"));
  }

}
