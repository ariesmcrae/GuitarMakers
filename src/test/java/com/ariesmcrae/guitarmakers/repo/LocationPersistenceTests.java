package com.ariesmcrae.guitarmakers.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ariesmcrae.guitarmakers.Application;
import com.ariesmcrae.guitarmakers.model.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class LocationPersistenceTests {
	@Autowired
	private LocationRepository repo;


	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		Location location = new Location();
		location.setCountry("Canada");
		location.setState("British Columbia");
		location = repo.saveAndFlush(location);
		
		Location otherLocation = repo.findOne(location.getId());
		assertEquals("Canada", otherLocation.getCountry());
		assertEquals("British Columbia", otherLocation.getState());
		
		//delete BC location now
		repo.delete(otherLocation);
	}

	@Test
	public void testFindWithLike() throws Exception {
		List<Location> locs = repo.findByStateLike("New%");
		assertEquals(4, locs.size());
	}

	@Test
	@Transactional  //note this is needed because we will get a lazy load exception unless we are in a tx
	public void testFindWithChildren() throws Exception {
		Location arizona = repo.findOne(3L);
		assertEquals("United States", arizona.getCountry());
		assertEquals("Arizona", arizona.getState());
		
		assertEquals(1, arizona.getManufacturers().size());
		
		assertEquals("Fender Musical Instruments Corporation", arizona.getManufacturers().get(0).getName());
	}
	
	
	@Test
	public void testJpaAnd() {
		List<Location> locations = repo.findByCountryAndState("United States", "Utah");
		assertTrue(locations != null && locations.size() == 1);
		assertEquals("Utah", locations.iterator().next().getState());
	}
	
	
	@Test
	public void testJpaOr() {
		List<Location> locations = repo.findByCountryOrState("Vermont", "Texas");
		assertTrue(locations != null && locations.size() == 1);
	}
}
