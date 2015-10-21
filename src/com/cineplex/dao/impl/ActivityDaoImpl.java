package com.cineplex.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.ActivityDao;
import com.cineplex.entity.Activity;
import com.cineplex.util.DateUtil;

/**
 * implements of DAO interface of activity entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:46:54  
*
 */

@Repository("activityDao")
public class ActivityDaoImpl extends BaseDaoImpl<Activity> implements ActivityDao{

	@Override
	public List<Activity> getActivitieListByName(String name) {
		// TODO Auto-generated method stub
		return new ArrayList<Activity>();
	}

	@Override
	public List<Activity> getActivitiesByFilmId(int filmId) {
		// TODO Auto-generated method stub
		String hql = "from Activity a where a.filmId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, filmId);
		@SuppressWarnings("unchecked")
		List<Activity> activities = query.list();
		return activities;
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		String hql = "from Activity a";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Activity> activities = query.list();
		return activities;
	}

	@Override
	public List<Activity> getEndedActivities() {
		// TODO Auto-generated method stub
		String hql = "from Activity a where a.over = 0 and a.endDate < ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, DateUtil.getCurrentDate());
		@SuppressWarnings("unchecked")
		List<Activity> activities = query.list();
		return activities;
	}

}
