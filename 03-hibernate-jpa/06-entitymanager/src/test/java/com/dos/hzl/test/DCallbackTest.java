package com.dos.hzl.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Member;

public class DCallbackTest extends JpaFactory{
	@Test
	void memberTest() {
		var member = new Member("HtinLinn","aaA777**");
		em.getTransaction().begin();
		em.persist(member);
		member.setUser("JohnHtin");
		em.getTransaction().commit();
	}
}
