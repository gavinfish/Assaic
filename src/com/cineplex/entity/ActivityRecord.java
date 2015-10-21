package com.cineplex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cineplex.util.MyToString;

/**
 * activity record entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月30日 下午2:16:26
 *
 */

@Entity(name = "activity_record")
public class ActivityRecord {
	/**
	 * the id of a activity record
	 */
	private int id;
	/**
	 * the id of the activity
	 */
	private int activityId;
	/**
	 * the id of the member who attends the activity
	 */
	private int memberId;
	/**
	 * the date of the record
	 */
	private Date date;
	/**
	 * if member attend the activity
	 */
	private boolean hasAttend;
	/**
	 * member's answer of the activity: 1 or 2 or 3
	 */
	private int answer;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "activity_id", length = 11, nullable = false)
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	@Column(name = "member_id", length = 11, nullable = false)
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "has_attend")
	public boolean isHasAttend() {
		return hasAttend;
	}

	public void setHasAttend(boolean hasAttend) {
		this.hasAttend = hasAttend;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MyToString.getString(this);
	}
}
