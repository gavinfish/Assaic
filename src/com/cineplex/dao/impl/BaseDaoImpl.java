package com.cineplex.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;

/**
 * implement of base Dao
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月1日 下午9:48:59  
*  
* @param <T> entity type
 */

public class BaseDaoImpl<T> implements BaseDao<T> {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T entity) {
		Session session = sessionFactory.openSession();
		Serializable serializable = session.save(entity);
		session.flush();
		session.clear();
		session.close();
		return serializable;
		
	}

	
	@Override
	public void delete(T entity) {
		Session session = sessionFactory.openSession();
		session.delete(entity);
		session.flush();
		session.clear();
		session.close();
	}

	@Override
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		session.update(entity);
		session.flush();
		session.clear();
		session.close();
	}

	@Override
	public void saveOrUpdate(T entity) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(entity);
		session.flush();
		session.clear();
		session.close();
	}


	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}


}
