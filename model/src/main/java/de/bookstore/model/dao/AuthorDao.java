package de.bookstore.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import de.bookstore.model.entity.Author;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao extends AbstractGenericDao<Author, Long> implements AuthorDaoI {

  @Override
  public Long getPrimaryKey(Author persistentObject) {
    return persistentObject.getId();
  }

  @Override
  public List<Author> findAll() {
    return getEntityManager().createNamedQuery(Author.FIND_ALL, Author.class).getResultList();
  }

  @Override
  public List<Author> search(String firstname, String lastname, String mail) {
    TypedQuery<Author> namedQuery = getEntityManager()
        .createNamedQuery(Author.SEARCH, Author.class);
    namedQuery.setParameter("firstname", firstname);
    namedQuery.setParameter("lastname", lastname);
    namedQuery.setParameter("mail", mail);
    return namedQuery.getResultList();
  }
}
