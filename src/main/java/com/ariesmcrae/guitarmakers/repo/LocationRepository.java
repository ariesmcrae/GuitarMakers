package com.ariesmcrae.guitarmakers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.guitarmakers.model.Location;

@Repository("locationRepository")
public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findByStateLike(String stateName);
	
	List<Location> findByCountryOrState(String value, String value2);
	
	List<Location> findByCountryAndState(String country, String state);

}
