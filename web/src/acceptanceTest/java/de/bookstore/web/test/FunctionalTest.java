package de.bookstore.web.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest extends AbstractBookstoreTest {

  @Before
  public void setup() {
    driver = new FirefoxDriver();
    String url = System.getenv("selenium.baseUrl");
    driver.get(url);
  }

  @Test
  public void functionalTest1() {
    WebElement newAutorLink = driver.findElement(By.linkText("New author"));
    assertThat(newAutorLink.getText(), is("New author"));
  }

  @Test
  public void functionalTest2() {
    WebElement newAutorLink = driver.findElement(By.linkText("New author"));
    assertThat(newAutorLink.getText(), is("New author"));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
