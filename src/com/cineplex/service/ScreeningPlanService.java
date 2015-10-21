package com.cineplex.service;

import java.util.List;

import com.cineplex.entity.ScreeningPlan;

/**
 * service for screening plans logic needs
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月7日 下午4:39:11
 *
 */

public interface ScreeningPlanService {
	/**
	 * get screening plans for a film
	 * @paramfilmName
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> getPlansByFilmName(String filmName);

	/**
	 * get screening plans which have not been checked
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> getUncheckedPlan();

	/**
	 * get screening plans which have been failed by the
	 *               manager
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> getUnpassedPlan();

	/**
	 * get screening plans which have been approved by the
	 *               manager
	 * @return List<ScreeningPlan>:
	 * @throws
	 */
	public List<ScreeningPlan> getPassedPlan();

	/**
	 * for manager to reply unchecked or unpassed plan
	 * @paramscreeningPlan:
	 * @return void:
	 * @throws
	 */
	public void repleyPlan(ScreeningPlan screeningPlan);

	/**
	 * get a plan's information by its id
	 * @param id
	 * @return ScreeningPlan:
	 * @throws
	 */
	public ScreeningPlan getPlanById(int id);
}
