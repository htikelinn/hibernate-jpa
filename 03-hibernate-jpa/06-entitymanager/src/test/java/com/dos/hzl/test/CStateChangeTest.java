package com.dos.hzl.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

import jakarta.persistence.PersistenceException;

public class CStateChangeTest extends JpaFactory{

	
	
	@Test
	@Disabled
	void removeTest() {
		//To be marged
		var product = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(product));
		
	}
	@Disabled
	@Test
	void mergeTest() {
		// To be transient
		var cat = new Category("Meat");
		var product = new Product("pork",20000.00);
		product.setCategory(cat);
		
		//to be managed
		em.getTransaction().begin();
		var p1 = em.merge(product);
		em.merge(p1);
		em.getTransaction().commit();
		
		//To be detached
		em.clear();
		//em.detach(product);
		assertFalse(em.contains(p1));
		
		//To be managed
		var p2 = em.merge(p1);
		assertTrue(em.contains(p2));
		
		assertThrows(IllegalArgumentException.class, ()->em.merge(p2));
	}
	
	@Test
	@Disabled
	void persistTest() {
		// To be managed
		var product = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		
		//To be removed
		em.remove(product);
		assertFalse(em.contains(product));
		
		//To be persist
		em.persist(product);
		assertTrue(em.contains(product));
		
		//To be detached
		em.detach(product);
		assertFalse(em.contains(product));
		
		assertThrows(PersistenceException.class, () -> em.persist(product));
	}
}
