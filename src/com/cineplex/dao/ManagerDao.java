package com.cineplex.dao;

import com.cineplex.entity.Manager;

/**
 * DAO interface of manager entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:40:08
 *
 */

public interface ManagerDao extends BaseDao<Manager> {
	/**
	 * find manager info by its account and password
	 * @param account
	 * @param password
	 * @return Manager:
	 * @throws
	 */
	public Manager findByAccountAndPsw(String account, String password);
}
