package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * member card entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月2日 下午8:55:15
 *
 */

@Entity(name = "member_card")
public class MemberCard {
	/**
	 * id of a member card
	 */
	private int id;
	/**
	 * money in a member card
	 */
	private int money;
	/**
	 * integral of a member card
	 */
	private int integral;
	/**
	 * the id of a member who owns this member card
	 */
	private int memberId;
	/**
	 * if the member card is alive
	 */
	private char live;
	/**
	 * time of the card created
	 */
	private Date createTime;
	/**
	 * the level of the card
	 */
	private int level;
	/**
	 * time of the card suspended
	 */
	private Date suspendTime;
	/**
	 * all money recharged into this account
	 */
	private int moneyTotal;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "money", length = 11, nullable = false)
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Column(name = "integral", length = 11, nullable = false)
	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	@Column(name = "member_id", length = 11, nullable = false)
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Column(name = "live", length = 20, nullable = false)
	public char getLive() {
		return live;
	}

	public void setLive(char live) {
		this.live = live;
	}

	@Column(name = "create_time", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "level", length = 1, nullable = false)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "suspend_time")
	public Date getSuspendTime() {
		return suspendTime;
	}

	public void setSuspendTime(Date suspendTime) {
		this.suspendTime = suspendTime;
	}

	@Column(name = "money_total", length = 11, nullable = false)
	public int getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(int moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}

}
