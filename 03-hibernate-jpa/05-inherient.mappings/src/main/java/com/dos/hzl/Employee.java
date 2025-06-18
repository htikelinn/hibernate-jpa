package com.dos.hzl;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("E")
public class Employee extends Account {
	@ManyToOne
	private Department department;
	
	public Employee() {
		setAcctype(AccountType.EMPLOYEE);
	}
	public Employee(Department department) {
		this.department = department;
		setAcctype(AccountType.EMPLOYEE);
	}
}
