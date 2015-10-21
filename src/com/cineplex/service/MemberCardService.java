package com.cineplex.service;

import java.util.List;

import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.MemberCard;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:52:30  
*
 */
public interface MemberCardService {
	/**
	 * recharge money into a member card with bank card
	 * @param bankCardId
	 * @param money
	 * @return boolean
	 * @throws
	 */
	public boolean rechargeByBank(int memberCardId, long bankCardId, int money);

	/**
	 * 
	 * @Title: getMemberCardById
	 * @Description: TODO get member card information of a member using his id
	 * @param id
	 * @return MemberCard:
	 * @throws
	 */
	public MemberCard getMemberCardByMemberId(int id);

	/**
	 * 
	 * @Title: disQualificate
	 * @Description: TODO cancel the qualification of member card for a member
	 * @param memberCardId:
	 * @return void:
	 * @throws
	 */
	public void disQualificate(int memberCardId);

	/**
	 * 
	 * @Title: getLevel
	 * @Description: TODO get level of the member card
	 * @param memberCardId
	 * @return int:
	 * @throws
	 */
	public int getLevel(int memberCardId);

	/**
	 * 
	 * @Title: discount
	 * @Description: TODO after the member card discount, how much money has to
	 *               be paid
	 * @param memberCard
	 * @param money
	 * @return int:
	 * @throws
	 */
	public int discount(int memberCard, int money);

	/**
	 * 
	 * @Title: isActive
	 * @Description: TODO check if the member card is active, 0: haven't been
	 *               activated or disqualificated, 1: active, 2: suspend
	 * @param memberCardId
	 * @return boolean:
	 * @throws
	 */
	public int getActiveState(int memberCardId);

	/**
	 * 
	 * @Title: buyTicketByIntegral
	 * @Description: TODO buy a ticket by integral
	 * @param memberCardId
	 * @param money: money needs to be paid
	 * @return boolean:
	 * @throws
	 */
	@Deprecated
	public boolean buyTicketByIntegral(int memberCardId, int money);

	/**
	 * 
	 * @Title: addIntegral
	 * @Description: TODO add integral to a member card, either for buying
	 *               tickets or win an activity
	 * @param memberCardId
	 * @param money:
	 * @return void:
	 * @throws
	 */
	public void addIntegral(int memberCardId, int money);

	/**
	 * 
	 * @Title: getComsuptionRecord
	 * @Description: TODO get consumption records of a member card
	 * @param memberCardId
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getComsuptionRecord(int memberCardId);

	/**
	 * 
	 * @Title: getRechargeRecord
	 * @Description: TODO get recharge records of a member card
	 * @param memberCardId
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getRechargeRecord(int memberCardId);

	/**
	 * 
	 * @Title: getCountByState
	 * @Description: TODO get count of member cards by their state
	 * @param state
	 * @return int:
	 * @throws
	 */
	public int getCountByState(char state);
}
