package com.cineplex.util;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import com.google.common.base.Joiner;

/**
 * help transform date between sql and format
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月6日 下午3:45:30
 *
 */
public class DateUtil {
	private DateUtil(){
		
	}
	
	/**
	 * transform date from format like "YYYY-MM-DD" to sql
	 *               date
	 * @param dateString
	 * @return Date:
	 * @throws
	 */
	public static Date getSQLDate(String dateString) {
		String[] dateStrings = dateString.split("-");
		int month = Integer.parseInt(dateStrings[1]);
		int day = Integer.parseInt(dateStrings[2]);
		int year = Integer.parseInt(dateStrings[0]);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		Date date = new Date(calendar.getTimeInMillis());
		return date;
	}

	/**
	 * 
	* transform like from 1999-1-1 to 1999-01-01
	* @param dateString
	* @return
	* String  
	* @throws
	 */
	public static String transformFormat(String dateString) {
		String[] dateStrings = dateString.split("-");
		int year = Integer.parseInt(dateStrings[0]);
		int month = Integer.parseInt(dateStrings[1]);
		int day = Integer.parseInt(dateStrings[2]);
		String result = Joiner.on('-').join(year,
				month < 10 ? "0" + month : month, day < 10 ? "0" + day : day);
		return result;
	}

	/**
	 * get current date in sql date type
	 * @return Date:
	 * @throws
	 */
	public static Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 
	* get date a day before date given
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getDayBefore(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.get(Calendar.DAY_OF_MONTH) - 1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get date a day after date given
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getDayLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.get(Calendar.DAY_OF_MONTH) + 1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * get date for a year later
	 * @return Date:
	 * @throws
	 */
	public static Date getYearLater() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
		Date date = new Date(calendar.getTimeInMillis());
		return date;
	}

	/**
	 * 
	* get date a year after date given
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getYearLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get date a year before date given
	* @param date
	* @param year
	* @return
	* Date  
	* @throws
	 */
	public static Date getYearsBefore(Date date, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - year);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get date days after date given
	* @param date
	* @param days
	* @return
	* Date  
	* @throws
	 */
	public static Date getDaysLater(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * transform date from format like "HH:MM" to sql date
	 * @param @param timeString:
	 * @throws
	 */
	public static Time getSQLTime(String timeString) {
		String[] timeStrings = timeString.split(":");
		int hour = Integer.parseInt(timeStrings[0]);
		int minute = Integer.parseInt(timeStrings[1]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		Time time = new Time(calendar.getTimeInMillis());
		return time;
	}

	/**
	 * 
	* get gap between date1 and date2
	* @param date1
	* @param date2
	* @return
	* int  
	* @throws
	 */
	public static int getGap(Date date1, Date date2) {
		long DAY = 24L * 60L * 60L * 1000L;
		int day = (int) (Math.abs(date1.getTime() - date2.getTime()) / DAY);
		return day;
	}

	/**
	 * 
	* get Time by time and minute
	* @param time
	* @param minute
	* @return
	* Time  
	* @throws
	 */
	public static Time timeAddMinute(Time time, int minute) {
		Time time2 = new Time(time.getTime() + minute * 60L * 1000L);
		return time2;
	}

	/**
	 * 
	* get next date of today
	* @param date
	* @return
	* Date  
	* @throws
	 */
	@SuppressWarnings("deprecation")
	public static Date getNextDay(Date date) {
		date.setDate(date.getDate() + 1);
		return date;
	}

	/**
	 * 
	* get the first date of the month
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get the last date of the month
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get date a month before the date given
	* @param date
	* @return
	* Date  
	* @throws
	 */
	public static Date getMonthBefroe(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		Date date2 = new Date(calendar.getTimeInMillis());
		return date2;
	}

	/**
	 * 
	* get a date by year and month
	* @param year
	* @param month
	* @return
	* Date  
	* @throws
	 */
	public static Date getDateByYearAndMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		Date date = new Date(calendar.getTimeInMillis());
		return date;
	}
}
