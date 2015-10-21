package com.cineplex.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cineplex.dao.FilmDao;
import com.cineplex.dao.ScreeningPlanDao;
import com.cineplex.entity.Film;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.service.FilmService;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:55:34  
*
 */
@Service("filmService")
public class FilmServiceImpl implements FilmService{
	@Resource
	private FilmDao filmDao;
	@Resource
	private ScreeningPlanDao screeningPlanDao;


	@Override
	public Film getFilmByName(String name) {
		// TODO Auto-generated method stub
		Film film = filmDao.fingByName(name);
		return film;
	}

	@Override
	public void publishFilm(Film film) {
		// TODO Auto-generated method stub
		filmDao.save(film);
	}

	@Override
	public List<String> getAllFilmNames() {
		// TODO Auto-generated method stub
		List<Film> films = filmDao.getAllFilms();
		List<String> filmNames = new ArrayList<String>();
		for(Film film:films){
			filmNames.add(film.getName());
		}
		return filmNames;
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		List<Film> films = filmDao.getAllFilms();
		return films;
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		filmDao.update(film);
	}

	@Override
	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		Film film = filmDao.get(Film.class, id);
		return film;
	}

	@Override
	public List<Film> getActiveFilms() {
		// TODO Auto-generated method stub
		List<ScreeningPlan> screeningPlans = screeningPlanDao.findActivePlans();
		List<Film> films = new ArrayList<Film>();
		for(ScreeningPlan screeningPlan:screeningPlans){
			Film film = filmDao.get(Film.class, screeningPlan.getFilmId());
			films.add(film);
		}
		return films;
	}

	@Override
	public void addPreparedTicket(int filmId, int count) {
		// TODO Auto-generated method stub
		Film film = filmDao.get(Film.class, filmId);
		film.setTicketPrepared(film.getTicketPrepared()+count);
		filmDao.update(film);
	}

	@Deprecated
	@Override
	public void addSoldTicket(int filmId, int count) {
		// TODO Auto-generated method stub
//		Film film = filmDao.get(film, id)
	}

}
