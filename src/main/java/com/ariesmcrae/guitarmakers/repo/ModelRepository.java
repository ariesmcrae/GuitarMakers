package com.ariesmcrae.guitarmakers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.guitarmakers.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{

//	/**
//	 * Custom finder
//	 */
//	public List<Model> getModelsInPriceRange(BigDecimal lowest, BigDecimal highest) {
//		@SuppressWarnings("unchecked")
//		List<Model> mods = entityManager
//				.createQuery("select m from Model m where m.price >= :lowest and m.price <= :highest")
//				.setParameter("lowest", lowest)
//				.setParameter("highest", highest).getResultList();
//		return mods;
//	}
//
//	/**
//	 * Custom finder
//	 */
//	public List<Model> getModelsByPriceRangeAndWoodType(BigDecimal lowest, BigDecimal highest, String wood) {
//		@SuppressWarnings("unchecked")
//		List<Model> mods = entityManager
//				.createQuery("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
//				.setParameter("lowest", lowest)
//				.setParameter("highest", highest)
//				.setParameter("wood", "%" + wood + "%").getResultList();
//		return mods;
//	}
//
//	/**
//	 * NamedQuery finder
//	 */
//	public List<Model> getModelsByType(String modelType) {
//		@SuppressWarnings("unchecked")
//		List<Model> mods = entityManager
//				.createNamedQuery("Model.findAllModelsByType")
//				.setParameter("name", modelType).getResultList();
//		return mods;
//	}
//
//	/**
//	 * Count
//	 */
//	public Long getModelCount() {
//		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
//		cq.select(qb.count(cq.from(Model.class)));
//		return entityManager.createQuery(cq).getSingleResult();
//	}
}
