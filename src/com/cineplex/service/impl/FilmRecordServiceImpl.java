package com.cineplex.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.FilmRecordDao;
import com.cineplex.entity.FilmRecord;
import com.cineplex.service.FilmRecordService;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:53:20  
*
 */
@Repository("filmRecordService")
public class FilmRecordServiceImpl implements FilmRecordService {
	private static final Logger LOGGER = LogManager
			.getLogger(FilmRecordServiceImpl.class);

	@Resource
	private FilmRecordDao filmRecordDao;

	@Override
	public List<FilmRecord> getFilmRecords(int filmId) {
		// TODO Auto-generated method stub
		List<FilmRecord> filmRecords = filmRecordDao
				.findRecordsByFilmId(filmId);
		return filmRecords;
	}

	@Override
	public char[] getSeatSate(int filmRecordId) {
		// TODO Auto-generated method stub
		LOGGER.info("film record id that chosen: " + filmRecordId);
		FilmRecord filmRecord = filmRecordDao.get(FilmRecord.class,
				filmRecordId);
		long seat = filmRecord.getSeat();
		char[] seats = seatsIntToChar(seat);
		return seats;
	}

	@Override
	public FilmRecord getFilmRecordById(int id) {
		// TODO Auto-generated method stub
		FilmRecord record = filmRecordDao.get(FilmRecord.class, id);
		return record;
	}

	@Override
	public void takeSeat(int id, String seatChosen) {
		// TODO Auto-generated method stub
		FilmRecord filmRecord = filmRecordDao.get(FilmRecord.class, id);
		long seat = filmRecord.getSeat();
		char[] seats = seatsIntToChar(seat);
		String[] chosens = seatChosen.split(",");
		for (String chosen : chosens) {
			seats[Integer.parseInt(chosen.trim()) - 1] = '1';
		}
		seat = toInt(seats);
		filmRecord.setSeat(seat);
		LOGGER.info("seat long: "+seat);
		filmRecordDao.update(filmRecord);
	}

	private char[] seatsIntToChar(long seat) {
		String seatString = Long.toBinaryString(seat);
		int length = seatString.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 60 - length; i++) {
			sb.append('0');
		}
		sb.append(seatString);
		return sb.toString().toCharArray();
	}

	private long toInt(char[] bi) {
		long len = bi.length;
		long sum = 0;
		long tmp,  max = len - 1;
		for (int i = 0; i < len; ++i) {
		tmp = bi[i] - '0';
		sum += tmp * Math.pow(2, max--);
		}
		return sum;
	}
}
