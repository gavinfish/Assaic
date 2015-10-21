package com.cineplex.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cineplex.dao.impl.ActivityRecordDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml",
"classpath*:/spring/app-config.xml"})
public class ActivityRecordDaoImplTest{
	@Autowired
	private ActivityRecordDao activityRecordDao = new ActivityRecordDaoImpl();

	@Test
	public void testGetActivityIdsByMemberId() {
		activityRecordDao.getActivityIdsByMemberId(1);
	}

	@Test
	public void testGetActiveIdsByMemberId() {
		activityRecordDao.getActiveIdsByMemberId(1);
	}

	@Test
	public void testGetByMemberIdAndActivityId() {
		activityRecordDao.getByMemberIdAndActivityId(1, 1);
	}

	@Test
	public void testGetAttendCountById() {
		activityRecordDao.getAttendCountById(1);
	}

	@Test
	public void testGetAllActivityRecords() {
		activityRecordDao.getAllActivityRecords();
	}

	@Test
	public void testGetAttendedRecords() {
		activityRecordDao.getAttendedRecords(1);
	}

}
