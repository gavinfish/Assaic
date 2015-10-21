package com.cineplex.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cineplex.common.factory.DiscountStrategyFactory;
import com.cineplex.common.strategy.IDiscountStrategy;
import com.cineplex.common.strategy.ILevelStrategy;
import com.cineplex.common.strategy.impl.LevelStrategyNormalImpl;
import com.cineplex.dao.BankCardDao;
import com.cineplex.dao.FeeRecordDao;
import com.cineplex.dao.MemberCardDao;
import com.cineplex.entity.BankCard;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.MemberCard;
import com.cineplex.service.MemberCardService;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:55:46  
*
 */
@Service("memberCardService")
public class MemberCardServiceImpl implements MemberCardService {
	private static final Logger LOGGER = LogManager
			.getLogger(MemberCardServiceImpl.class);

	@Resource
	private BankCardDao bankCardDao;
	@Resource
	private MemberCardDao memberCardDao;
	@Resource
	private FeeRecordDao feeRecordDao;
	
	public static final int ACTIVATE_REQUEST_MONEY = 200;
	public static final int ACTIVE_REQUEST_MONEY = 200;
	public static final char MEMBER_CARD_STATE_ALIVE = '1';
	public static final char MEMBER_CARD_STATE_SUSPEND = '2';
	public static final char MEMBER_CARD_STATE_DEAD = '0';
	public static final char MEMBER_CARD_STATE_DISACTIVE = '3';
	public static final char FEE_RECORD_TYPE_CASH = '0';
	public static final char FEE_RECORD_TYPE_CARD = '1';
	public static final char FEE_RECORD_TYPE_INTEGRAL = '2';
	public static final char FEE_RECORD_TYPE_CASH_CARD = '4';
	public static final char FEE_RECORD_TYPE_RECHARGE = '3';

	@Override
	public boolean rechargeByBank(int memberCardId, long bankCardId, int money) {
		// check if there is bank account for the member
		BankCard bankCard = bankCardDao.get(BankCard.class, bankCardId);
		LOGGER.info("bankCardId:" + bankCardId);
		if (bankCard == null) {
			return false;
		}

		// check if the money if enough
		int bankMoney = bankCard.getMoney();
		if(bankMoney>=money){
			bankCard.setMoney(bankMoney-money);
		}
		else{
			return false;
		}
		
		//add money in member card
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		if(memberCard==null){
			return false;
		}
		int memberMoney = memberCard.getMoney();
		memberCard.setMoney(memberMoney+money);
		memberCard.setMoneyTotal(memberCard.getMoneyTotal()+money);

		memberCard = activateCard(memberCard, money);
		
		//save change
		bankCardDao.update(bankCard);
		memberCardDao.update(memberCard);
		
		//update member card level
		updateLevel(memberCardId);
		
		//add a fee record
		FeeRecord feeRecord = new FeeRecord();
		feeRecord.setMemberId(memberCard.getMemberId());
		feeRecord.setMoney(money);
		feeRecord.setTime(DateUtil.getCurrentDate());
		feeRecord.setType(FEE_RECORD_TYPE_RECHARGE);
		feeRecordDao.save(feeRecord);
		return true;
	}
	
	/**
	 * 
	* @Title: activateCard  
	* @Description: TODO recharge money into member card can change live condition of the card
	* @param @param memberCard
	* @param @param money
	* @return MemberCard:  
	* @throws
	 */
	private MemberCard activateCard(MemberCard memberCard, int money){
		if(money>=ACTIVATE_REQUEST_MONEY){
			memberCard.setLive(MEMBER_CARD_STATE_ALIVE);
			memberCard.setSuspendTime(DateUtil.getYearLater());
		}
		else if(money>0){
			char live = (char) getActiveState(memberCard.getId());
			if('2'==live){
				memberCard.setLive(MEMBER_CARD_STATE_ALIVE);
				memberCard.setSuspendTime(DateUtil.getYearLater());
			}
		}
		
		return memberCard;
	}

	private void updateLevel(int memberCardId){
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		int totalMoney = memberCard.getMoneyTotal();
		//strategy pattern
		ILevelStrategy levelStrategy = new LevelStrategyNormalImpl();
		int level = levelStrategy.getLevel(totalMoney);
		memberCard.setLevel(level);
		memberCardDao.update(memberCard);
	}
	
	@Override
	public MemberCard getMemberCardByMemberId(int id) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.findByMemberId(id);
		return memberCard;
	}

	@Override
	public void disQualificate(int memberCardId) {
		// TODO Auto-generated method stub
		LOGGER.info("member card id: "+memberCardId);
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		memberCard.setLive(MEMBER_CARD_STATE_DISACTIVE);
		memberCardDao.update(memberCard);
	}

	@Override
	public int getLevel(int memberCardId) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		int level = memberCard.getLevel();
		return level;
	}

	@Override
	public int discount(int memberCardId, int money) {
		// TODO Auto-generated method stub
		//check if the card is active
		int state = getActiveState(memberCardId);
		LOGGER.info("state member card: "+state);
		if (state==0||state==3) {
			return money;
		}
		
		int level = getLevel(memberCardId);
		IDiscountStrategy discountStrategy = DiscountStrategyFactory.create(level);
		int result = discountStrategy.discount(money);
		return result;
	}

	@Override
	public int getActiveState(int memberCardId) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		if (memberCard.getLive()==MEMBER_CARD_STATE_DISACTIVE) {
			return 3;
		}
		int moneyIn = memberCard.getMoney();
		//if money remaining in the member card account is more than 100, the card is always active
		if(moneyIn>=ACTIVE_REQUEST_MONEY){
			return 1;
		}
		
		Date susupenDate = memberCard.getSuspendTime();
		Date currentDate = DateUtil.getCurrentDate();
		if (DateUtil.getYearLater(susupenDate).before(currentDate)) {
			//disactivate the member card
			memberCard.setLive(MEMBER_CARD_STATE_DEAD);
		}
		else if(susupenDate.before(currentDate)){
			memberCard.setLive(MEMBER_CARD_STATE_SUSPEND);
		}
		memberCardDao.update(memberCard);
		return memberCard.getLive();
	}

	@Deprecated
	@Override
	public boolean buyTicketByIntegral(int memberCardId, int money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addIntegral(int memberCardId, int money) {
		// TODO Auto-generated method stub
		MemberCard memberCard = memberCardDao.get(MemberCard.class, memberCardId);
		memberCard.setIntegral(memberCard.getIntegral()+money);
		memberCardDao.update(memberCard);
	}

	@Override
	public List<FeeRecord> getComsuptionRecord(int memberCardId) {
		// TODO Auto-generated method stub
		
		return new ArrayList<FeeRecord>();
	}

	@Override
	public List<FeeRecord> getRechargeRecord(int memberCardId) {
		// TODO Auto-generated method stub
		return new ArrayList<FeeRecord>();
	}

	@Override
	public int getCountByState(char state) {
		// TODO Auto-generated method stub
		int count = memberCardDao.getCountByState(state);
		return count;
	}
	

}
