package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * cinema condition record entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午1:58:52
 *
 */

@Entity(name = "cinema_condition")
public class CinemaCondition {
	/**
	 * the id of cinema condition record
	 */
	private int id;
	/**
	 * the date of the condition record
	 */
	private Date date;
	/**
	 * the count of customs
	 */
	private int count;
	/**
	 * the count of customs in the first hall
	 */
	private int hall1UsedCount;
	/**
	 * the count of customs in the second hall
	 */
	private int hall2UsedCount;
	/**
	 * the count of customs in the third hall
	 */
	private int hall3UsedCount;
	private int hall1;
	private int hall2;
	private int hall3;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "time", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "count", length = 11, nullable = false)
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Column(name = "hall1_used", length = 11, nullable = false)
	public int getHall1UsedCount() {
		return hall1UsedCount;
	}

	public void setHall1UsedCount(int hall1UsedCount) {
		this.hall1UsedCount = hall1UsedCount;
	}

	@Column(name = "hall2_used", length = 11, nullable = false)
	public int getHall2UsedCount() {
		return hall2UsedCount;
	}

	public void setHall2UsedCount(int hall2UsedCount) {
		this.hall2UsedCount = hall2UsedCount;
	}

	@Column(name = "hall3_used", length = 11, nullable = false)
	public int getHall3UsedCount() {
		return hall3UsedCount;
	}

	public void setHall3UsedCount(int hall3UsedCount) {
		this.hall3UsedCount = hall3UsedCount;
	}

	public int getHall1() {
		return hall1;
	}

	public void setHall1(int hall1) {
		this.hall1 = hall1;
	}

	public int getHall2() {
		return hall2;
	}

	public void setHall2(int hall2) {
		this.hall2 = hall2;
	}

	public int getHall3() {
		return hall3;
	}

	public void setHall3(int hall3) {
		this.hall3 = hall3;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
