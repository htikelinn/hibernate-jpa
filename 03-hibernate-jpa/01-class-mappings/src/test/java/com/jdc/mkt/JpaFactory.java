package com.jdc.mkt;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class JpaFactory {

	@Test
	void create() {
		var emf = Persistence.createEntityManagerFactory("class-mappings");
	}
}
