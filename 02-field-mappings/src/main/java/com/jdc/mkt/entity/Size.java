package com.jdc.mkt.entity;

public enum Size {

	SMALL(500),MEDIUM(1000),LARGE(1500);
	
	private int times;
	
	Size(int times){
		this.times = times;
	}
	
	public int getTimes() {
		return times;
	}
}
