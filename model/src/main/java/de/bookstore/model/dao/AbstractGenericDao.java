package de.bookstore.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractGenericDao<Entity, PrimaryKey extends Serializable>
		implements GenericDao<Entity, PrimaryKey> {
	protected final static Logger LOGGER = LoggerFactory
			.getLogger(GenericDao.class);

	protected final Class<Entity> entityClass;

	protected final Class<PrimaryKey> primaryKeyClass;

	@PersistenceContext
	private EntityManager entityManager;

	{
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Type[] actualTypeArguments = type.getActualTypeArguments();

		@SuppressWarnings("unchecked")
		Class<Entity> entityClass = (Class<Entity>) actualTypeArguments[0];
		this.entityClass = entityClass;

		@SuppressWarnings("unchecked")
		Class<PrimaryKey> primaryKey = (Class<PrimaryKey>) actualTypeArguments[1];
		this.primaryKeyClass = primaryKey;
	}

	@Override
	public PrimaryKey create(Entity newPersistentObject) {
		LOGGER.debug("Persisting {}...", newPersistentObject);
		entityManager.persist(newPersistentObject);
		return getPrimaryKey(newPersistentObject);
	}

	@Override
	public void update(Entity persistentObject) {
		entityManager.merge(persistentObject);
	}

	@Override
	public void remove(Entity persistentObject) {
		entityManager.remove(persistentObject);
	}

	@Override
	public Entity findByPrimaryKey(PrimaryKey key) {
		return entityManager.find(this.entityClass, key);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
