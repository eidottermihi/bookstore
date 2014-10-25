package de.bookstore.model.dao;

import de.bookstore.model.entity.Author;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao extends AbstractGenericDao<Author, Long> {

  @Override
  public Long getPrimaryKey(Author persistentObject) {
    return persistentObject.getId();
  }

}
