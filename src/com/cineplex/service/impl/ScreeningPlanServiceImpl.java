package com.cineplex.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cineplex.dao.CinemaConditionDao;
import com.cineplex.dao.FilmDao;
import com.cineplex.dao.FilmRecordDao;
import com.cineplex.dao.ScreeningPlanDao;
import com.cineplex.entity.CinemaCondition;
import com.cineplex.entity.Film;
import com.cineplex.entity.FilmRecord;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.service.ScreeningPlanService;
import com.cineplex.util.BooleanMathUtil;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:56:01  
*
 */
@Service("screeningPlanService")
public class ScreeningPlanServiceImpl implements ScreeningPlanService{
	private static final Logger LOGGER = LogManager.getLogger(ScreeningPlanServiceImpl.class);
	
	public static final String PLAN_STATE_UNCHECKED = "not";
	public static final String PLAN_STATE_PASSED = "yes";
	public static final String PLAN_STATE_UNPASSED = "no";
	
	@Resource
	private ScreeningPlanDao screeningPlanDao;
	@Resource
	private FilmDao filmDao;
	@Resource
	private FilmRecordDao filmRecordDao;
	@Resource
	private CinemaConditionDao cinemaConditionDao;

	@Override
	public List<ScreeningPlan> getPlansByFilmName(String filmName) {
		// TODO Auto-generated method stub
		Film film = filmDao.fingByName(filmName);
		if(film==null){
			return new ArrayList<ScreeningPlan>();
		}
		int filmId = film.getId();
		List<ScreeningPlan> screeningPlans = screeningPlanDao.findPlanByFilmId(filmId);
		return screeningPlans;
	}

	@Override
	public List<ScreeningPlan> getUncheckedPlan() {
		// TODO Auto-generated method stub
		List<ScreeningPlan> screeningPlans = screeningPlanDao.findPlanByState(PLAN_STATE_UNCHECKED);
		return screeningPlans;
	}

	@Override
	public List<ScreeningPlan> getUnpassedPlan() {
		// TODO Auto-generated method stub
		List<ScreeningPlan> screeningPlans = screeningPlanDao.findPlanByState(PLAN_STATE_UNPASSED);
		return screeningPlans;
	}

	@Override
	public List<ScreeningPlan> getPassedPlan() {
		// TODO Auto-generated method stub
		List<ScreeningPlan> screeningPlans = screeningPlanDao.findPlanByState(PLAN_STATE_PASSED);
		return screeningPlans;
	}

	@Override
	public void repleyPlan(ScreeningPlan screeningPlan) {
		// TODO Auto-generated method stub
		screeningPlanDao.update(screeningPlan);
		
		String state = screeningPlan.getState();
		if(state.equals(ScreeningPlanServiceImpl.PLAN_STATE_PASSED)){
			Film film = filmDao.fingByName(screeningPlan.getFilmName());
			
			//add new film record
			FilmRecord filmRecord = new FilmRecord();
			filmRecord.setEnd(DateUtil.timeAddMinute(screeningPlan.getPeriod1(), film.getLength()));
			filmRecord.setFilmId(film.getId());
			filmRecord.setSeat(0);
			filmRecord.setStart(screeningPlan.getPeriod1());
			int gap = DateUtil.getGap(screeningPlan.getStartDate(), screeningPlan.getEndDate());
			Date date = screeningPlan.getStartDate();
			LOGGER.info("gap: "+gap);
			addFilmRecord(filmRecord, screeningPlan, date);
			for(int i=0;i<gap;i++){
				date = DateUtil.getNextDay(date);
				LOGGER.info("date: "+date);
				addFilmRecord(filmRecord, screeningPlan, date);
			}
			
			//add new cinema condition
			int screeningPlanId = screeningPlan.getId();
			screeningPlan = screeningPlanDao.get(ScreeningPlan.class, screeningPlanId);
			Date startDate = screeningPlan.getStartDate();
			Date endDate = screeningPlan.getEndDate();
			endDate = DateUtil.getDayLater(endDate);
			LOGGER.info("start date: "+startDate+ "    "+"end date: "+endDate);
			while(startDate.before(endDate)){
				CinemaCondition cinemaCondition = cinemaConditionDao.getByDate(startDate);
				if(cinemaCondition==null){
					cinemaCondition = new CinemaCondition();
					cinemaCondition.setCount(0);
					cinemaCondition.setDate(startDate);
					BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
					cinemaCondition.setHall1(booleanMathUtil.add(screeningPlan.isHall1()).getResult()*60);
					cinemaCondition.setHall2(booleanMathUtil.add(screeningPlan.isHall2()).getResult()*60);
					cinemaCondition.setHall3(booleanMathUtil.add(screeningPlan.isHall3()).getResult()*60);
					cinemaCondition.setHall1UsedCount(0);
					cinemaCondition.setHall2UsedCount(0);
					cinemaCondition.setHall3UsedCount(0);
					cinemaConditionDao.save(cinemaCondition);
				}
				else{
					BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
					cinemaCondition.setHall1(cinemaCondition.getHall1()+booleanMathUtil.add(screeningPlan.isHall1()).getResult()*60);
					cinemaCondition.setHall2(cinemaCondition.getHall2()+booleanMathUtil.add(screeningPlan.isHall2()).getResult()*60);
					cinemaCondition.setHall3(cinemaCondition.getHall3()+booleanMathUtil.add(screeningPlan.isHall3()).getResult()*60);
					cinemaConditionDao.update(cinemaCondition);
				}
				startDate = DateUtil.getDayLater(startDate);
			}
		}
	}
	
	private void addFilmRecord(FilmRecord filmRecord,ScreeningPlan screeningPlan,Date date){
		filmRecord.setDate(date);
		if(screeningPlan.isHall1()){
			filmRecord.setHall(1);
			filmRecordDao.save(filmRecord);
		}
		if(screeningPlan.isHall2()){
			filmRecord.setHall(2);
			filmRecordDao.save(filmRecord);
		}
		if(screeningPlan.isHall3()){
			filmRecord.setHall(3);
			filmRecordDao.save(filmRecord);
		}
	}

	@Override
	public ScreeningPlan getPlanById(int id) {
		// TODO Auto-generated method stub
		ScreeningPlan screeningPlan = screeningPlanDao.get(ScreeningPlan.class, id);
		return screeningPlan;
	}

}
