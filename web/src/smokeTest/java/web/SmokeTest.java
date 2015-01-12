package web;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SmokeTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
  }

  @Test
  public void check_availability_and_version() {
    String baseUrl = System.getProperty("selenium.baseUrl");
    driver.get(baseUrl);
    String versionCode = driver.findElement(By.id("version")).getText();
    assertThat(versionCode, CoreMatchers.is(System.getProperty("bookstore.version")));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
