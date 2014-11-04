package de.bookstore.web.config;

import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import de.bookstore.service.ServiceConfig;
import de.bookstore.web.BookstoreWicketApplication;

@Configuration
@Profile("dev")
@Import(ServiceConfig.class)
public class WebConfig {

  @Bean
  public WebApplication webapp() {
    return new BookstoreWicketApplication();
  }

}
