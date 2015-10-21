package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.Activity;

/**
 * interface of activity entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:43:00
 *
 */

public interface ActivityDao extends BaseDao<Activity> {
	/**
	 * get activity list by related film name
	 * @param name
	 * @return List<Activity>:
	 * @throws
	 */
	public List<Activity> getActivitieListByName(String name);

	/**
	 * get activity list by related film id
	 * @param filmId
	 * @return List<Activity>:
	 * @throws
	 */
	public List<Activity> getActivitiesByFilmId(int filmId);

	/**
	 * get all activities
	 * @return List<Activity>:
	 * @throws
	 */
	public List<Activity> getAllActivities();

	/**
	 * get activities which have ended but haven't been
	 *               settle accounts
	 * @return List<Activity>:
	 * @throws
	 */
	public List<Activity> getEndedActivities();
}
