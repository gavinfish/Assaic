package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * activity entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午2:23:37
 *
 */

@Entity
public class Activity {
	/**
	 * the id of a activity
	 */
	private int id;
	/**
	 * the name the activity
	 */
	private String name;
	/**
	 * the start date of the activity
	 */
	private Date startDate;
	/**
	 * the end date of the activity
	 */
	private Date endDate;
	/**
	 * id the film related to the activity
	 */
	private int filmId;
	/**
	 * the first question of the activity
	 */
	private String question1;
	/**
	 * the choices of the first question
	 */
	private String options1;
	/**
	 * the second question of the activity, may not exist
	 */
	private String question2;
	/**
	 * the choices of the second question
	 */
	private String options2;
	/**
	 * the third question of the activity, may not exist
	 */
	private String question3;
	/**
	 * the choices of the third question
	 */
	private String options3;
	/**
	 * the ids of screening plans mapped to the activity
	 */
	private String screeningPlanId;
	/**
	 * integral for the activity
	 */
	private int integral;
	/**
	 * name of film related to the activity
	 */
	private String filmName;
	private int over;

	@Id
	@Column(name = "id", length = 20, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "start_time", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_time", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "film_id", length = 20, nullable = false)
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(name = "question1", nullable = false)
	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	@Column(name = "option1", nullable = false)
	public String getOptions1() {
		return options1;
	}

	public void setOptions1(String options1) {
		this.options1 = options1;
	}

	@Column(name = "question2")
	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	@Column(name = "option2")
	public String getOptions2() {
		return options2;
	}

	public void setOptions2(String options2) {
		this.options2 = options2;
	}

	@Column(name = "question3")
	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	@Column(name = "option3")
	public String getOptions3() {
		return options3;
	}

	public void setOptions3(String options3) {
		this.options3 = options3;
	}

	@Column(name = "screening_plan_id", nullable = false)
	public String getScreeningPlanId() {
		return screeningPlanId;
	}

	public void setScreeningPlanId(String screeningPlanId) {
		this.screeningPlanId = screeningPlanId;
	}


	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}
	
	@Column(name = "film_name")
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}


	public int getOver() {
		return over;
	}

	public void setOver(int over) {
		this.over = over;
	}

	@Override
	public String toString() {
		return MyToString.getString(this);
	}
}
