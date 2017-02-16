package com.zte.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	/**
	 * 获取当前时间的标准格式
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	
	/**
	 * 将时间按照一定格式转化为字符串格式
	 * 
	 * @param date
	 * @param type
	 * @return
	 */
	public static String ConvertDateToString(Date date, String type) {
		String result = "";
		SimpleDateFormat format = new SimpleDateFormat(type);
		result = format.format(date);
		return result;
	}

	/**
	 * 将时间字符串按照一定格式转化为字符串格式
	 * 
	 * @param date
	 * @param type
	 * @return
	 * @throws ParseException
	 */
	public static String ConvertDateToString(String date, String type)
			throws ParseException {
		String result = "";
		SimpleDateFormat format = new SimpleDateFormat(type);
		DateFormat dateFormat = new SimpleDateFormat(type);
		result = format.format(dateFormat.parse(date));
		return result;
	}

	/**
	 * 将时间字符串按照一定格式转化为字符串格式
	 * 
	 * @param str
	 *            转化为时间的字符串
	 * @param type
	 *            转化为时间的格式
	 * @return
	 * @throws ParseException
	 */
	public static Date ConvertStringToDate(String str, String type)
			throws ParseException {
		DateFormat dd = new SimpleDateFormat(type);
		Date result = null;
		try {
			result = dd.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
