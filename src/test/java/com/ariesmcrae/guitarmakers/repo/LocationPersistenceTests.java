package com.ariesmcrae.guitarmakers.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

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
	public void testAnd() {
		List<Location> locations = repo.findByCountryAndState("United States", "Utah");
		assertTrue(locations != null);
		assertEquals(1, locations.size());
		assertEquals("Utah", locations.iterator().next().getState());
	}
	
	
	@Test
	public void testOr() {
		List<Location> locations = repo.findByCountryOrState("Vermont", "Texas");
		assertTrue(locations != null);
		assertEquals(1, locations.size());		
	}
	
	
	@Test
	public void testIs() {
		Location location = repo.findByStateIs("California");
		assertNotNull(location);
		assertEquals("California", location.getState());
	}
	
	
	@Test
	public void testEquals() {
		Location location = repo.findByStateEquals("Alaska");
		assertNotNull(location);
		assertEquals("Alaska", location.getState());		
	}
	
	
	@Test
	public void testNot() {
		List<Location> locations = repo.findByStateNot("Wisconsin");
		assertTrue(locations != null);
		assertEquals(49, locations.size());
	}
	
	
	@Test
	public void testIsOrEquals() {
		Location location = repo.findByCountryIsOrStateEquals("Australia", "Florida");
		assertNotNull(location);
		assertEquals("Florida", location.getState());	
	
	}
	
	
	
	@Test
	public void testNotLike() {
		List<Location> locations = repo.findByStateNotLike("Misso%");
		assertEquals(49, locations.size());		
	}
	
}