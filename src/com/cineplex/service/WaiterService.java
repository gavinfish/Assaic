package com.cineplex.service;

import com.cineplex.entity.Activity;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.entity.Ticket;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:50:58  
*
 */
public interface WaiterService {
	/**
	 * check login account is valid waiter
	 * @param accountName
	 * @param password
	 * @return boolean: result of login of waiter
	 * @throws
	 */
	public boolean login(String accountName, String password);

	/**
	 * make a screening plan
	 * @param screeningPlan:
	 * @return void:
	 * @throws
	 */
	public void makePlan(ScreeningPlan screeningPlan);

	/**
	 * modify a screening plan
	 * @param screeningPlan:
	 * @return void:
	 * @throws
	 */
	public void modifyPlan(ScreeningPlan screeningPlan);

	/**
	 * sell a ticket
	 * @param ticket
	 * @param feeType: way of paying the money
	 * @return void:
	 * @throws
	 */
	public void sellTicket(Ticket ticket, char feeType);

	/**
	 * make a activity for a film
	 * @param activity:
	 * @return void:
	 * @throws
	 */
	public void makeActivity(Activity activity);

	/**
	 * get total money of tickets by their type
	 * @param type
	 * @return long:
	 * @throws
	 */
	public long getTicketMoneyByType(char type);

	/**
	 * get count of tickets sold by their type
	 * @param type
	 * @return int:
	 * @throws
	 */
	public int getTicketCountByType(char type);

	/**
	 * end an activity and calculate the integral
	 * @return void:
	 * @throws
	 */
	public void endActivity();
}
