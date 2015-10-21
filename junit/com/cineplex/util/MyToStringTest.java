package com.cineplex.util;

import static org.junit.Assert.*;

import org.junit.Test;

class A{
	@SuppressWarnings("unused")
	private String x;
	@SuppressWarnings("unused")
	private String y;
	
	public void setX(String x){
		this.x = x;
	}
	
	public void setY(String y){
		this.y = y;
	}
	
	@Override
	public String toString(){
		return MyToString.getString(this);
	}
}

public class MyToStringTest {
	@Test
	public void testGetString() {
		A a = new A();
		a.setX("x");
		a.setY("y");
		assertNotEquals("x:x y:y", a.toString());
	}

}
