package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.ActivityRecordDao;
import com.cineplex.entity.ActivityRecord;

/**
 * implements of DAO interface of activity record entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:46:34  
*
 */

@Repository("activityRecordDao")
public class ActivityRecordDaoImpl extends BaseDaoImpl<ActivityRecord> implements ActivityRecordDao{

	@Override
	public List<Integer> getActivityIdsByMemberId(int memberId) {
		// TODO Auto-generated method stubs
		String hql = "select distinct ar.activityId from activity_record ar where ar.memberId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<Integer> activityIds = query.list();
		return activityIds;
	}

	@Override
	public List<Integer> getActiveIdsByMemberId(int memberId) {
		// TODO Auto-generated method stub
		String hql = "select distinct ar.activityId from activity_record ar where ar.memberId = ? and ar.hasAttend = false";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<Integer> activityIds = query.list();
		return activityIds;
	}

	@Override
	public ActivityRecord getByMemberIdAndActivityId(int memberId, int activityId) {
		// TODO Auto-generated method stub
		String hql = "from activity_record ar where ar.memberId = ? and ar.activityId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		query.setParameter(1, activityId);
		@SuppressWarnings("unchecked")
		List<ActivityRecord> activityRecords = query.list();
		if(activityRecords!=null&&!activityRecords.isEmpty()){
			return activityRecords.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public int getAttendCountById(int activityId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from activity_record ar where ar.activityId = ? and ar.hasAttend = true";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, activityId);
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public List<ActivityRecord> getAllActivityRecords() {
		// TODO Auto-generated method stub
		String hql = "from activity_record ar";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ActivityRecord> activityRecords = query.list();
		return activityRecords;
	}

	@Override
	public List<ActivityRecord> getAttendedRecords(int activityId) {
		// TODO Auto-generated method stub
		String hql = "from activity_record ar where ar.activityId = ? and ar.hasAttend = true";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, activityId);
		@SuppressWarnings("unchecked")
		List<ActivityRecord> activityRecords = query.list();
		return activityRecords;
	}

}
