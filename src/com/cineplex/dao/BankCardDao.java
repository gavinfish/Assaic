package com.cineplex.dao;

import com.cineplex.entity.BankCard;

/**
 * DAO interface of bank card entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:42:00
 *
 */

public interface BankCardDao extends BaseDao<BankCard> {
	/**
	 * find bank card by member's id
	 * @param memberId
	 * @return BankCard:
	 * @throws
	 */
	public BankCard findByMemberId(int memberId);
}
