package com.cineplex.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cineplex.dao.ActivityDao;
import com.cineplex.dao.ActivityRecordDao;
import com.cineplex.dao.CinemaConditionDao;
import com.cineplex.dao.FeeRecordDao;
import com.cineplex.dao.FilmDao;
import com.cineplex.dao.FilmRecordDao;
import com.cineplex.dao.MemberCardDao;
import com.cineplex.dao.ScreeningPlanDao;
import com.cineplex.dao.TicketDao;
import com.cineplex.dao.WaiterDao;
import com.cineplex.entity.Activity;
import com.cineplex.entity.ActivityRecord;
import com.cineplex.entity.CinemaCondition;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.Film;
import com.cineplex.entity.FilmRecord;
import com.cineplex.entity.MemberCard;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.entity.Ticket;
import com.cineplex.service.WaiterService;
import com.cineplex.util.DateUtil;

/**
 * implement of services of waiter
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:36:33  
*
 */

@Service("waiterService")
public class WaiterServiceImpl implements WaiterService{
	private static final Logger LOGGER = LogManager.getLogger(WaiterServiceImpl.class);
	
	@Resource
	private WaiterDao waiterDao;
	@Resource
	private ScreeningPlanDao screeningPlanDao;
	@Resource
	private TicketDao ticketDao;
	@Resource
	private ActivityDao activityDao;
	@Resource
	private ActivityRecordDao activityRecordDao;
	@Resource
	private FilmDao FilmDao;
	@Resource
	private FeeRecordDao feeRecordDao;
	@Resource
	private MemberCardDao memberCardDao;
	@Resource
	private CinemaConditionDao cinemaConditionDao;
	@Resource
	private FilmRecordDao filmRecordDao;

	@Override
	public boolean login(String accountName, String password) {
		// TODO Auto-generated method stub
		boolean result = waiterDao.findByAccountAndPw(accountName, password);
		return result;
	}

	@Override
	public void makePlan(ScreeningPlan screeningPlan) {
		// TODO Auto-generated method stub
		screeningPlanDao.save(screeningPlan);
	}

	@Override
	public void sellTicket(Ticket ticket, char feeType) {
		// TODO Auto-generated method stub
		ticketDao.save(ticket);
		Film film = FilmDao.get(Film.class, ticket.getFilmId());
		int count = ticket.getPrice()/film.getPrice();
		film.setTicketSold(film.getTicketSold()+count);
		FilmDao.update(film);
		
		//add activity record for member
		int recordId = ticket.getRecordId();
		FilmRecord filmRecord = filmRecordDao.get(FilmRecord.class, recordId);
		int filmId = filmRecord.getFilmId();
		int memberId = ticket.getMemberId();
		List<Activity> activities = activityDao.getActivitiesByFilmId(filmId);
		/**
		 * check if there is activities for the film
		 * if there is, add initial activity record
		 * if there is not, system will add initial activity record when 
		 * activity is created
		 */
		if(activities==null||activities.isEmpty()){
			//do nothing
		}
		else{
			for(Activity activity:activities){
				if(activityRecordDao.getByMemberIdAndActivityId(memberId, activity.getFilmId())==null){
					ActivityRecord activityRecord = new ActivityRecord();
					activityRecord.setActivityId(activity.getId());
					activityRecord.setHasAttend(false);
					activityRecord.setMemberId(memberId);
					activityRecordDao.save(activityRecord);
				}
			}
		}
		
		//add fee record for the ticket
//		FilmRecord filmRecord = filmRecordDao.get(FilmRecord.class, filmId);
//		Film film = FilmDao.get(Film.class, filmId);
		FeeRecord feeRecord = new FeeRecord();
		feeRecord.setFilmName(film.getName());
		feeRecord.setMoney(ticket.getPricePaid());
		feeRecord.setMemberId(memberId);
		feeRecord.setTime(DateUtil.getCurrentDate());
		feeRecord.setType(feeType);
		feeRecordDao.save(feeRecord);
		
		//add cinema condition
//		int recordId = ticket.getFilmId();
//		FilmRecord filmRecord = filmRecordDao.get(FilmRecord.class, recordId);
		Date date = filmRecord.getDate();
		LOGGER.info("ticket date: "+date);
		CinemaCondition cinemaCondition = cinemaConditionDao.getByDate(date);
		cinemaCondition.setCount(cinemaCondition.getCount()+1);
		String hall = ticket.getHall();
		if("1".equals(hall)){
			cinemaCondition.setHall1UsedCount(cinemaCondition.getHall1UsedCount()+1);
		}
		else if("2".equals(hall)){
			cinemaCondition.setHall2UsedCount(cinemaCondition.getHall2UsedCount()+1);
		}
		else{
			cinemaCondition.setHall3UsedCount(cinemaCondition.getHall3UsedCount()+1);
		}
	}
	

