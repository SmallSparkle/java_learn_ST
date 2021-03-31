package ru.stqa.pft.mantis.appmanager;

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
    String password = "password";
    String name = String.format("user%sname", now);
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waiTForMail(2, 10000);
    String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password, name);
    Users users = app.db().users();
    Optional<User> createdUser = users
            .stream()
            .filter((u) -> u.getEmail().equals(email))
            .findFirst();
    assertTrue(createdUser.isPresent());
    return createdUser;
  }
}
