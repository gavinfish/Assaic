package com.cineplex.util;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class DateUtilTest {
	//DATE is 1999-01-01
	private static final Date DATE = new Date(99, 0, 2);

	@Test
	public void testGetSQLDate() {
		assertEquals(DATE.getDate()-1,DateUtil.getSQLDate("1999-1-2").getDate());
	}

	@Test
	public void testTransformFormat() {
		assertEquals("1999-01-01", DateUtil.transformFormat("1999-1-1"));
	}

	@Test
	public void testGetCurrentDate() {
		assertTrue(DateUtil.getCurrentDate()!=null);
	}

	@Test
	public void testGetDayBefore() {
		assertEquals(new Date(99,0,2), DateUtil.getDayBefore(DATE));
	}

	@Test
	public void testGetDayLater() {
		assertEquals(new Date(99,0,4), DateUtil.getDayLater(DATE));
	}

	@Test
	public void testGetYearLater() {
		assertTrue(DateUtil.getYearLater()!=null);
	}

	@Test
	public void testGetYearLaterDate() {
		assertEquals(new Date(100,0,3), DateUtil.getYearLater(DATE));
	}

	@Test
	public void testGetYearsBefore() {
		assertEquals(new Date(97,0,3), DateUtil.getYearsBefore(DATE, 2));
	}

	@Test
	public void testGetDaysLater() {
		assertEquals(new Date(99,0,6), DateUtil.getDaysLater(DATE, 3));
	}

	@Test
	public void testGetSQLTime() {
		assertEquals(new Time(1, 1, 1).getMinutes(), DateUtil.getSQLTime("1:1").getMinutes());
	}

	@Test
	public void testGetGap() {
		assertEquals(1, DateUtil.getGap(DATE, new Date(99,0,4)));
	}

	@Test
	public void testTimeAddMinute() {
		assertEquals(new Time(1,6,1), DateUtil.timeAddMinute(new Time(1,1,1), 5));
	}

	@Test
	public void testGetNextDay() {
		assertEquals(new Date(99,0,3), DateUtil.getNextDay(DATE));
	}

	@Test
	public void testGetFirstDay() {
		assertEquals(new Date(99,0,1), DateUtil.getFirstDay(DATE));
	}

	@Test
	public void testGetLastDay() {
		assertEquals(new Date(99,0,31), DateUtil.getLastDay(DATE));
	}

	@Test
	public void testGetMonthBefroe() {
		assertEquals(new Date(98,11,3), DateUtil.getMonthBefroe(DATE));
	}

	@Test
	public void testGetDateByYearAndMonth() {
		assertEquals(new Date(99,1,0).getMonth(), DateUtil.getDateByYearAndMonth(1999, 1).getMonth());
	}

}
