package com.jdc.mkt.entity;

import java.sql.Time;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.DynamicInsert;

import com.jdc.mkt.listeners.EnableTimesEntity;
import com.jdc.mkt.listeners.Times;
import com.jdc.mkt.listeners.TimesListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@DynamicInsert
@NoArgsConstructor
@RequiredArgsConstructor
@EntityListeners(TimesListener.class)
public class Member implements EnableTimesEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false, length = 45, unique = true)
	private String user;
	/*
	 * password must be at least one capital letter, small letter
	 * and digit and also character length must between 8 -20
	 */
	@NonNull
	@Check(constraints = "password regexp '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$'")
	private String password;
	
	@Column(columnDefinition = "boolean default true")
	private boolean active;
	
	@Embedded
	private Times times;
	
//	@PrePersist
//	void prePersist() {
//		System.err.println("This is prepersist");
//	}
//	@PostPersist
//	void postPersist() {
//		System.err.println("This is postpersist");
//	}
//	@PreUpdate
//	void preUpate() {
//		System.err.println("This is preupdate");
//	}
//	@PostUpdate
//	void postUpate() {
//		System.err.println("This is postupdate");
//	}
}
