package com.jdc.mkt.entity;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicInsert
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(nullable = false, unique = true)
	private String name;
	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	@OneToMany(mappedBy = "category",
			//orphanRemoval = true, //to remove child list and parient list
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) //to remove only child list
	private List<Product> products = new ArrayList<Product>();
	
	
	// This is hyper method
	public void addProduct(Product...ps) { //... var @ sign, last parameter
		for (Product p :ps) {
			p.setCategory(this);
			products.add(p);	
		}
		
	}
	
	
	
}
