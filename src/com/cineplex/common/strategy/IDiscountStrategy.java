package com.cineplex.common.strategy;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:19:10  
*
 */
public interface IDiscountStrategy {
	/**
	 * 
	* get discounted money
	* @param money
	* @return
	* int  
	* @throws
	 */
	public int discount(int money);
}
