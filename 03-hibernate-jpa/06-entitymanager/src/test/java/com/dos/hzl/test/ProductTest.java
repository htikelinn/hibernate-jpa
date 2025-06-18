package com.dos.hzl.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class ProductTest extends JpaFactory {

	
	@Test
	void productTest() {
		// Transient State or New State
		var cat = new Category("Fruits");
		var product = new Product("Orange", 200.00);
		product.setCategory(cat);
		
		em.getTransaction().begin();
		em.persist(cat);
		em.persist(product);
		em.getTransaction().commit();
	}
	
}
