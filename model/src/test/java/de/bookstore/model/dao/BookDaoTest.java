package de.bookstore.model.dao;

import javax.transaction.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import de.bookstore.model.config.ModelDevConfig;
import de.bookstore.model.entity.Author;
import de.bookstore.model.entity.Book;

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
public class BookDaoTest {

  @Autowired
  private BookDao bookDao;

  @Autowired
  private AuthorDao authorDao;

  @Test
  @DatabaseSetup("bookDao_insert_setup.xml")
  @ExpectedDatabase(value = "bookDao_insert_result.xml", table = "BOOK",
      assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void insert() {
    // Given
    Author author = authorDao.findByPrimaryKey(1L);
    // When
    Book book = new Book();
    book.setTitle("Test_insert");
    book.setYear(2014);
    book.setAuthor(author);
    Long id = bookDao.create(book);
    // Then
    assertNotNull(id);
  }

  @Test
  @DatabaseSetup("bookDao_read_setup.xml")
  public void read() {
    Book book = bookDao.findByPrimaryKey(1L);
    assertNotNull(book);
    assertEquals(Long.valueOf(1L), book.getId());
    assertEquals(0, book.getVersion());
    assertEquals("Titel1", book.getTitle());
    assertEquals(2014, book.getYear());
    assertNotNull(book.getAuthor());
    assertEquals(Long.valueOf(1L), book.getAuthor().getId());
  }
}
