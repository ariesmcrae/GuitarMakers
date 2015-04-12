package com.ariesmcrae.guitarmakers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.guitarmakers.model.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

//	/**
//	 * Custom finder
//	 */
//	public List<Manufacturer> getManufacturersFoundedBeforeDate(Date date) {
//		@SuppressWarnings("unchecked")
//		List<Manufacturer> mans = entityManager
//				.createQuery("select m from Manufacturer m where m.foundedDate < :date")
//				.setParameter("date", date).getResultList();
//		return mans;
//	}
//
//	/**
//	 * Custom finder
//	 */
//	public Manufacturer getManufacturerByName(String name) {
//		Manufacturer man = (Manufacturer)entityManager
//				.createQuery("select m from Manufacturer m where m.name like :name")
//				.setParameter("name", name + "%").getSingleResult();
//		return man;
//	}
//
//	/**
//	 * Native Query finder
//	 */
//	public List<Manufacturer> getManufacturersThatSellModelsOfType(String modelType) {
//		@SuppressWarnings("unchecked")
//		List<Manufacturer> mans = entityManager
//				.createNamedQuery("Manufacturer.getAllThatSellAcoustics")
//				.setParameter(1, modelType).getResultList();
//		return mans;
//	}
}
