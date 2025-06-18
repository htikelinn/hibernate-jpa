package com.jdc.mkt.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(length = 45,nullable = false,unique = true)
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private Size size;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private LocalDateTime createdAt;
	
	@Transient
	private String note;
	
}








