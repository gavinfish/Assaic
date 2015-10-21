package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.Ticket;

/**
 * DAO interface of ticket entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:37:51
 *
 */

public interface TicketDao extends BaseDao<Ticket> {
	/**
	 * get all ids of films which a member has buy tickets of
	 *               them
	 * @param memberId
	 * @return List<Integer>:
	 * @throws
	 */
	public List<Integer> getFilmIdsByMemberId(int memberId);

	/**
	 * get ids of members who have bought tickets of a film
	 *               by its id
	 * @param filmId
	 * @return List<Integer>:
	 * @throws
	 */
	public List<Integer> getMemberIdsByFilmId(int filmId);

	/**
	 * get count of tickets by their type
	 * @param type
	 * @return int:
	 * @throws
	 */
	@Deprecated
	public int getCountByType(char type);

	/**
	 * get total money of tickets by their type
	 * @param type
	 * @return long:
	 * @throws
	 */
	@Deprecated
	public long getMoneyByType(char type);
}
