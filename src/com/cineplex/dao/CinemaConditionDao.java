package com.cineplex.dao;

import java.sql.Date;

import com.cineplex.entity.CinemaCondition;

/**
 * DAO interface of cinema condition entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:41:07
 *
 */

public interface CinemaConditionDao extends BaseDao<CinemaCondition> {
	/**
	 * get count of tickets sold on
	 * @param date
	 * @return int:
	 * @throws
	 */
	public int getDayCount(Date date);

	/**
	 * get count of tickets sold between
	 * @param dateStart
	 *            and
	 * @param dateEnd
	 * @return int:
	 * @throws
	 */
	public int getCount(Date dateStart, Date dateEnd);

	/**
	 * get condition of the cineplex on
	 * @param date
	 * @return CinemaCondition:
	 * @throws
	 */
	public CinemaCondition getByDate(Date date);
}
