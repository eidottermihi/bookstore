package de.bookstore.model.dao;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import de.bookstore.model.config.ModelDevConfig;
import de.bookstore.model.entity.Author;
import de.bookstore.model.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ModelDevConfig.class }, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class,
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
	@ExpectedDatabase(value = "bookDao_insert_result.xml", table = "BOOK", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void insert() {
		// Given
		Author a = authorDao.findByPrimaryKey(1L);
		// When
		Book b = new Book();
		b.setTitle("Test_insert");
		b.setYear(2014);
		b.setAuthor(a);
		Long id = bookDao.create(b);
		// Then
		assertNotNull(id);
	}

	@Test
	@DatabaseSetup("bookDao_read_setup.xml")
	public void read() {
		Book book = bookDao.findByPrimaryKey(1L);
		assertNotNull(book);
	}
}
