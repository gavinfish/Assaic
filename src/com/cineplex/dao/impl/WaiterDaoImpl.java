package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.WaiterDao;
import com.cineplex.entity.Waiter;

/**
 * implements of DAO interface of waiter entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:43:25  
*
 */

@Repository("waiterDao")
public class WaiterDaoImpl extends BaseDaoImpl<Waiter> implements WaiterDao{

	@Override
	public boolean findByAccountAndPw(String account, String password) {
		// TODO Auto-generated method stub
		String hql = "from Waiter w where w.account = ? and w.password = ? ";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, account);
		query.setParameter(1, password);
		@SuppressWarnings("unchecked")
		List<Waiter> waiters = query.list();
		return waiters != null && !waiters.isEmpty();
	}

}
