package de.bookstore.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractGenericDao<EntityT, PrimaryKeyT extends Serializable> implements
    GenericDao<EntityT, PrimaryKeyT> {
  protected static final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);

  protected final Class<EntityT> entityClass;

  protected final Class<PrimaryKeyT> primaryKeyClass;

  @PersistenceContext
  private EntityManager entityManager;

  {
    ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
    Type[] actualTypeArguments = type.getActualTypeArguments();

    @SuppressWarnings("unchecked")
    Class<EntityT> entityClass = (Class<EntityT>) actualTypeArguments[0];
    this.entityClass = entityClass;

    @SuppressWarnings("unchecked")
    Class<PrimaryKeyT> primaryKey = (Class<PrimaryKeyT>) actualTypeArguments[1];
    this.primaryKeyClass = primaryKey;
  }

  @Override
  public PrimaryKeyT create(EntityT newPersistentObject) {
    LOGGER.debug("Persisting {}...", newPersistentObject);
    entityManager.persist(newPersistentObject);
    return getPrimaryKey(newPersistentObject);
  }

  @Override
  public void update(EntityT persistentObject) {
    entityManager.merge(persistentObject);
  }

  @Override
  public void remove(EntityT persistentObject) {
    entityManager.remove(persistentObject);
  }

  @Override
  public EntityT findByPrimaryKey(PrimaryKeyT key) {
    return entityManager.find(this.entityClass, key);
  }

  public EntityManager getEntityManager() {
    return this.entityManager;
  }

}
