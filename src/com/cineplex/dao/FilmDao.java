package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.Film;

/**
 * DAO interface of film entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:40:41
 *
 */

public interface FilmDao extends BaseDao<Film> {
	/**
	 * find a film by its name
	 * @param name
	 * @return Film:
	 * @throws
	 */
	public Film fingByName(String name);

	/**
	 * find all films in the cineplex
	 * @return List<Film>:
	 * @throws
	 */
	public List<Film> getAllFilms();
}
