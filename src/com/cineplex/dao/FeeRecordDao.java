package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.FeeRecord;

public interface FeeRecordDao extends BaseDao<FeeRecord> {
	/**
	 * get all records of recharge
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getRechargeRecords();

	/**
	 * get records of paying by cash
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getCashRecords();

	/**
	 * get records of paying by integral
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getIntegralRecords();

	/**
	 * get records of paying by member card
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getCardRecords();

	/**
	 * get all fee records of a member by his id
	 * @param memberId
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getRecordsByMemberId(int memberId);

	/**
	 * get consumption records of a member by his id
	 * @param memberId
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getComsuptionRecord(int memberId);

	/**
	 * get recharge records of a member by his id
	 * @param memberId
	 * @return List<FeeRecord>:
	 * @throws
	 */
	public List<FeeRecord> getRechargeRecord(int memberId);
}
