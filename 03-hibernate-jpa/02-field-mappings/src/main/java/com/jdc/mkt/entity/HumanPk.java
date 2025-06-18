package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
//@Embeddable
public class HumanPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nrc;
	private LocalDate dob;
}
