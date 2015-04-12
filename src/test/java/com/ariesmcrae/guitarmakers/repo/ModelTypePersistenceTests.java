package com.ariesmcrae.guitarmakers.repo;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ariesmcrae.guitarmakers.Application;
import com.ariesmcrae.guitarmakers.model.ModelType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ModelTypePersistenceTests {
	@Autowired
	private ModelTypeRepository modelTypeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		ModelType mt = new ModelType();
		mt.setName("Test Model Type");
		mt = modelTypeRepository.save(mt);
		
		// clear the persistence context so we don't return the previously cached location object
		// this is a test only thing and normally doesn't need to be done in prod code
		entityManager.clear();

		ModelType otherModelType = modelTypeRepository.findOne(mt.getId());
		assertEquals("Test Model Type", otherModelType.getName());
		
		modelTypeRepository.delete(otherModelType);
	}

	@Test
	public void testFind() throws Exception {
		ModelType mt = modelTypeRepository.findOne(1L);
		assertEquals("Dreadnought Acoustic", mt.getName());
	}
}
