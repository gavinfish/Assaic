package com.cineplex.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanMathUtilTest {

	@Test
	public void testGetResult() {
		BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
		assertEquals(10, booleanMathUtil.add(true).add(true, true).add(true,true,true,true,true,true,true).getResult());
	}

}
