package de.bookstore.model.dao;

import java.util.List;

import de.bookstore.model.entity.Author;

public interface AuthorDaoI extends GenericDao<Author, Long> {

  List<Author> findAll();

  List<Author> search(String firstname, String lastname, String mail);

}
