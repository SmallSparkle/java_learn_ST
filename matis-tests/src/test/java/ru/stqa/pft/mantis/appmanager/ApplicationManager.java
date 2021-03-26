package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

  public WebDriver wd;
  private String browser;
  private final Properties properties;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if (browser.equals(CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(IE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  public void stop() {
    wd.quit();
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
