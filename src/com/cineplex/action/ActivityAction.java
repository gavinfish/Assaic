package com.cineplex.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.Activity;
import com.cineplex.entity.Film;
import com.cineplex.entity.ScreeningPlan;
import com.cineplex.service.FilmService;
import com.cineplex.service.MemberService;
import com.cineplex.service.ScreeningPlanService;
import com.cineplex.service.WaiterService;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:20:40  
*
 */
@Controller
public class ActivityAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(ActivityAction.class);

	@Resource
	private FilmService filmService;
	@Resource
	private ScreeningPlanService screeningPlanService;
	@Resource
	private WaiterService waiterService;
	@Resource
	private MemberService memberService;

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String activityName;
	private String filmName;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private int filmId;
	private int integral;

	private String screeningPlanId;

	private Activity activity;
	private int activityId;

	private List<ScreeningPlan> screeningPlans;

	private List<Activity> activities;

	private int answerSelected;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getScreeningPlanId() {
		return screeningPlanId;
	}

	public void setScreeningPlanId(String screeningPlanId) {
		this.screeningPlanId = screeningPlanId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public List<ScreeningPlan> getScreeningPlans() {
		return screeningPlans;
	}

	public void setScreeningPlans(List<ScreeningPlan> screeningPlans) {
		this.screeningPlans = screeningPlans;
	}


	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getAnswerSelected() {
		return answerSelected;
	}

	public void setAnswerSelected(int answerSelected) {
		this.answerSelected = answerSelected;
	}

	/**
	 * 
	* make an activity
	* @return
	* String  
	* @throws
	 */
	public String makeActivity() {

		Film film = filmService.getFilmByName(filmName);
		filmId = film.getId();
		screeningPlans = screeningPlanService.getPlansByFilmName(filmName);
		return SUCCESS;
	}

	/**
	 * 
	* choose related screening plans for an activity
	* @return
	* String  
	* @throws
	 */
	public String choosePlan() {
		List<Integer> ids = getPlanIds(screeningPlanId);
		Activity activityWanted = new Activity();

		activityWanted.setFilmId(filmId);
		activityWanted.setName(activityName);
		activityWanted.setQuestion1(question);
		activityWanted.setOptions1(answer1);
		activityWanted.setOptions2(answer2);
		activityWanted.setOptions3(answer3);
		LOGGER.info("integral: "+integral);
		activityWanted.setIntegral(integral);
		activityWanted.setFilmName(filmName);
		activityWanted.setOver(0);
		activityWanted.setScreeningPlanId(screeningPlanId);
		LOGGER.info("screening plans selected id: " + screeningPlanId);

		Date startDate = DateUtil.getCurrentDate();
		Date endDate = DateUtil.getCurrentDate();
		for (Integer id : ids) {
			ScreeningPlan screeningPlan = screeningPlanService.getPlanById(id);
			Date planStart = screeningPlan.getStartDate();
			Date planEnd = screeningPlan.getEndDate();
			startDate = startDate.before(planStart) ? planStart : startDate;
			endDate = endDate.before(planEnd) ? planEnd : endDate;
		}
		activityWanted.setStartDate(startDate);
		activityWanted.setEndDate(endDate);

		LOGGER.info("activity to insert: " + activityWanted.toString());
		waiterService.makeActivity(activityWanted);
		return SUCCESS;
	}

	/**
	 * 
	* transform from format "id,id,id..." to list
	* @param ids
	* @return
	* List<Integer>  
	* @throws
	 */
	private List<Integer> getPlanIds(String ids) {
		String[] idStrings = ids.split(",");
		List<Integer> idArrayList = new ArrayList<Integer>();
		for (String idsString : idStrings) {
			idArrayList.add(Integer.parseInt(idsString.trim()));
		}
		return idArrayList;
	}

	/**
	 * 
	* get all activities
	* @return
	* String  
	* @throws
	 */
	public String getAllActivities() {
		int id = (Integer) session().get("id");
		activities = memberService.getAvaibleActivities(id);
		return SUCCESS;
	}

	/**
	 * 
	* get activity by activity id, check if there is the activity 
	* @return
	* String  
	* @throws
	 */
	public String checkActivity() {
		activity = memberService.getActivityById(activityId);
		LOGGER.info("activity: " + activity);
		return SUCCESS;
	}

	/**
	 * 
	* for a member attend an activity
	* @return
	* String  
	* @throws
	 */
	public String attendActivity() {
		int id = (Integer) session().get("id");
		memberService.attendActivity(id, activityId, answerSelected);
		return SUCCESS;
	}
}
