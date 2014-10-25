package de.bookstore.model.dao;

import java.util.List;

import de.bookstore.model.entity.Book;

public interface BookDaoI extends GenericDao<Book, Long> {

  List<Book> findAll();

}