package com.cineplex.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:09:08  
*
 */
@Entity(name = "film_record")
public class FilmRecord {
	private int id;
	private int filmId;
	private int hall;
	private long seat;
	private Time start;
	private Time end;
	private Date date;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "film_id")
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public long getSeat() {
		return seat;
	}

	public void setSeat(long seat2) {
		this.seat = seat2;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
