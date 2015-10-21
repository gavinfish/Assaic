package com.cineplex.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.FilmDao;
import com.cineplex.entity.Film;

/**
 * implements of DAO interface of film entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:45:36  
*
 */

@Repository("filmDao")
public class FilmDaoImpl extends BaseDaoImpl<Film> implements FilmDao{

	@Override
	public Film fingByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Film f where f.name=?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, name);
		@SuppressWarnings("unchecked")
		List<Film> films = query.list();
		if(films!=null&&!films.isEmpty()){
			return films.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		String hql = "from Film f";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Film> films = new ArrayList<Film>(query.list());
		return films;
	}

}
