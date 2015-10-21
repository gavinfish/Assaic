package com.cineplex.service;

import java.util.Map;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:52:22  
*
 */
public interface ManagerService {
	/**
	 * 
	 * check login account is valid manager
	 * @param accountName
	 * @param password
	 * @return boolean: result of login of manager
	 * @throws
	 */
	public boolean login(String accountName, String password);

	/**
	 * get count of tickets sold on a day of recent week
	 * @return int[]:
	 * @throws
	 */
	public int[] getDayPeople();

	/**
	 * get count of tickets sold in a month of recent year
	 * @return int[]:
	 * @throws
	 */
	public int[] getMonthPeople();

	/**
	 * get attended percent of all films
	 * @return Map<String,Double>:
	 * @throws
	 */
	public Map<String, Double> getFilmAttendance();

	/**
	 * get attended percent of each hall for recent week
	 * @return Map<String,double[]>:
	 * @throws
	 */
	public Map<String, double[]> getHallAttendance();

	/**
	 * get total money of tickets sold on a day for recent
	 *               week
	 * @return long[]:
	 * @throws
	 */
	public long[] getTicketMoney();

	/**
	 * get count of tickets sold on a day for recent week
	 * @return int[]:
	 * @throws
	 */
	public int[] getTicketCount();

	/**
	 * get count of members who have attended activities
	 * @return Map<String,Integer>:
	 * @throws
	 */
	public Map<String, Integer> getActivityStatistic();

	/**
	 * get count of member cards of different state
	 * @return Map<String,Integer>:
	 * @throws
	 */
	public Map<String, Integer> getMemberCardStatistic();
	
	/**
	 * get count of people who buys ticket in a particular month
	* @param year
	* @param month
	* @return int[]:  
	* @throws
	 */
	public int[] getMonthPeopleStatistic(int year,int month);
	
	/**
	 * get attendance of each hall in a particular month
	* @param year
	* @param month
	* @return Map<String,Integer[]>:  
	* @throws
	 */
	public Map<String, double[]> getMonthHallStatistic(int year,int month);
	
	/**
	 * get count of ticket and total money in a particular month
	* @param year
	* @param month
	* @return Map<String,Integer[]>:  
	* @throws
	 */
	public Map<String, Integer[]> getMonthMoneyStatistic(int year,int month);
}
