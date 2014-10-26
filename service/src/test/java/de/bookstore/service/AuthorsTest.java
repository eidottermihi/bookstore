package de.bookstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import de.bookstore.model.entity.Author;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class,
    loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
public class AuthorsTest {

  @Autowired
  private IAuthors authors;

  @Test
  public void create() {
    Author author = authors.create("Michael", "Prankl", "michael-prankl@web.de");
    assertNotNull(author);
  }

  @Test
  public void findAll() {
    List<Author> all = authors.findAll();
    assertNotNull(all);
    assertEquals(2, all.size());
  }

  @Test
  public void search() {
    List<Author> list = authors.search("aFirstname", "aLastname", "some@mail.com");
    assertNotNull(list);
    assertEquals(1, list.size());
  }
}
