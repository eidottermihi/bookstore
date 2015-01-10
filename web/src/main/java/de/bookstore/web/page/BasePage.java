package de.bookstore.web.page;

import java.io.IOException;
import java.util.Properties;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.springframework.core.io.ClassPathResource;

public class BasePage extends WebPage {

  private static final long serialVersionUID = 1L;

  public BasePage() {
    ClassPathResource classPathResource = new ClassPathResource("buildInfo.properties");
    Properties p = new Properties();
    String version = "";
    try {
      p.load(classPathResource.getInputStream());
      version = p.getProperty("version");
    } catch (IOException e) {
      // buildInfo not present
    }
    add(new Label("version", version));
  }

}
