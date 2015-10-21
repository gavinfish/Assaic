package com.cineplex.service;

import java.util.List;

import com.cineplex.entity.Film;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:52:14  
*
 */
public interface FilmService {
	/**
	 * get film information by its name
	 * @param name
	 * @param 
	 * @return Film:
	 * @throws
	 */
	public Film getFilmByName(String name);

	/**
	 * publish a new film into Assaic film library
	 * @param film:
	 * @return void:
	 * @throws
	 */
	public void publishFilm(Film film);

	/**
	 * get names of all films in Assaic film library
	 * @param
	 * @return ArrayList<String>:
	 * @throws
	 */
	public List<String> getAllFilmNames();

	/**
	 * get all films in the cineplex
	 * @param
	 * @return List<Film>:
	 * @throws
	 */
	public List<Film> getAllFilms();

	/**
	 * update information of a film
	 * @param  film:
	 * @return void:
	 * @throws
	 */
	public void updateFilm(Film film);

	/**
	 * get a film information by its id
	 * @param id
	 * @param 
	 * @return Film:
	 * @throws
	 */
	public Film getFilmById(int id);

	/**
	 * get all films which are still on screening
	 * @return List<Film>:
	 * @throws
	 */
	public List<Film> getActiveFilms();
	
	/**
	 * add ticket count prepared for a film
	* @param count:  
	* @return void:  
	* @throws
	 */
	public void addPreparedTicket(int filmId, int count);
	
	/**
	 * add ticket sold count for a film
	* @param filmId
	* @param count:  
	* @return void  
	* @throws
	 */
	@Deprecated
	public void addSoldTicket(int filmId,int count);
}
