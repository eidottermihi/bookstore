package de.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import de.bookstore.model.dao.AuthorDaoI;
import de.bookstore.model.entity.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Authors implements IAuthors {

  @Autowired
  private AuthorDaoI authorDao;

  @Override
  public Author create(String firstname, String lastname, String mail) {
    Author author = new Author();
    author.setFirstname(firstname);
    author.setLastname(lastname);
    author.setMail(mail);
    Long id = authorDao.create(author);
    return authorDao.findByPrimaryKey(id);
  }

  @Override
  public List<Author> findAll() {
    return authorDao.findAll();
  }

  @Override
  public List<Author> search(String firstname, String lastname, String mail) {
    return authorDao.search(firstname, lastname, mail);
  }

}
