package com.dos.hzl.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)

public class JpaFactory {

	static EntityManagerFactory emf;
	EntityManager em;
	@BeforeEach
	void createEm() {
		em = emf.createEntityManager();
	}
	@AfterEach
	void closeEm() {
		if (null != em && em.isOpen())
			em.close();
	
	}
	
	@BeforeAll
	static void create() {
		emf = Persistence.createEntityManagerFactory("05-inherient.mappings");
	}
	
	@Test
	void test() {
		
	}
	
}
