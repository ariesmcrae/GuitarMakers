package com.ariesmcrae.guitarmakers.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ariesmcrae.guitarmakers.model.ModelType;

@Repository
public class ModelTypeRepository {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Create
	 */
	public ModelType create(ModelType mt) {
		entityManager.persist(mt);
		entityManager.flush();
		return mt;
	}

	/**
	 * Update
	 */
	public ModelType update(ModelType mt) {
		mt = entityManager.merge(mt);
		entityManager.flush();
		return mt;
	}

	/**
	 * Delete
	 */
	public void delete(ModelType mt) {
		entityManager.remove(mt);
		entityManager.flush();
	}

	/**
	 * Find
	 */
	public ModelType find(Long id) {
		return entityManager.find(ModelType.class, id);
	}
}
