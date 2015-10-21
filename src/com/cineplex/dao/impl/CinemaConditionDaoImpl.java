package com.cineplex.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.CinemaConditionDao;
import com.cineplex.entity.CinemaCondition;

/**
 * implements of DAO interface of cinema condition entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:45:55  
*
 */

@Repository("cinemaConditionDao")
public class CinemaConditionDaoImpl extends BaseDaoImpl<CinemaCondition> implements CinemaConditionDao{

	@Override
	public int getDayCount(Date date) {
		// TODO Auto-generated method stub
		String hql = "select cc.count from cinema_condition cc where cc.date = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, date);
		if(query.uniqueResult()==null){
			return 0;
		}
		int resutl = (Integer) query.uniqueResult();
		return resutl;
	}

	@Override
	public int getCount(Date dateStart, Date dateEnd) {
		// TODO Auto-generated method stub
		String hql = "select sum(cc.count) from cinema_condition cc where cc.date >= ? and cc.date <= ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, dateStart);
		query.setParameter(1, dateEnd);
		if(query.uniqueResult()==null){
			return 0;
		}
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public CinemaCondition getByDate(Date date) {
		// TODO Auto-generated method stub
		String hql = "from cinema_condition cc where cc.date = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, date);
		@SuppressWarnings("unchecked")
		List<CinemaCondition> cinemaConditions = query.list();
		if(cinemaConditions!=null&&!cinemaConditions.isEmpty()){
			return cinemaConditions.get(0);
		}
		else{
			return null;
		}
	}

}
