package com.cineplex.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cineplex.common.enums.Address;
import com.cineplex.common.enums.Gender;
import com.cineplex.service.ManagerService;
import com.cineplex.service.MemberManageService;
import com.cineplex.service.impl.MemberManageServiceImpl;

/**
 * s
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:34:04  
*
 */
public class StatisticAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(StatisticAction.class);

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private MemberManageService memberManageService;
	@Resource
	private ManagerService managerService;

	private Map<String, Integer> ageDistribution;
	private Map<String, Integer> homeDistribution;
	private Map<String, Integer> genderDistribution;
	private Map<String, Integer> activityCondition;
	private Map<String, Integer> memberCardCondition;

	private int[] dayPeople;
	private int[] monthPeople;
	private Map<String, double[]> hallAttendance;
	private Map<String, Double> filmAttendance;
	private int[] ticketCount;
	private long[] ticketMoney;
	
	private int[] people;
	private double[] hall1;
	private double[] hall2;
	private double[] hall3;
	private int year;
	private int month;
	

	public Map<String, Integer> getAgeDistribution() {
		return ageDistribution;
	}

	public void setAgeDistribution(Map<String, Integer> ageDistribution) {
		this.ageDistribution = ageDistribution;
	}

	public Map<String, Integer> getHomeDistribution() {
		return homeDistribution;
	}

	public void setHomeDistribution(Map<String, Integer> homeDistribution) {
		this.homeDistribution = homeDistribution;
	}

	public Map<String, Integer> getActivityCondition() {
		return activityCondition;
	}

	public void setActivityCondition(Map<String, Integer> activityCondition) {
		this.activityCondition = activityCondition;
	}

	public Map<String, Integer> getMemberCardCondition() {
		return memberCardCondition;
	}

	public void setMemberCardCondition(Map<String, Integer> memberCardCondition) {
		this.memberCardCondition = memberCardCondition;
	}

	public int[] getDayPeople() {
		return dayPeople;
	}

	public void setDayPeople(int[] dayPeople) {
		this.dayPeople = dayPeople;
	}

	public int[] getMonthPeople() {
		return monthPeople;
	}

	public void setMonthPeople(int[] monthPeople) {
		this.monthPeople = monthPeople;
	}

	public Map<String, double[]> getHallAttendance() {
		return hallAttendance;
	}

	public void setHallAttendance(Map<String, double[]> hallAttendance) {
		this.hallAttendance = hallAttendance;
	}

	public Map<String, Double> getFilmAttendance() {
		return filmAttendance;
	}

	public void setFilmAttendance(Map<String, Double> filmAttendance) {
		this.filmAttendance = filmAttendance;
	}

	public int[] getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int[] ticketCount) {
		this.ticketCount = ticketCount;
	}

	public long[] getTicketMoney() {
		return ticketMoney;
	}

	public void setTicketMoney(long[] ticketMoney) {
		this.ticketMoney = ticketMoney;
	}

	public Map<String, Integer> getGenderDistribution() {
		return genderDistribution;
	}

	public void setGenderDistribution(Map<String, Integer> genderDistribution) {
		this.genderDistribution = genderDistribution;
	}

	public int[] getPeople() {
		return people;
	}

	public void setPeople(int[] people) {
		this.people = people;
	}

	
	public double[] getHall1() {
		return hall1;
	}

	public void setHall1(double[] hall1) {
		this.hall1 = hall1;
	}

	public double[] getHall2() {
		return hall2;
	}

	public void setHall2(double[] hall2) {
		this.hall2 = hall2;
	}

	public double[] getHall3() {
		return hall3;
	}

	public void setHall3(double[] hall3) {
		this.hall3 = hall3;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 
	* get basic information of members
	* @return
	* String  
	* @throws
	 */
	public String idle() {
		homeDistribution = new HashMap<String, Integer>();
		for (Address address : Address.values()) {
			homeDistribution.put(address.toString(),
					memberManageService.getCountByAddress(address));
		}
		genderDistribution = new HashMap<String, Integer>();
		for (Gender gender : Gender.values()) {
			genderDistribution.put(gender.toString(),
					memberManageService.getCountByType(gender));
		}
		ageDistribution = new HashMap<String, Integer>();
		int ageTypeCount = MemberManageServiceImpl.AGE_LIST.length - 1;
		for (int i = 0; i < ageTypeCount; i++) {
			ageDistribution.put(MemberManageServiceImpl.AGE_LIST[i + 1] + "",
					memberManageService.getCountByAge(
							MemberManageServiceImpl.AGE_LIST[i],
							MemberManageServiceImpl.AGE_LIST[i + 1]));
		}
		return SUCCESS;
	}

	/**
	 * 
	* get activity statistic
	* @return
	* String  
	* @throws
	 */
	public String getActivityStatistic() {
		activityCondition = managerService.getActivityStatistic();
		LOGGER.info("actvity statistic count: " + activityCondition.size());
		return SUCCESS;
	}

	/**
	 * 
	* get member card statistic
	* @return
	* String  
	* @throws
	 */
	public String getMemberCardStatistic() {
		memberCardCondition = managerService.getMemberCardStatistic();
		LOGGER.info("member card statistic count: "
				+ memberCardCondition.size());
		return SUCCESS;
	}

	/**
	 * 
	* get people who buy tickets statistic
	* @return
	* String  
	* @throws
	 */
	public String getPeopleStatistic() {
		dayPeople = managerService.getDayPeople();
		monthPeople = managerService.getMonthPeople();
		return SUCCESS;
	}

	/**
	 * 
	* get statistic of hall attendance
	* @return
	* String  
	* @throws
	 */
	public String getHallAttendanceStatistic() {
		hallAttendance = managerService.getHallAttendance();
		return SUCCESS;
	}

	/**
	 * 
	* get statistic of film attendance
	* @return
	* String  
	* @throws
	 */
	public String getFilmAttendanceStatistic() {
		filmAttendance = managerService.getFilmAttendance();
		return SUCCESS;
	}

	/**
	 * 
	* get money statistic
	* @return
	* String  
	* @throws
	 */
	public String getMoneyStatistic() {
		ticketCount = managerService.getTicketCount();
		ticketMoney = managerService.getTicketMoney();
		return SUCCESS;
	}
	
	/**
	 * 
	* get people in a month statistic
	* @return
	* String  
	* @throws
	 */
	public String getMonthPeopleStatistic(){
		people = managerService.getMonthPeopleStatistic(year, month);
		LOGGER.info("month people:"+people[11]+" "+people[12]+" "+people[13]);
		return SUCCESS;
	}
	
	/**
	 * 
	* get hall attendance in a month statistic
	* @return
	* String  
	* @throws
	 */
	public String getMonthHallStatistic(){
		Map<String, double[]> hallsMap = managerService.getMonthHallStatistic(year, month);
		hall1 = hallsMap.get("一号影厅");
		hall2 = hallsMap.get("二号影厅");
		hall3 = hallsMap.get("三号影厅");
		return SUCCESS;
	}
	
	/**
	 * 
	* get money in a month statistic
	* @return
	* String  
	* @throws
	 */
	public String getMonthMoneyStatistic(){
		return SUCCESS;
	}
}
