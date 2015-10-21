package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.FilmRecord;

public interface FilmRecordDao extends BaseDao<FilmRecord> {
	/**
	 * find all film records of a film by its id
	 * @param filmId
	 * @return List<FilmRecord>:
	 * @throws
	 */
	public List<FilmRecord> findRecordsByFilmId(int filmId);
}
