package com.jdc.mkt;

import java.io.Serializable;
import java.util.Objects;

import org.junit.jupiter.api.Test;

public class HashEqualTest {

	@Test
	void test() {
		Data d1 = new Data();
		d1.a = 5;
		d1.str = "a";
		
		Data d2 = new Data();
		d2.a = 5;
		d2.str = "a";
		
		System.out.println(d1 == d2);
		System.out.println(d1.equals(d2));
	}
	
}

class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int a;
	String str;
	@Override
	public int hashCode() {
		return Objects.hash(a, str);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return a == other.a && Objects.equals(str, other.str);
	}
	
	
	
	
	
}
