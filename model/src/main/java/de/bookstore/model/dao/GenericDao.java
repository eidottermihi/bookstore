package de.bookstore.model.dao;

import java.io.Serializable;

public interface GenericDao<EntityT, PrimaryKeyT extends Serializable> {
  PrimaryKeyT create(EntityT newPersistentObject);

  void update(EntityT persistentObject);

  void remove(EntityT persistentObject);

  EntityT findByPrimaryKey(PrimaryKeyT key);

  PrimaryKeyT getPrimaryKey(EntityT persistentObject);
}
