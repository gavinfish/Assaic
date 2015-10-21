package com.cineplex.common.factory;

import com.cineplex.common.strategy.IDiscountStrategy;
import com.cineplex.common.strategy.impl.DiscountBaseStrategy;
import com.cineplex.common.strategy.impl.DiscountOneStrategy;
import com.cineplex.common.strategy.impl.DiscountThreeStrategy;
import com.cineplex.common.strategy.impl.DiscountTwoStrategy;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:20:01  
*
 */
public class DiscountStrategyFactory {
	private DiscountStrategyFactory(){
		
	}
	
	/**
	 * 
	* get discount strategy by member card level
	* @param level
	* @return
	* IDiscountStrategy  
	* @throws
	 */
	public static IDiscountStrategy create(int level){
		switch (level) {
		case 0:
			return new DiscountBaseStrategy();
		case 1:
			return new DiscountOneStrategy();
		case 2:
			return new DiscountTwoStrategy();
		case 3:
			return new DiscountThreeStrategy();
		default:
			return null;
		}
	}
}
