package de.bookstore.model.dao;

import org.springframework.stereotype.Repository;

import de.bookstore.model.entity.Author;

@Repository
public class AuthorDao extends AbstractGenericDao<Author, Long> {

	@Override
	public Long getPrimaryKey(Author persistentObject) {
		return persistentObject.getId();
	}

}
