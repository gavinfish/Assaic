package com.cineplex.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml",
"classpath*:/spring/app-config.xml"})
public class ActivityDaoImplTest extends
AbstractJUnit4SpringContextTests{
	@Resource
	private ActivityDao activityDao;

	@Test
	public void testGetActivitieListByName() {
		activityDao.getActivitieListByName("a");
	}

	@Test
	public void testGetActivitiesByFilmId() {
		activityDao.getActivitiesByFilmId(1);
	}

	@Test
	public void testGetAllActivities() {
		activityDao.getAllActivities();
	}

	@Test
	public void testGetEndedActivities() {
		activityDao.getEndedActivities();
	}

}
