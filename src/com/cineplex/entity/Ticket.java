package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * ticket entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月31日 上午8:35:44
 *
 */

@Entity
public class Ticket {
	/**
	 * id of a ticket
	 */
	private int id;
	/**
	 * the id of the film for the ticket
	 */
	private int filmId;
	/**
	 * the time when the ticket is taken
	 */
	private Date time;
	/**
	 * the id the member who buys the ticket
	 */
	private int memberId;
	/**
	 * the price of the ticket
	 */
	private int price;
	/**
	 * money paid for the ticket
	 */
	private int pricePaid;
	/**
	 * how a member pays for the ticket
	 */
	private String payType;
	/**
	 */
	private String hall;
	private int recordId;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "film_id", length = 11, nullable = false)
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(name = "time", nullable = false)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "member_id", length = 11, nullable = false)
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Column(name = "price", length = 11, nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "price_paid", length = 11, nullable = false)
	public int getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(int pricePaid) {
		this.pricePaid = pricePaid;
	}

	@Column(name = "pay_type", length = 20, nullable = false)
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getHall() {
		return hall;
	}

	public void setHall(String hall) {
		this.hall = hall;
	}

	@Column(name="record_id")
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
