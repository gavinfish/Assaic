package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.FeeRecordDao;
import com.cineplex.entity.FeeRecord;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:17:01  
*
 */
@Repository("feeRecordDao")
public class FeeRecordDaoImpl extends BaseDaoImpl<FeeRecord> implements FeeRecordDao{

	@Override
	public List<FeeRecord> getRechargeRecords() {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.type = 3";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getCashRecords() {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.type = 0 or fr.type = 4";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getIntegralRecords() {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.type = 2";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getCardRecords() {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.type = 1";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getRecordsByMemberId(int memberId) {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.memberId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getComsuptionRecord(int memberId) {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.memberId = ? and fr.type <> 3";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getRechargeRecord(int memberId) {
		// TODO Auto-generated method stub
		String hql = "from fee_record fr where fr.memberId = ? and fr.type = 3";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<FeeRecord> feeRecords = query.list();
		return feeRecords;
	}

}
