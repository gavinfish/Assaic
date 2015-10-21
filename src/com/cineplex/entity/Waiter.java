package com.cineplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * waiter entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午2:38:40
 *
 */

@Entity
public class Waiter {
	/**
	 * id of the waiter
	 */
	private int id;
	/**
	 * login account of the waiter
	 */
	private String account;
	/**
	 * the password of the account
	 */
	private String password;

	@Column(name = "id", length = 20, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "account", nullable = false)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
