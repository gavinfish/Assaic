package com.cineplex.util;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:58:06  
*
 */
public class BooleanMathUtil {
	private int result;

	/**
	 * construct
	* <p>Title: </p>  
	* <p>Description: </p>
	 */
	public BooleanMathUtil() {

	}
	
	/**
	 * 
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @param result
	 */
	private BooleanMathUtil(int result) {
		this.result = result;
	}

	/**
	 * 
	* add two boolean
	* @param bool1
	* @param bool2
	* @return BooleanMathUtil  
	* @throws
	 */
	public BooleanMathUtil add(boolean bool1, boolean bool2) {
		result = bool1 == true ? result + 1 : result;
		result = bool2 == true ? result + 1 : result;
		return new BooleanMathUtil(result);
	}

	/**
	 * 
	* add several boolean
	* @param bool1
	* @param bool2
	* @param bools
	* @return
	* BooleanMathUtil  
	* @throws
	 */
	public BooleanMathUtil add(boolean bool1, boolean bool2, boolean... bools) {
		result = bool1 == true ? result + 1 : result;
		result = bool2 == true ? result + 1 : result;
		for (boolean bool : bools) {
			result = bool == true ? result + 1 : result;
		}
		return new BooleanMathUtil(result);
	}

	/**
	 * 
	* add a boolean
	* @param bool
	* @return
	* BooleanMathUtil  
	* @throws
	 */
	public BooleanMathUtil add(boolean bool) {
		result = bool == true ? result + 1 : result;
		return new BooleanMathUtil(result);
	}

	/**
	 * 
	* get result of calculation
	* @return
	* int  
	* @throws
	 */
	public int getResult() {
		int temp = result;
		result = 0;
		return temp;
	}

}
