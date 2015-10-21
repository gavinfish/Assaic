package com.cineplex.service;

import java.util.List;

import com.cineplex.entity.FilmRecord;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:52:04  
*
 */
public interface FilmRecordService {
	/**
	 * get all film records for a film by its id
	 * @param filmId
	 * @return List<FilmRecord>:
	 * @throws
	 */
	public List<FilmRecord> getFilmRecords(int filmId);

	/**
	 * get all seats' state(chosen or not chosen) by film
	 *               record's id
	 * @param @param filmRecordId
	 * @return char[]:
	 * @throws
	 */
	public char[] getSeatSate(int filmRecordId);

	/**
	 * get a film record by its id
	 * @param id
	 * @return FilmRecord:
	 * @throws
	 */
	public FilmRecord getFilmRecordById(int id);

	/**
	 * make a seat's state chosen by film record's id and the
	 *               identifier of a seat
	 * @param id
	 * @param seatChosen:
	 * @return void:
	 * @throws
	 */
	public void takeSeat(int id, String seatChosen);
}
