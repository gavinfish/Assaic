package com.cineplex.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:05:15  
*
 */
public class MyToString {
	private MyToString(){
		
	}
	
	/**
	 * 
	* format a bean information like "propertyName:value propertyName:value ..."
	* @param o
	* @return
	* String  
	* @throws
	 */
	public static String getString(Object o) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		StringBuilder sb = new StringBuilder();
		Field[] fields = o.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				sb.append(field.getName());
				sb.append(":");
				if (field.get(o) instanceof Date) {
					sb.append(simpleDateFormat.format(field.get(o)));
				} else {
					sb.append(field.get(o));
				}
				sb.append(" ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
