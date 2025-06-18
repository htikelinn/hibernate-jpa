package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class JpaFactory {

	@Test
	void test() {
		var emf = Persistence.createEntityManagerFactory("field-mappings");
		emf.close();
	}
}
