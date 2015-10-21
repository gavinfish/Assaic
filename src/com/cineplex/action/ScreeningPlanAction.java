package com.cineplex.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.Film;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.service.FilmService;
import com.cineplex.service.ScreeningPlanService;
import com.cineplex.service.WaiterService;
import com.cineplex.service.impl.ScreeningPlanServiceImpl;
import com.cineplex.util.BooleanMathUtil;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:31:20  
*
 */
@Controller
public class ScreeningPlanAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(ScreeningPlanAction.class);

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public static final int CAPACITY_OF_HALL = 60;

	@Resource
	private WaiterService waiterService;
	@Resource
	private FilmService filmService;
	@Resource
	private ScreeningPlanService screeningPlanService;

	private boolean hall1;
	private boolean hall2;
	private boolean hall3;
	private String filmSelected;

	private String startDate;
	private int lastDay;
	// private String endDate;
	private String startTime;
	private int price;

	private int planId;
	private String filmName;
	private List<ScreeningPlan> screeningPlans;
	private ScreeningPlan screeningPlan;
	private String comment;
	private boolean Agree;

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public boolean isHall1() {
		return hall1;
	}

	public void setHall1(boolean hall1) {
		this.hall1 = hall1;
	}

	public boolean isHall2() {
		return hall2;
	}

	public void setHall2(boolean hall2) {
		this.hall2 = hall2;
	}

	public boolean isHall3() {
		return hall3;
	}

	public void setHall3(boolean hall3) {
		this.hall3 = hall3;
	}

	public String getFilmSelected() {
		return filmSelected;
	}

	public void setFilmSelected(String filmSelected) {
		this.filmSelected = filmSelected;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getLastDay() {
		return lastDay;
	}

	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public List<ScreeningPlan> getScreeningPlans() {
		return screeningPlans;
	}

	public void setScreeningPlans(List<ScreeningPlan> screeningPlans) {
		this.screeningPlans = screeningPlans;
	}

	public ScreeningPlan getScreeningPlan() {
		return screeningPlan;
	}

	public void setScreeningPlan(ScreeningPlan screeningPlan) {
		this.screeningPlan = screeningPlan;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isAgree() {
		return Agree;
	}

	public void setAgree(boolean agree) {
		Agree = agree;
	}

	/**
	 * 
	* make a screening plan
	* @return
	* String  
	* @throws
	 */
	public String makePlan() {
		ScreeningPlan screeningPlanTemp = new ScreeningPlan();
		screeningPlanTemp.setEndDate(DateUtil.getDaysLater(
				DateUtil.getSQLDate(startDate), lastDay));
		Film film = filmService.getFilmByName(filmSelected);
		LOGGER.info("filmSelected:" + filmSelected);
		screeningPlanTemp.setFilmId(film.getId());
		screeningPlanTemp.setHall1(hall1);
		screeningPlanTemp.setHall2(hall2);
		screeningPlanTemp.setHall3(hall3);
		LOGGER.info("make plan start date: "+startDate);
		screeningPlanTemp.setPeriod1(DateUtil.getSQLTime(startTime));
		screeningPlanTemp.setPeriod2(null);
		screeningPlanTemp.setPeriod3(null);
		screeningPlanTemp.setPeriod4(null);
		screeningPlanTemp.setPrice(price);
		BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
		screeningPlanTemp.setSeat(booleanMathUtil.add(hall1, hall2, hall3)
				.getResult() * CAPACITY_OF_HALL);
		screeningPlanTemp.setStartDate(DateUtil.getSQLDate(startDate));
		screeningPlanTemp.setState(ScreeningPlanServiceImpl.PLAN_STATE_UNCHECKED);
		screeningPlanTemp.setComment(null);
		screeningPlanTemp.setFilmName(film.getName());

		film.setPrice(price);
		filmService.updateFilm(film);

		waiterService.makePlan(screeningPlanTemp);
		return SUCCESS;
	}

	/**
	 * 
	* get screening plan information
	* @return
	* String  
	* @throws
	 */
	public String getPlan() {
		screeningPlan = screeningPlanService.getPlanById(planId);
		lastDay = DateUtil.getGap(screeningPlan.getStartDate(),
				screeningPlan.getEndDate());
		startDate = DateUtil.transformFormat(screeningPlan.getStartDate()
				.toString());
		LOGGER.info("start date: " + startDate);
		if (session().get("account_type").equals(
				LoginAction.ACCOUNT_TYPE_MANAGER)) {
			return LoginAction.MANAGER_SUCCESS;
		} else if (session().get("account_type").equals(
				LoginAction.ACCOUNT_TYPE_WAITER)) {
			return LoginAction.WAITER_SUCCESS;
		} else {
			return LoginAction.MEMBER_SUCCESS;
		}
	}

	public String getUnckeckedPlan() {
		screeningPlans = screeningPlanService.getUncheckedPlan();
		return SUCCESS;
	}

	/**
	 * 
	* get all screening plans
	* @return
	* String  
	* @throws
	 */
	public String getAppliedPlan() {
		List<ScreeningPlan> passList = screeningPlanService.getPassedPlan();
		List<ScreeningPlan> unPassList = screeningPlanService.getUnpassedPlan();
		if (passList != null) {
			screeningPlans = passList;
			if (unPassList != null) {
				screeningPlans.addAll(unPassList);
			}
		} else {
			screeningPlans = unPassList;
		}
		return SUCCESS;
	}

	/**
	 * 
	* get screening plans which have been approved
	* @return
	* String  
	* @throws
	 */
	public String getPassedPlan() {
		screeningPlans = screeningPlanService.getPassedPlan();
		return SUCCESS;
	}

	/**
	 * 
	* get screening plans which have been rejected
	* @return
	* String  
	* @throws
	 */
	public String getUnpassedPlan() {
		screeningPlans = screeningPlanService.getUnpassedPlan();
		return SUCCESS;
	}

	/**
	 * 
	* reply a screening plan
	* @return
	* String  
	* @throws
	 */
	public String replyPlan() {
		LOGGER.info("film name: " + filmName + Agree);
		ScreeningPlan screeningPlanTemp = screeningPlanService.getPlanById(planId);
		screeningPlanTemp.setComment(comment);
		if (Agree) {
			screeningPlanTemp.setState(ScreeningPlanServiceImpl.PLAN_STATE_PASSED);
			filmService.addPreparedTicket(screeningPlanTemp.getFilmId(), getPlanTicketCount(screeningPlanTemp));
		} else {
			screeningPlanTemp
					.setState(ScreeningPlanServiceImpl.PLAN_STATE_UNPASSED);
		}

		screeningPlanService.repleyPlan(screeningPlanTemp);
		return SUCCESS;
	}
	
	/**
	 * 
	* get tickets count of a screening plan
	* @param screeningPlan
	* @return
	* int  
	* @throws
	 */
	private int getPlanTicketCount(ScreeningPlan screeningPlan){
		int gap = DateUtil.getGap(screeningPlan.getStartDate(), screeningPlan.getEndDate());
		BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
		int hallCount = booleanMathUtil.add(screeningPlan.isHall1(),screeningPlan.isHall2(),screeningPlan.isHall3()).getResult();
		int result = CAPACITY_OF_HALL*hallCount*gap;
		return result;
	}

	/**
	 * 
	* modify a screening plan
	* @return
	* String  
	* @throws
	 */
	public String modifyPlan() {
		ScreeningPlan screeningPlanTemp = screeningPlanService.getPlanById(planId);
		screeningPlanTemp.setEndDate(DateUtil.getDaysLater(
				DateUtil.getSQLDate(startDate), lastDay));
		Film film = filmService.getFilmByName(filmName);

		LOGGER.info("film name to modify plan: " + filmName);
		screeningPlanTemp.setHall1(hall1);
		screeningPlanTemp.setHall2(hall2);
		screeningPlanTemp.setHall3(hall3);
		screeningPlanTemp.setPeriod1(DateUtil.getSQLTime(startTime));
		screeningPlanTemp.setPrice(price);
		BooleanMathUtil booleanMathUtil = new BooleanMathUtil();
		screeningPlanTemp.setSeat(booleanMathUtil.add(hall1, hall2, hall3)
				.getResult() * CAPACITY_OF_HALL);
		screeningPlanTemp.setStartDate(DateUtil.getSQLDate(startDate));
		screeningPlanTemp.setState(ScreeningPlanServiceImpl.PLAN_STATE_UNCHECKED);

		film.setPrice(price);
		filmService.updateFilm(film);

		waiterService.modifyPlan(screeningPlanTemp);
		return SUCCESS;
	}
}
