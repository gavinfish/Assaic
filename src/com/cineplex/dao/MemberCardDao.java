package com.cineplex.dao;

import com.cineplex.entity.MemberCard;

/**
 * DAO interface of member card entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:39:42
 *
 */

public interface MemberCardDao extends BaseDao<MemberCard> {
	/**
	 * find member card info by its own's id
	 * @param  id
	 * @return MemberCard:
	 * @throws
	 */
	public MemberCard findByMemberId(int id);

	/**
	 * get count of member cards by their state
	 * @param state
	 * @return int:
	 * @throws
	 */
	public int getCountByState(char state);

}
