package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * member entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月25日 下午7:15:23
 *
 */

@Entity
public class Member {
	/**
	 * the id of a member
	 */
	private int id;
	/**
	 * the account for member to login in
	 */
	private String accountName;
	/**
	 * the password of the account
	 */
	private String password;
	/**
	 * gender type of member,choice 男/女
	 */
	private String gender;
	/**
	 * the id of the member's membership card
	 */
	private int memberCardId;
	/**
	 * the id of the member's bank card
	 */
	private long bankCardId;
	/**
	 * birthday of the member
	 */
	private Date birthday;
	/**
	 * address of the member
	 */
	private String address;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "account", length = 30, nullable = false)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "password", length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender", length = 20, nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "member_card_id", length = 7, nullable = false)
	public int getMemberCardId() {
		return memberCardId;
	}

	public void setMemberCardId(int memberCardId) {
		this.memberCardId = memberCardId;
	}

	@Column(name = "bank_card_id", length = 11, nullable = false)
	public long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}

	@Column(name = "birthday", nullable = false)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// @Override
	// public String toString() {
	// // TODO Auto-generated method stub
	// StringBuilder stringBuilder = new StringBuilder();
	// String delimiter = " ";
	// stringBuilder.append("id:").append(getId()).append(delimiter);
	// stringBuilder.append("accountName:").append(getAccountName()).append(delimiter);
	// stringBuilder.append("password:").append(getPassword()).append(delimiter);
	// stringBuilder.append("gender:").append(getGender()).append(delimiter);
	// stringBuilder.append("memberCardId:").append(getMemberCardId()).append(delimiter);
	// stringBuilder.append("bankCardId:").append(getBankCardId()).append(delimiter);
	// stringBuilder.append("birthday:").append(getBirthday()).append(delimiter);
	// stringBuilder.append("address:").append(getAddress());
	// return stringBuilder.toString();
	// }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}

}
