package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.ManagerDao;
import com.cineplex.entity.Manager;

/**
 * implements of DAO interface of manager entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:45:16  
*
 */

@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao{

	@Override
	public Manager findByAccountAndPsw(String account, String password) {
		// TODO Auto-generated method stub
		String hql = "from Manager m where m.account = ? and m.password = ? ";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, account);
		query.setParameter(1, password);
		@SuppressWarnings("unchecked")
		List<Manager> managers = query.list();
		if(managers != null && !managers.isEmpty()){
			return managers.get(0);
		}
		else{
			return null;
		}
	}

}
