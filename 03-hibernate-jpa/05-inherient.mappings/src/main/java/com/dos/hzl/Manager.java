package com.dos.hzl;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("M")
public class Manager extends Account{
	public Manager() {
		// TODO Auto-generated constructor stub
		setAcctype(AccountType.MANAGER);
	}
}
