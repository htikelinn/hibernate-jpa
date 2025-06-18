package com.dos.hzl.test;


import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.dos.hzl.Customer;
import com.dos.hzl.Customer.Member;
import com.dos.hzl.Department;
import com.dos.hzl.Employee;


public class AccountTest extends JpaFactory {
	@Test
	@Order(1)
	void DepartmentTest() {
		Department dep = new Department();
		dep.setName("IT Team");
		
		em.getTransaction().begin();
		em.persist(dep);
		em.getTransaction().commit();
		
		
	}
	@Test
	@Order(3)
	void customerTest() {
		
		Customer cu = new Customer(Member.GOLD);
		cu.setCreateDateAt(LocalDate.now());
		cu.setCreateTimeAt(LocalTime.now());
		cu.setEmail("aungaung.gmail.com");
		cu.setUsername("aungaung");
		cu.setPassword("123");
		
		
		em.getTransaction().begin();
		em.persist(cu);
		em.getTransaction().commit();
		
	}
	@Test
	@Order(2)
	void employeeTest() {
		
	
		
		Employee emp = new Employee();
		emp.setCreateDateAt(LocalDate.now());
		emp.setCreateTimeAt(LocalTime.now());
		emp.setDepartment(new Department(1));
		emp.setEmail("kogyikayw@gmail.com");
		emp.setUsername("Kyaw Gyi");
		emp.setPassword("456");
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		
	}
	
}
