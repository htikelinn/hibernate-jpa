package com.jdc.mkt.entity;

import org.hibernate.annotations.DynamicInsert;

import com.jdc.mkt.listeners.EnableTimesEntity;
import com.jdc.mkt.listeners.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@DynamicInsert //insert values if have values
@RequiredArgsConstructor
@NoArgsConstructor
public class Product implements EnableTimesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false, unique = true)
	private String name; // @NonNull for constructor
	
	@NonNull
	@Column(nullable = false, columnDefinition = "double(10,2) check(price > 0.00)")
	private Double price; // use final for constructor
	@ManyToOne(fetch = FetchType.LAZY,
			 cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Category category;
	
	
	@Column(columnDefinition = "boolean default true")
	private Boolean active = true;
	
	@Embedded
	private Times times;

}
