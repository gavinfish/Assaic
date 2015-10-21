package com.cineplex.common.strategy;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:17:59  
*
 */
public interface ILevelStrategy {
	/**
	 * 
	* get money discounted by member level
	* @param moneyTotal
	* @return
	* int  
	* @throws
	 */
	public int getLevel(int moneyTotal);
}
