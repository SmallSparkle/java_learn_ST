package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void clic(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    clic(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }
}
