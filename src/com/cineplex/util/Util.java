package com.cineplex.util;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * 
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月25日 下午7:42:31
 *
 */

public class Util {
	private Util(){
		
	}
	
	/**
	 * encrypt string with MD5
	 * @param str: the string needs to be encrypted
	 * @return String: encrypted string
	 * @throws
	 */
	public static String md5Encryption(String str) {
		byte[] newStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			Encoder base = Base64.getEncoder();
			newStr = base.encode(md5.digest(str.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newStr.toString();
	}

	/**
	 * isNull check if a string is null or empty
	 * @paramstr: the string needs to be checked
	 * @return boolean: yes or no
	 * @throws
	 */
	public static boolean isNull(String str) {
		return str == null ||"".equals(str.trim());
	}
}
