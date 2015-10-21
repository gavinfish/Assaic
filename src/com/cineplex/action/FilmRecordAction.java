package com.cineplex.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cineplex.entity.FilmRecord;
import com.cineplex.service.FilmRecordService;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:24:50  
*
 */
public class FilmRecordAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(FilmRecordAction.class);

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private FilmRecordService filmRecordService;

	private int recordId;
	private int filmId;
	private List<FilmRecord> filmRecords;
	private char[] seats;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public List<FilmRecord> getFilmRecords() {
		return filmRecords;
	}

	public void setFilmRecords(List<FilmRecord> filmRecords) {
		this.filmRecords = filmRecords;
	}

	public char[] getSeats() {
		return seats;
	}

	public void setSeats(char[] seats) {
		this.seats = seats;
	}

	/**
	 * 
	* get screening records of a film by its id
	* @return
	* String  
	* @throws
	 */
	public String getFilmRecordByFilmId() {
		LOGGER.info("film id: " + filmId);
		filmRecords = filmRecordService.getFilmRecords(filmId);
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
	* get seat situation of a screening record
	* @return
	* String  
	* @throws
	 */
	public String checkSeat() {
		seats = filmRecordService.getSeatSate(recordId);
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
	* choose a seat
	* @return
	* String  
	* @throws
	 */
	@Deprecated
	public String chooseSeat() {

		return SUCCESS;
	}
}
