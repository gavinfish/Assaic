package com.cineplex.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * screening plan entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月31日 上午8:50:48
 *
 */

@Entity(name = "screening_plan")
public class ScreeningPlan {
	/**
	 * id of a screening plan
	 */
	private int id;
	/**
	 * the hall used for the plan
	 */
	private boolean hall1;
	private boolean hall2;
	private boolean hall3;
	/**
	 * the number of the seats used for the plan
	 */
	private int seat;
	/**
	 * the id of the film in the plan
	 */
	private int filmId;
	/**
	 * start date of the plan
	 */
	private Date startDate;
	/**
	 * end date of the plan
	 */
	private Date endDate;
	/**
	 * the first period of the film
	 */
	private Time period1;
	/**
	 * the second period of the film, may not exist
	 */
	private Time period2;
	/**
	 * the third period of the film, may not exist
	 */
	private Time period3;
	/**
	 * the forth period of the film, may not exist
	 */
	private Time period4;
	/**
	 * the price set for the film
	 */
	private int price;
	/**
	 * the state of the plan, approved or not
	 */
	private String state;
	/**
	 * comment of the manager if the plan is not passed
	 */
	private String comment;
	/**
	 * name of film in the plan
	 */
	private String filmName;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "hall1")
	public boolean isHall1() {
		return hall1;
	}

	public void setHall1(boolean hall1) {
		this.hall1 = hall1;
	}

	@Column(name = "hall2")
	public boolean isHall2() {
		return hall2;
	}

	public void setHall2(boolean hall2) {
		this.hall2 = hall2;
	}

	@Column(name = "hall3")
	public boolean isHall3() {
		return hall3;
	}

	public void setHall3(boolean hall3) {
		this.hall3 = hall3;
	}

	@Column(name = "seat", length = 11, nullable = false)
	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Column(name = "film_id", length = 11, nullable = false)
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(name = "date_start", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "date_end", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "period1", nullable = false)
	public Time getPeriod1() {
		return period1;
	}

	public void setPeriod1(Time period1) {
		this.period1 = period1;
	}

	@Column(name = "period2")
	public Time getPeriod2() {
		return period2;
	}

	public void setPeriod2(Time period2) {
		this.period2 = period2;
	}

	@Column(name = "period3")
	public Time getPeriod3() {
		return period3;
	}

	public void setPeriod3(Time period3) {
		this.period3 = period3;
	}

	@Column(name = "period4")
	public Time getPeriod4() {
		return period4;
	}

	public void setPeriod4(Time period4) {
		this.period4 = period4;
	}

	@Column(name = "price", length = 11, nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "film_name", nullable = false)
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
