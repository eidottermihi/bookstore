package de.bookstore.model.dao;

import java.io.Serializable;

public interface GenericDao<Entity, PrimaryKey extends Serializable> {
	PrimaryKey create(Entity newPersistentObject);

	void update(Entity persistentObject);

	void remove(Entity persistentObject);

	Entity findByPrimaryKey(PrimaryKey key);

	PrimaryKey getPrimaryKey(Entity persistentObject);
}
