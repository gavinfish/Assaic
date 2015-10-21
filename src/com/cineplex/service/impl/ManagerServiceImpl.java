package com.cineplex.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cineplex.dao.ActivityDao;
import com.cineplex.dao.ActivityRecordDao;
import com.cineplex.dao.CinemaConditionDao;
import com.cineplex.dao.FeeRecordDao;
import com.cineplex.dao.FilmDao;
import com.cineplex.dao.ManagerDao;
import com.cineplex.dao.MemberCardDao;
import com.cineplex.entity.Activity;
import com.cineplex.entity.CinemaCondition;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.Film;
import com.cineplex.entity.Manager;
import com.cineplex.service.ManagerService;
import com.cineplex.util.DateUtil;

/**
 * implement of services of manager
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:34:33  
*
 */

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	public static final String HALL1_NAME = "一号影厅";
	public static final String HALL2_NAME = "二号影厅";
	public static final String HALL3_NAME = "三号影厅";
	
	@Resource
	private ManagerDao managerDao;
	@Resource
	private CinemaConditionDao cinemaConditionDao;
	@Resource
	private FilmDao filmDao;
	@Resource
	private FeeRecordDao feeRecordDao;
	@Resource
	private ActivityRecordDao activityRecordDao;
	@Resource
	private ActivityDao activityDao;
	@Resource
	private MemberCardDao memberCardDao;

	@Override
	public boolean login(String accountName, String password) {
		// TODO Auto-generated method stub
		Manager manager = managerDao.findByAccountAndPsw(accountName, password);
		return manager!=null;
	}

	@Override
	public int[] getDayPeople() {
		// TODO Auto-generated method stub
		int[] result = new int[7];
		Date date = DateUtil.getCurrentDate();
		result[0] = cinemaConditionDao.getDayCount(date);
		for(int i=0;i<6;i++){
			date = DateUtil.getDayBefore(date);
			result[i+1] = cinemaConditionDao.getDayCount(date);
		}
		return result;
	}

	@Override
	public int[] getMonthPeople() {
		// TODO Auto-generated method stub
		int[] result = new int[12];
		Date date = DateUtil.getCurrentDate();
		Date dateStart = DateUtil.getFirstDay(date);
		Date dateEnd = DateUtil.getLastDay(date);
		result[0] = cinemaConditionDao.getCount(dateStart, dateEnd);
		for(int i=0;i<11;i++){
			date = DateUtil.getMonthBefroe(dateStart);
			dateStart = DateUtil.getFirstDay(date);
			dateEnd = DateUtil.getLastDay(date);
			result[i+1] = cinemaConditionDao.getCount(dateStart, dateEnd);
		}
		return result;
	}

	@Override
	public Map<String, Double> getFilmAttendance() {
		// TODO Auto-generated method stub
		List<Film> films = filmDao.getAllFilms();
		Map<String, Double> result = new HashMap<String, Double>();
		for(Film film:films){
			if(film.getTicketSold()==0){
				result.put(film.getName(), (double) 0);
			}
			else{
				result.put(film.getName(), (double) (Math.round((double)film.getTicketSold()/film.getTicketPrepared()*1000)/(double)10));
			}
		}
		return result;
	}

	@Override
	public Map<String, double[]> getHallAttendance() {
		// TODO Auto-generated method stub
		Map<String, double[]> result = new HashMap<String, double[]>();
		double[] hall1 = new double[7];
		double[] hall2 = new double[7];
		double[] hall3 = new double[7];
		Date date = DateUtil.getCurrentDate();
		CinemaCondition cinemaCondition = cinemaConditionDao.getByDate(date);
		if (cinemaCondition!=null) {
			hall1[0] = (double)cinemaCondition.getHall1UsedCount()/cinemaCondition.getHall1()*100;
			hall2[0] = (double)cinemaCondition.getHall2UsedCount()/cinemaCondition.getHall2()*100;
			hall3[0] = (double)cinemaCondition.getHall3UsedCount()/cinemaCondition.getHall3()*100;		
		}

		for(int i=0;i<6;i++){
			date = DateUtil.getDayBefore(date);
			cinemaCondition = cinemaConditionDao.getByDate(date);
			if (cinemaCondition!=null) {
				hall1[i+1] = (double)cinemaCondition.getHall1UsedCount()/cinemaCondition.getHall1()*100;
				hall2[i+1] = (double)cinemaCondition.getHall2UsedCount()/cinemaCondition.getHall2()*100;
				hall3[i+1] = (double)cinemaCondition.getHall3UsedCount()/cinemaCondition.getHall3()*100;
			}
		}
		result.put("一号影厅", hall1);
		result.put("二号影厅", hall2);
		result.put("三号影厅", hall3);
		
		return result;
	}

	@Override
	public long[] getTicketMoney() {
		// TODO Auto-generated method stub
		long[] result = new long[2];
		List<FeeRecord> card = feeRecordDao.getCardRecords();
		List<FeeRecord> cash = feeRecordDao.getCashRecords();
		for(FeeRecord feeRecord:card){
			result[0] += feeRecord.getMoney();
		}
		for(FeeRecord feeRecord:cash){
			result[1] += feeRecord.getMoney();
		}
		return result;
	}

	@Override
	public int[] getTicketCount() {
		// TODO Auto-generated method stub
		int[] result = new int[2];
		List<FeeRecord> card = feeRecordDao.getCardRecords();
		List<FeeRecord> cash = feeRecordDao.getCashRecords();
		result[0] = card.size();
		result[1] = cash.size();
		return result;
	}

	@Override
	public Map<String, Integer> getActivityStatistic() {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		List<Activity> activities = activityDao.getAllActivities();
		for(Activity activity:activities){
			result.put(activity.getName(), activityRecordDao.getAttendCountById(activity.getId()));
		}
		return result;
	}

	@Override
	public Map<String, Integer> getMemberCardStatistic() {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("有效", memberCardDao.getCountByState(MemberCardServiceImpl.MEMBER_CARD_STATE_ALIVE));
		result.put("停止", memberCardDao.getCountByState(MemberCardServiceImpl.MEMBER_CARD_STATE_DEAD));
		result.put("暂停", memberCardDao.getCountByState(MemberCardServiceImpl.MEMBER_CARD_STATE_SUSPEND));
		result.put("取消", memberCardDao.getCountByState(MemberCardServiceImpl.MEMBER_CARD_STATE_DISACTIVE));
		return result;
	}

	@Override
	public int[] getMonthPeopleStatistic(int year, int month) {
		// TODO Auto-generated method stub
		int[] result = new int[31];
		Date date = DateUtil.getDateByYearAndMonth(year, month);
		Date dateStart = DateUtil.getFirstDay(date);
		for(int i=0;i<31;++i){
			result[i] = cinemaConditionDao.getCount(dateStart, dateStart);
			dateStart = DateUtil.getDayLater(dateStart);
		}
		return result;
	}

	@Override
	public Map<String, double[]> getMonthHallStatistic(int year, int month) {
		// TODO Auto-generated method stub
		Map<String, double[]> result = new HashMap<String, double[]>();
		double[] hall1 = new double[31];
		double[] hall2 = new double[31];
		double[] hall3 = new double[31];
		Date date = DateUtil.getDateByYearAndMonth(year, month);
		date = DateUtil.getFirstDay(date);
		for(int i=0;i<31;i++){
			CinemaCondition cinemaCondition = cinemaConditionDao.getByDate(date);
			if(cinemaCondition!=null){
				hall1[i] = (double)cinemaCondition.getHall1UsedCount()/cinemaCondition.getHall1()*100;
				hall2[i] = (double)cinemaCondition.getHall2UsedCount()/cinemaCondition.getHall2()*100;
				hall3[i] = (double)cinemaCondition.getHall3UsedCount()/cinemaCondition.getHall3()*100;
			}
			date=DateUtil.getDayLater(date);
		}
		result.put("一号影厅", hall1);
		result.put("二号影厅", hall2);
		result.put("三号影厅", hall3);
		return result;
	}

	@Override
	public Map<String, Integer[]> getMonthMoneyStatistic(int year, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
