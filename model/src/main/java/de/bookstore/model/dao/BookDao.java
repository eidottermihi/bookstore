package de.bookstore.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.bookstore.model.entity.Book;

@Repository
public class BookDao extends AbstractGenericDao<Book, Long> implements BookDaoI {

  @Override
  public Long getPrimaryKey(Book persistentObject) {
    return persistentObject.getId();
  }

  /*
   * (non-Javadoc)
   * 
   * @see de.bookstore.model.dao.BookDaoI#findAll()
   */
  @Override
  public List<Book> findAll() {
    return getEntityManager().createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
  }

}
