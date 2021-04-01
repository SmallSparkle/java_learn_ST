package ru.stqa.pft.mantis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.models.Issue;
import ru.stqa.pft.mantis.models.IssueBugify;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;


public class TestBase {
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));


  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "mantisbt-2.25.0/config/config_inc.php", "mantisbt-2.25.0/config/config_inc.php.back");
  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.ftp().restore("mantisbt-2.25.0/config/config_inc.php.back", "mantisbt-2.25.0/config/config_inc.php");
    app.stop();
  }

  public boolean isIssueOpenMantis(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    Issue issue = app.soap().getIssue(issueId);
    if (issue.getStatus().equals("resolved")) {
      return false;
    } else {
      return true;
    }
  }

  public boolean isIssueOpenBugify(int issueId) {
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId)).asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<IssueBugify> issue = new Gson().fromJson(issues, new TypeToken<Set<IssueBugify>>() {
    }.getType());
    return !issue.iterator().next().getState().equals("3");
  }

  public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    //   if (isIssueOpenMantis(issueId)) {
    if (isIssueOpenBugify(issueId)) {
      System.out.println("Ignored because of issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
