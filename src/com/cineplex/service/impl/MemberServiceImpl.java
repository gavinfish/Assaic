package com.cineplex.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cineplex.dao.ActivityDao;
import com.cineplex.dao.ActivityRecordDao;
import com.cineplex.dao.BankCardDao;
import com.cineplex.dao.FeeRecordDao;
import com.cineplex.dao.MemberCardDao;
import com.cineplex.dao.MemberDao;
import com.cineplex.entity.Activity;
import com.cineplex.entity.ActivityRecord;
import com.cineplex.entity.BankCard;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.Member;
import com.cineplex.entity.MemberCard;
import com.cineplex.service.MemberService;
import com.cineplex.util.DateUtil;

/**
 * implements of service of member operation
* @author Andy 1993sj19993@gmail.com  
* @date 2015年3月4日 上午11:29:30  
*
 */

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	private static final Logger LOGGER = LogManager.getLogger(MemberServiceImpl.class);
	
	/**
	 * Dao of member
	 */
	@Resource
	private MemberDao memberDao;
	@Resource
	private BankCardDao bankCardDao;
	@Resource
	private MemberCardDao memberCardDao;
	@Resource
	private ActivityDao activityDao;
	@Resource
	private ActivityRecordDao activityRecordDao;
	@Resource
	private FeeRecordDao feeRecordDao;
	
	@Override
	public Member login(String accountName, String password) {
		Member member = memberDao.findMemberByAccountAndPswd(accountName,
				password);
		return member;
	}

	@Override
	public boolean register(Member member) {
		//register account for member
		int result =  (Integer) memberDao.save(member);
		LOGGER.info("member to register: "+member);
		String accountName = member.getAccountName();
		member = memberDao.findMemberByAccount(accountName);
		
		//register member card for member
		MemberCard memberCard = initMemberCard(member.getId(), member.getMemberCardId());
		memberCardDao.save(memberCard);
		
		//register bank card for member
		BankCard bankCard = initBankCard(member.getId(), member.getBankCardId());
		bankCardDao.save(bankCard);
		
		return result>=0;
	}

	private MemberCard initMemberCard(int memberId, int memberCarId){
		MemberCard memberCard = new MemberCard();
		memberCard.setCreateTime(DateUtil.getCurrentDate());
		memberCard.setId(memberCarId);
		memberCard.setIntegral(0);
		memberCard.setLevel(0);
		memberCard.setLive(MemberCardServiceImpl.MEMBER_CARD_STATE_DEAD);
		memberCard.setMemberId(memberId);
		memberCard.setMoney(0);
		memberCard.setSuspendTime(DateUtil.getYearLater());
		memberCard.setMoneyTotal(0);
		return memberCard;
	}
	
	private BankCard initBankCard(int memberId, long bankCardId){
		BankCard bankCard = new BankCard();
		bankCard.setId(bankCardId);
		bankCard.setMemberId(memberId);
		//assume every new member's bank account has 500 yuan
		bankCard.setMoney(500);
		return bankCard;
	}
	
	@Deprecated
	@Override
	public boolean recharge(long bankCardId, int money) {
		//check if there is bank account for the member
		BankCard bankCard = bankCardDao.get(BankCard.class, bankCardId);
		LOGGER.info("bankCardId:"+bankCardId);
		if(bankCard==null){
			return false;
		}
		
		//check if the
		int bankMoney = bankCard.getMoney();
		
		bankMoney += money;
		bankCard.setMoney(bankMoney);
		
		LOGGER.info("bankCard money:"+bankMoney);
		
		bankCardDao.update(bankCard);
		return true;
	}

	@Override
	public BankCard checkBankAccount(int id) {
		// TODO Auto-generated method stub
		BankCard bankCard = bankCardDao.findByMemberId(id);
		return bankCard;
	}

	@Override
	public List<Activity> getAvaibleActivities(int id) {
		// TODO Auto-generated method stub
//		//get all films watched
//		List<Integer> filmIds = ticketDao.getFilmIdsByMemberId(id);
//		//get all activities for these films
//		List<Activity> activities = new ArrayList<Activity>();
//		for(Integer filmId:filmIds){
//			activities.addAll(activityDao.getActivitiesByFilmId(filmId));
//		}
//		//check if there is active activities for these films
//		List<Integer> activityIdsAttended = activityRecordDao.getActivityIdsByMemberId(id);
		List<Integer> activityIds = activityRecordDao.getActiveIdsByMemberId(id);
		List<Activity> activities = new ArrayList<Activity>();
		for(Integer activityId:activityIds){
			Activity activity = activityDao.get(Activity.class, activityId);
			activities.add(activity);
		}
		return activities;
	}

	@Override
	public boolean buyTicketsByCard(int id, int money) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.get(MemberCard.class, id);
		if(memberCard.getMoney()<money){
			return false;
		}
		memberCard.setMoney(memberCard.getMoney()-money);
		memberCardDao.update(memberCard);
		return true;	
	}
	
	@Override
	public boolean buyTicketByIntegral(int id, int money) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.findByMemberId(id);
		int integral = memberCard.getIntegral();
		int integralPerMoney = 20;
		if(money*integralPerMoney>integral){
			return false;
		}
		else{
			memberCard.setIntegral(integral-money*integralPerMoney);
			memberCardDao.update(memberCard);
			return true;
		}
	}

	@Override
	public void attendActivity(int id, int activityId, int answer) {
		// TODO Auto-generated method stub
		ActivityRecord activityRecord = activityRecordDao.getByMemberIdAndActivityId(id, activityId);
		LOGGER.info("member id: "+id+" | activity id: "+activityId);
		activityRecord.setAnswer(answer);
		activityRecord.setDate(DateUtil.getCurrentDate());
		activityRecord.setHasAttend(true);
		activityRecordDao.update(activityRecord);
	}

	@Override
	public Activity getActivityById(int activityId) {
		// TODO Auto-generated method stub
		Activity activity = activityDao.get(Activity.class, activityId);
		return activity;
	}


	@Override
	public List<FeeRecord> getConsumption(int id) {
		// TODO Auto-generated method stub
		List<FeeRecord> feeRecords = feeRecordDao.getComsuptionRecord(id);
		return feeRecords;
	}

	@Override
	public List<FeeRecord> getRecharge(int id) {
		// TODO Auto-generated method stub
		List<FeeRecord> feeRecords = feeRecordDao.getRechargeRecord(id);
		return feeRecords;
	}


}
