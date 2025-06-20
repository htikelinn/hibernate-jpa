package com.dos.hzl.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Product;

public class DCallbackTest extends JpaFactory{
	@Test
	void memberTest() {
		var member = new Member("HtinLinn","aaA777**");
		var cat = new Category("Meat");
		cat.addProduct(
				new Product("Beef",15000.00),
				new Product("Chicken",20000.00));
		em.getTransaction().begin();
		em.persist(member);
		em.persist(cat);
		//member.setUser("JohnHtin");
		em.getTransaction().commit();
	}
}
