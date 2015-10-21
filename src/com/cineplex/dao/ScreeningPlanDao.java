package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.ScreeningPlan;

/**
 * 
 * @ClassName: ScreeningPlanDao
 * @Description: TODO DAO interface of screening plan entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:38:27
 *
 */

public interface ScreeningPlanDao extends BaseDao<ScreeningPlan> {
	/**
	 * find a screening plan for a film by the film's id
	 * @param filmId
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> findPlanByFilmId(int filmId);

	/**
	 * get screening plans by their state
	 * @param state
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> findPlanByState(String state);

	/**
	 * get all screening plans which have been approved and
	 *               not ended
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> findActivePlans();
}
