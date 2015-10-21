package com.cineplex.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryUtilTest {
	@Test
	public void testLongToCharArray(){
		assertArrayEquals(new char[]{'0','0','0','0','1'}, BinaryUtil.longToCharArray(1, 5));
	}

	@Test
	public void testCharArrayToLong(){
		assertEquals(1, BinaryUtil.charArrayToLong(new char[]{'0','0','0','0','1'}));
	}
}
