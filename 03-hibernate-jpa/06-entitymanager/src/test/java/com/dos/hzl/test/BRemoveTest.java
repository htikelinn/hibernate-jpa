package com.dos.hzl.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class BRemoveTest extends JpaFactory {
	
	@Test
	@Disabled
	//@Order(3)
	void productListRemoveTest() {
		
		em.getTransaction().begin();
		var cat = em.find(Category.class, 1);
		//var prouct = em.find(Product.class, 1);
		assertTrue(em.contains(cat));
		
		var list = cat.getProducts();
		list.remove(2); // index 2 delete
		
		em.getTransaction().commit();
	}
	
	@Test
	@Disabled
	@Order(2)
	void categoryRemoveTest() {
		// to be managed
		var cat = em.find(Category.class, 1);
		//var prouct = em.find(Product.class, 1);
		assertTrue(em.contains(cat));
		em.getTransaction().begin();
		em.remove(cat); // can't remove category bcz connect with product
		//em.remove(prouct);
		em.getTransaction().commit();
	}
	
	
	
	@Test
	@Disabled
	@Order(1)
	void productRemoveTest() {
		// to be managed
		var product = em.find(Product.class, 1);
		//var prouct = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		em.getTransaction().begin();
		em.remove(product); // can't remove category bcz connect with product
		//em.remove(prouct);
		em.getTransaction().commit();
	}
}
