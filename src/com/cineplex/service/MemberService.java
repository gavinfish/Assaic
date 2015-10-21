package com.cineplex.service;

import java.util.List;

import com.cineplex.entity.Activity;
import com.cineplex.entity.BankCard;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.Member;

/**
 * interface of service for member operation
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月4日 上午11:28:45
 *
 */

public interface MemberService {
	/**
	 * check if a member is valid
	 * @param accountName
	 * @param password
	 * @return boolean: result of login
	 * @throws
	 */
	public Member login(String accountName, String password);

	/**
	 * register a new member
	 * @param member
	 * @return boolean: success or not
	 * @throws
	 */
	public boolean register(Member member);

	/**
	 * recharge money into a bank account
	 * @param bankCardId
	 * @param money
	 * @return boolean:
	 * @throws
	 */
	public boolean recharge(long bankCardId, int money);

	/**
	 * check bank account information for a member
	 * @param id
	 * @return BankCard:
	 * @throws
	 */
	public BankCard checkBankAccount(int id);

	/**
	 * get activities which are still active
	 * @param id
	 * @return List<Activity>:
	 * @throws
	 */
	public List<Activity> getAvaibleActivities(int id);

	/**
	 * add a record for a member attending a activity
	 * @param id
	 * @param activityId
	 * @param answer:
	 * @return void:
	 * @throws
	 */
	public void attendActivity(int id, int activityId, int answer);

	/**
	 * buy a ticket by a member card
	 * @param id: member card id
	 * @param money:
	 * @return void:
	 * @throws
	 */
	public boolean buyTicketsByCard(int id, int money);

	/**
	 * buy a ticket by integral in a member card
	 * @param id
	 * @param money
	 * @return boolean:
	 * @throws
	 */
	public boolean buyTicketByIntegral(int id, int money);

	/**
	 * get an activity information by its id
	 * @param activityId
	 * @return Activity:
	 * @throws
	 */
	public Activity getActivityById(int activityId);

	/**
	 * get consumption records of a member
	 * @param id
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getConsumption(int id);

	/**
	 * get rechrage records of a member
	 * @param id
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getRecharge(int id);
}
