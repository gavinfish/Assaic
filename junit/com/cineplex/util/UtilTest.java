package com.cineplex.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testMd5Encryption() {
		assertNotEquals("hello", Util.md5Encryption("hello"));
	}

	@Test
	public void testIsNull() {
		assertEquals(true, Util.isNull(null));
	}

	@Test
	public void testIsNull1() {
		assertEquals(true, Util.isNull(""));
	}
	
	@Test
	public void testIsNull_false(){
		assertEquals(false, Util.isNull("f"));
	}
}
