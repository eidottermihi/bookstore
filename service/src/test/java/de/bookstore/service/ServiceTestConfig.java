package de.bookstore.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import de.bookstore.model.dao.AuthorDaoI;
import de.bookstore.model.entity.Author;
import de.bookstore.model.entity.Book;

@Configuration
@Profile("test")
public class ServiceTestConfig {

  @Bean
  public AuthorDaoI authorDao() {
    AuthorDaoI mock = Mockito.mock(AuthorDaoI.class);
    when(mock.findByPrimaryKey(Mockito.anyLong())).thenReturn(author());
    when(mock.findAll()).thenReturn(allAuthors());
    when(mock.search(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(
        searchAuthors());
    return mock;
  }

  private List<Author> searchAuthors() {
    List<Author> searchAuthors = new ArrayList<Author>();
    searchAuthors.add(author());
    return searchAuthors;
  }

  private List<Author> allAuthors() {
    List<Author> allAuthors = new ArrayList<Author>();
    allAuthors.add(author());
    allAuthors.add(author());
    return allAuthors;
  }

  private Author author() {
    Author author = new Author();
    author.setId(Long.valueOf(1));
    author.setFirstname("Firstname");
    author.setLastname("Lastname");
    author.setMail("some@mail.com");
    author.setVersion(0);
    author.setBooks(new HashSet<Book>());
    return author;
  }

  @Bean
  public IAuthors authors() {
    return new Authors();
  }

}
