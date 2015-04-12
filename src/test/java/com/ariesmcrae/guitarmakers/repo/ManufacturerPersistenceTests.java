package com.ariesmcrae.guitarmakers.repo;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ariesmcrae.guitarmakers.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Ignore
public class ManufacturerPersistenceTests {
	@Autowired
	private ManufacturerRepository manufacturerRepository;

//	@Test
//	public void testGetManufacturersFoundedBeforeDate() throws Exception {
//		List<Manufacturer> mans = manufacturerRepository.getManufacturersFoundedBeforeDate(new Date());
//		assertEquals(2, mans.size());
//	}
//
//	@Test
//	public void testGetManufactureByName() throws Exception {
//		Manufacturer m = manufacturerRepository.getManufacturerByName("Fender");
//		assertEquals("Fender Musical Instruments Corporation", m.getName());
//	}
//
//	@Test
//	public void testGetManufacturersThatSellModelsOfType() throws Exception {
//		List<Manufacturer> mans = manufacturerRepository.getManufacturersThatSellModelsOfType("Semi-Hollow Body Electric");
//		assertEquals(1, mans.size());
//	}
}
