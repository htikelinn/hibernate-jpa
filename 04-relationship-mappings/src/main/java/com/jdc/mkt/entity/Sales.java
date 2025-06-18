package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Sales {

	@EmbeddedId
	private SalesPk id;
	private double subTotal;
	private double discount;
	private double tax;
	private double total;
	@ManyToMany
	private List<Product> products;
}
