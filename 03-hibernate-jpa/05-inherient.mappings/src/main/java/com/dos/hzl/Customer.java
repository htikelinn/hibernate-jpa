package com.dos.hzl;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("C")
public class Customer extends Account {
	@Enumerated(EnumType.STRING)
	private Member membtype;
	
	public Customer() {
		setAcctype(AccountType.CUSTOMER);
	}
	
	public Customer(Member membtype) {
		this.membtype = membtype;
		setAcctype(AccountType.CUSTOMER);
	}
	
	public enum Member{
		SILVER,GOLD,DIAMOND
	}
	
	
	
}
