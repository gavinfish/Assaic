package com.cineplex.dao;

import java.util.List;

import com.cineplex.entity.ActivityRecord;

/**
 * interface of activity record entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:42:33
 *
 */

public interface ActivityRecordDao extends BaseDao<ActivityRecord> {
	/**
	 * get ids of activity records which a member has
	 *               attended by his id
	 * @param memberId
	 * @return List<Integer>:
	 * @throws
	 */
	public List<Integer> getActivityIdsByMemberId(int memberId);

	/**
	 * get activity records which a member hasn't attended by
	 *               his id
	 * @param memberId
	 * @return List<Integer>:
	 * @throws
	 */
	public List<Integer> getActiveIdsByMemberId(int memberId);

	/**
	 * get an activity record by its activity id and member
	 *               id
	 * @param memberId
	 * @param activityId
	 * @return ActivityRecord:
	 * @throws
	 */
	public ActivityRecord getByMemberIdAndActivityId(int memberId,
			int activityId);

	/**
	 * get count of members who have attended the activity by
	 *               id of activity
	 * @param activityId
	 * @return int:
	 * @throws
	 */
	public int getAttendCountById(int activityId);

	/**
	 * get all activity records
	 * @return List<ActivityRecord>:
	 * @throws
	 */
	public List<ActivityRecord> getAllActivityRecords();

	/**
	 * get attended records of an activity by its id
	 * @param activityId
	 * @return List<ActivityRecord>:
	 * @throws
	 */
	public List<ActivityRecord> getAttendedRecords(int activityId);
}
