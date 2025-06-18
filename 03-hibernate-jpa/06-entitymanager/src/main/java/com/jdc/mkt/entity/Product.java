package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private final String name;
	@Column(nullable = false, columnDefinition = "double(5,2) check(price > 0.00)")
	private final Double price;
	@ManyToOne
	private Category category;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean active;
	

}
