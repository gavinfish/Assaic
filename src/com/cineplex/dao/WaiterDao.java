package com.cineplex.dao;

import com.cineplex.entity.Waiter;

/**
 * DAO interface of waiter entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:37:17
 *
 */

public interface WaiterDao extends BaseDao<Waiter> {
	/**
	 * find a waiter info by his account and password
	 * @param account
	 * @param password
	 * @return boolean:
	 * @throws
	 */
	public boolean findByAccountAndPw(String account, String password);
}
