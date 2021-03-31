package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.models.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class RegistrationTest extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }


  @Test
  public void testRegistration() throws IOException {
    long now = System.currentTimeMillis();
    String email = String.format("user%s@localchost.localdomain", now);
    String user = String.format("user%s", now);
    String password = "password";
    String name = String.format("user%sname", now);
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waiTForMail(2, 10000);
    String confirmationLink = app.registration().findLinkFromMailWithText(mailMessages, email, "Спасибо за регистрацию.");
    app.registration().finish(confirmationLink, password, name);
    assertTrue( app.newSession().login(user, password));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() throws MessagingException {
    app.mail().stop();
  }
}