	@Override
	public void makeActivity(Activity activity) {
		// TODO Auto-generated method stub
		//add activity information
		activityDao.save(activity);
		int filmId = activity.getFilmId();
		activity = activityDao.getActivitiesByFilmId(filmId).get(0);
		//add activity record information for all members who has bought tickets for the film
		int activityId = activity.getId();
		List<Integer> memberIds = ticketDao.getMemberIdsByFilmId(filmId);
		/**
		 * add initial activity when the activity is created for
		 * who has bought the film ticket
		 */
		for(Integer memberId:memberIds){
			ActivityRecord activityRecord = new ActivityRecord();
			activityRecord.setActivityId(activityId);
			activityRecord.setHasAttend(false);
			activityRecord.setMemberId(memberId);
			activityRecordDao.save(activityRecord);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public long getTicketMoneyByType(char type) {
		// TODO Auto-generated method stub
		long result = ticketDao.getMoneyByType(type);
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getTicketCountByType(char type) {
		// TODO Auto-generated method stub
		int reuslt = ticketDao.getCountByType(type);
		return reuslt;
	}

	@Override
	public void modifyPlan(ScreeningPlan screeningPlan) {
		// TODO Auto-generated method stub
		screeningPlanDao.update(screeningPlan);
	}

	@Override
	public void endActivity() {
		// TODO Auto-generated method stub
		List<Activity> activities = activityDao.getEndedActivities();
		if (activities==null) {
			return;
		}
		for(Activity activity:activities){
			int activityId = activity.getId();
			List<ActivityRecord> activityRecords = activityRecordDao.getAttendedRecords(activityId);
//			List<ActivityRecord> answer1 = activityRecords.stream().filter(t->t.getAnswer()==1).collect(Collectors.toList());
//			List<ActivityRecord> answer2 = activityRecords.stream().filter(t->t.getAnswer()==1).collect(Collectors.toList());
//			List<ActivityRecord> answer3 = activityRecords.stream().filter(t->t.getAnswer()==1).collect(Collectors.toList());
			List<ActivityRecord> answer1 = new ArrayList<ActivityRecord>();
			List<ActivityRecord> answer2 = new ArrayList<ActivityRecord>();
			List<ActivityRecord> answer3 = new ArrayList<ActivityRecord>();
			for(ActivityRecord activityRecord:activityRecords){
				if (activityRecord.getAnswer()==1) {
					answer1.add(activityRecord);
				}
				else if (activityRecord.getAnswer()==2) {
					answer2.add(activityRecord);
				} 
				else if (activityRecord.getAnswer()==3) {
					answer3.add(activityRecord);
				}
			}
			List<ActivityRecord> win = answer1.size()>answer2.size()?answer1:answer2;
			win = win.size()>answer3.size()?win:answer3;
			for(ActivityRecord activityRecord:win){
				int memberId = activityRecord.getMemberId();
				MemberCard memberCard = memberCardDao.findByMemberId(memberId);
				memberCard.setIntegral(memberCard.getIntegral()+activity.getIntegral());
				memberCardDao.update(memberCard);
			}
			activity.setOver(1);
			activityDao.update(activity);
		}
	}
}
