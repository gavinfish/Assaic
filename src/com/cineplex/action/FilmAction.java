package com.cineplex.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.Film;
import com.cineplex.service.FilmService;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:23:33  
*
 */
@Controller
public class FilmAction extends BaseAction {
	private static final Logger LOGGER = LogManager.getLogger(FilmAction.class);

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private FilmService filmService;

	private String filmName;
	private String filmType;
	private String description;
	private int length;

	private List<Film> films;

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	/**
	 * 
	* publish a film
	* @return
	* String  
	* @throws
	 */
	public String publishFilm() {
		Film film = new Film();
		film.setDescription(description);
		film.setHall1Used(false);
		film.setHall2Used(false);
		film.setHall3Used(false);
		film.setLength(length);
		film.setName(filmName);
		film.setPrice(0);
		film.setReleaseDate(DateUtil.getCurrentDate());
		film.setTicketPrepared(0);
		film.setTicketSold(0);
		film.setType(filmType);

		filmService.publishFilm(film);
		return SUCCESS;
	}

	/**
	 * 
	* get names of all films
	* @return
	* String  
	* @throws
	 */
	public String getAllFilmNames() {
		List<String> filmNames = filmService.getAllFilmNames();
		request().setAttribute("filmNames", filmNames);
		return SUCCESS;
	}

	/**
	 * 
	* get all films
	* @return
	* String  
	* @throws
	 */
	public String getAllFilms() {
		films = filmService.getAllFilms();
		String accountType = (String) session().get("account_type");
		if (accountType.equals(LoginAction.ACCOUNT_TYPE_MEMBER)) {
			return LoginAction.MEMBER_SUCCESS;
		} else if (accountType.equals(LoginAction.ACCOUNT_TYPE_WAITER)) {
			return LoginAction.WAITER_SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 
	* get films' name which still have screening plans
	* @return
	* String  
	* @throws
	 */
	public String getActiveFilmNames() {
		films = filmService.getActiveFilms();
		LOGGER.info("active films count: " + films.size());
		return SUCCESS;
	}
}
