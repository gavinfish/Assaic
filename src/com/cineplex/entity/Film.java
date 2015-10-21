package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * film entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午1:32:21
 *
 */

@Entity
public class Film {
	/**
	 * the id of a film
	 */
	private int id;
	/**
	 * the name of a film
	 */
	private String name;
	/**
	 * the type of a film
	 */
	private String type;
	/**
	 * the price of the film ticket
	 */
	private int price;
	/**
	 * the release date of the film
	 */
	private Date releaseDate;
	/**
	 * the count of sold tickets
	 */
	private int ticketSold;
	/**
	 * the total count of tickets
	 */
	private int ticketPrepared;
	/**
	 * the description of the film
	 */
	private String description;
	/**
	 * if the first hall is used
	 */
	private boolean hall1Used;
	/**
	 * if the second hall is used
	 */
	private boolean hall2Used;
	/**
	 * if the third hall is used
	 */
	private boolean hall3Used;
	/**
	 * the last time of the film
	 */
	private int length;

	@Id
	@Column(name = "id", length = 20, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "price", length = 11, nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "time", nullable = false)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(name = "ticket_sold", length = 5, nullable = false)
	public int getTicketSold() {
		return ticketSold;
	}

	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	@Column(name = "ticket_prepared", length = 5, nullable = false)
	public int getTicketPrepared() {
		return ticketPrepared;
	}

	public void setTicketPrepared(int ticketPrepared) {
		this.ticketPrepared = ticketPrepared;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "hall1_used", nullable = false)
	public boolean isHall1Used() {
		return hall1Used;
	}

	public void setHall1Used(boolean hall1Used) {
		this.hall1Used = hall1Used;
	}

	@Column(name = "hall2_used", nullable = false)
	public boolean isHall2Used() {
		return hall2Used;
	}

	public void setHall2Used(boolean hall2Used) {
		this.hall2Used = hall2Used;
	}

	@Column(name = "hall3_used", nullable = false)
	public boolean isHall3Used() {
		return hall3Used;
	}

	public void setHall3Used(boolean hall3Used) {
		this.hall3Used = hall3Used;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
