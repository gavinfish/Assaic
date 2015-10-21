package com.cineplex.util;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午3:56:18  
*
 */
public class BinaryUtil {
	private BinaryUtil(){
		
	}
	
	/**
	 * 
	* change from long to char array
	* @param seat
	* @param length
	* @return char[]:  
	* @throws
	 */
	public static char[] longToCharArray(long seat, int length) {
		String seatString = Long.toBinaryString(seat);
		int longLength = seatString.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length - longLength; i++) {
			sb.append('0');
		}
		sb.append(seatString);
		return sb.toString().toCharArray();
	}

	/**
	 * 
	* change from char array to long
	* @param bi
	* @return long  
	* @throws
	 */
	public static long charArrayToLong(char[] bi) {
		long len = bi.length;
		long sum = 0;
		long tmp, max = len - 1;
		for (int i = 0; i < len; ++i) {
			tmp = bi[i] - '0';
			sum += tmp * Math.pow(2, max--);
		}
		return sum;
	}

}
