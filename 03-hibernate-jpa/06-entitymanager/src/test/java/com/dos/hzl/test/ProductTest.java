package com.dos.hzl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

import jakarta.persistence.EntityNotFoundException;

public class ProductTest extends JpaFactory {

	@Test
	void categoryPersistWithCascadeTest() {
		var cat = new Category("Meat");
		cat.addProduct(
				new Product("Beef",15000.00),
				new Product("Chicken",20000.00));
		em.getTransaction().begin();
		em.persist(cat);
		em.getTransaction().commit();
	}
	
	
	@Order(3)
	@Disabled
	@Test
	void productDetachTest() {
		// To be managed state
		var product = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		em.detach(product);
		
		//To be detached state
		em.detach(product);
		assertFalse(em.contains(product));
		product.setName("Durain");
		em.getTransaction().begin();
		
		//To be managed
		var newProduct = em.merge(product);
		assertFalse(em.contains(product));
		assertTrue(em.contains(newProduct));
		em.getTransaction().commit();
	}
	
	
	@Order(2)
	@Disabled
	@ParameterizedTest // debug progarm and find by id
	@CsvSource(value = {"2:Apple"}, delimiter =  ':') // multitest for use array
	void productFindVsGetReference(int id, String nameResult) {
		//var product = em.find(Product.class, id);
		//assertTrue(em.contains(product)); // if product contain Apple out true
		//assertEquals(nameResult, product.getName()); // if equal nameResult = apple and product.getName = apple give ture
		
		var pFind = em.find(Product.class, id);
		assertNull(pFind);
		assertThrows(NullPointerException.class, () -> pFind.getName());
		
		var pRef = em.getReference(Product.class, id);
		assertNotNull(pRef);
		//assertThrows(EntityNotFoundException.class, () -> pRef.getName());
		
	}
	
	@Test
	@Disabled
	@Order(1)
	void productPersistTest() {
		// To be transient State or New State
		var cat = new Category("Fruits");
		var product = new Product("Orange", 5340.70);
		product.setCategory(cat);
		
		assertFalse(em.contains(cat));
		
		// To be Manage State
		em.getTransaction().begin();
		em.persist(cat);
		em.persist(product); // product reference category
		//em.getTransaction().commit();
		
		//em.getTransaction().begin();
		product.setName("Apple");
		em.persist(product);
		em.getTransaction().commit();
		
	}
	
}
