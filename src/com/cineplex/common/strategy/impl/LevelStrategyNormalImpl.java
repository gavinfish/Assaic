package com.cineplex.common.strategy.impl;

import com.cineplex.common.strategy.ILevelStrategy;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:18:40  
*
 */
public class LevelStrategyNormalImpl implements ILevelStrategy{
	public static final int MEMBER_CARD_LEVEL_BASE = 0;
	public static final int MEMBER_CARD_LEVEL_ONE = 1;
	public static final int MEMBER_CARD_LEVEL_TWO = 2;
	public static final int MEMBER_CARD_LEVEL_THREE = 3;
	
	@Override
	public int getLevel(int moneyTotal) {
		// TODO Auto-generated method stub
		if(moneyTotal<200){
			return MEMBER_CARD_LEVEL_BASE;
		}
		else if(moneyTotal<1000){
			return MEMBER_CARD_LEVEL_ONE;
		}
		else if (moneyTotal<3000) {
			return MEMBER_CARD_LEVEL_TWO;
		}
		else{
			return MEMBER_CARD_LEVEL_THREE;
		}
	}

}
