package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.ScreeningPlanDao;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.util.DateUtil;

/**
 * implements of DAO interface of screening plan entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:44:19  
*
 */

@Repository("screeningPlanDao")
public class ScreeningPlanDaoImpl extends BaseDaoImpl<ScreeningPlan> implements ScreeningPlanDao{

	@Override
	public List<ScreeningPlan> findPlanByFilmId(int filmId) {
		// TODO Auto-generated method stub
		String hql = "from screening_plan s where s.filmId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, filmId);
		@SuppressWarnings("unchecked")
		List<ScreeningPlan> screeningPlans = query.list();
		return screeningPlans;
	}

	@Override
	public List<ScreeningPlan> findPlanByState(String state) {
		// TODO Auto-generated method stub
		String hql = "from screening_plan s where s.state = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, state);
		@SuppressWarnings("unchecked")
		List<ScreeningPlan> screeningPlans = query.list();
		return screeningPlans;
	}

	@Override
	public List<ScreeningPlan> findActivePlans() {
		// TODO Auto-generated method stub
		String hql = "from screening_plan s where s.state = 'yes' and s.endDate >= '"+DateUtil.getCurrentDate()+"'";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ScreeningPlan> screeningPlans = query.list();
		return screeningPlans;
	}

}
