package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:08:55  
*
 */
@Entity(name = "fee_record")
public class FeeRecord {
	/**
	 * id of the record
	 */
	private int id;
	/**
	 * member id of the record
	 */
	private int memberId;
	/**
	 * type of fee, in: recharge, out: pay in money, integral:pay in integral
	 */
	private char type;
	/**
	 * money used in the record
	 */
	private double money;
	/**
	 * if the record is for paying
	 */
	private String filmName;
	/**
	 * time of the record
	 */
	private Date time;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "member_id")
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Column(name = "film_name")
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return MyToString.getString(this);
	}
}
