package com.cineplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * bank card entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午2:12:06
 *
 */

@Entity(name = "bank_card")
public class BankCard {
	/**
	 * the id a bank card
	 */
	private long id;
	/**
	 * the money on the bank card
	 */
	private int money;
	/**
	 * the id of the owner
	 */
	private int memberId;

	@Id
	@Column(name = "id", length = 20, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "money", length = 11, nullable = false)
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Column(name = "member_id", length = 11, nullable = false)
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
