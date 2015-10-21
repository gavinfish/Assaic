package com.cineplex.common.strategy.impl;

import com.cineplex.common.strategy.IDiscountStrategy;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:19:51  
*
 */
public class DiscountTwoStrategy implements IDiscountStrategy{
	private final static double DISCOUNT_STANDARD = 0.8;

	@Override
	public int discount(int money) {
		// TODO Auto-generated method stub
		int result = (int) (money*DISCOUNT_STANDARD);
		return result;
	}
	
}
