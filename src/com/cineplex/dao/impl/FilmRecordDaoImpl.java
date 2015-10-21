package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.FilmRecordDao;
import com.cineplex.entity.FilmRecord;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:17:12  
*
 */
@Repository("filmRecordDao")
public class FilmRecordDaoImpl extends BaseDaoImpl<FilmRecord> implements FilmRecordDao{

	@Override
	public List<FilmRecord> findRecordsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		String hql = "from film_record f where f.filmId=? and f.date>=?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, filmId);
		query.setParameter(1, DateUtil.getCurrentDate());
		@SuppressWarnings("unchecked")
		List<FilmRecord> filmRecords = query.list();
		return filmRecords;
	}

}
