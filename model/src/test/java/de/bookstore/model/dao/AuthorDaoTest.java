package de.bookstore.model.dao;

import javax.transaction.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import de.bookstore.model.config.ModelDevConfig;
import de.bookstore.model.entity.Author;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ModelDevConfig.class },
    loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@ActiveProfiles("dev")
@Transactional
public class AuthorDaoTest {

  @Autowired
  private BookDaoI bookDao;

  @Autowired
  private AuthorDao authorDao;

  @Test
  @ExpectedDatabase(value = "authorDao_insert_result.xml", table = "AUTHOR",
      assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void insert() {
    // When
    Author author = new Author();
    author.setFirstname("Firstname");
    author.setLastname("Lastname");
    author.setMail("firstname.lastname@mail.com");
    Long id = authorDao.create(author);
    // Then
    assertNotNull(id);
  }

  @Test
  @DatabaseSetup("authorDao_read_setup.xml")
  public void read() {
    // When
    Author author = authorDao.findByPrimaryKey(1L);
    // Then
    assertNotNull(author);
    assertEquals(new Long(1), author.getId());
    assertEquals(0, author.getVersion());
    assertEquals("Vorname", author.getFirstname());
    assertEquals("Nachname", author.getLastname());
    assertEquals("some@mail.com", author.getMail());
    assertNotNull(author.getBooks());
    assertEquals(0, author.getBooks().size());
  }
}
