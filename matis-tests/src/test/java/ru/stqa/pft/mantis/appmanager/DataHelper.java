package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.models.MailMessage;
import ru.stqa.pft.mantis.models.User;
import ru.stqa.pft.mantis.models.Users;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertTrue;

public class DataHelper extends HelperBase{

  public DataHelper(ApplicationManager app) {
    super(app);
  }

  public Optional<User> createUser(){
    long now = System.currentTimeMillis();
    String email = String.format("user%s@localchost.localdomain", now);
    String user = String.format("user%s", now);
    String password = System.getProperty("userPassword");
    String name = String.format("user%sname", now);
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waiTForMail(2, 10000);
    String confirmationLink = app.registration().findLinkFromMailWithText(mailMessages, email, "Спасибо за регистрацию.");
    app.registration().finish(confirmationLink, password, name);
    Users users = app.db().users();
    Optional<User> createdUser = users
            .stream()
            .filter((u) -> u.getEmail().equals(email))
            .findFirst();
    assertTrue(createdUser.isPresent());
    return createdUser;
  }

  public void loginUI() throws ClassNotFoundException {
    wd.get(app.getProperty("web.baseUrl") + "login_page.php");
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys("administrator");
    wd.findElement(By.xpath("//input[@value='Вход']")).click();
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("root");
    wd.findElement(By.xpath("//input[@value='Вход']")).click();
  }

}
