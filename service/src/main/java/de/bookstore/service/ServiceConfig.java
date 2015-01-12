package de.bookstore.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import de.bookstore.model.config.ModelDevConfig;

@Configuration
@Profile("dev")
@Import(ModelDevConfig.class)
public class ServiceConfig {
  @Bean
  public IAuthors authors() {
    return new Authors();
  }
}
