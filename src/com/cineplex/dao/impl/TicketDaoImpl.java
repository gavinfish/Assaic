package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.TicketDao;
import com.cineplex.entity.Ticket;

/**
 * implements of DAO interface of ticket entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:44:00  
*
 */

@Repository("ticketDao")
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao{

	@Override
	public List<Integer> getFilmIdsByMemberId(int memberId) {
		// TODO Auto-generated method stub
		String hql = "select distinct t.filmId from Ticket t where t.memberId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<Integer> filmIds = query.list();
		return filmIds;
	}

	@Override
	public List<Integer> getMemberIdsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		String hql = "select distinct t.memberId from Ticket t where t.filmId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, filmId);
		@SuppressWarnings("unchecked")
		List<Integer> filmIds = query.list();
		return filmIds;
	}

	@Override
	public int getCountByType(char type) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Ticket t where t.payType = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, type);
		int result = (Integer) query.uniqueResult();
		return result;
	}

	@Override
	public long getMoneyByType(char type) {
		// TODO Auto-generated method stub
		String hql = "select sum(t.pricePaid) from Ticket t where t.payType = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, type);
		long result = (Long) query.uniqueResult();
		return result;
	}

}
