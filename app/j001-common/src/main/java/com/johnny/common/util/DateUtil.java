package com.johnny.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 类 编 号：
 * 类 名 称：
 * 内容摘要：XXX 
 * 完成日期：2015-12-29
 * 编码作者：JohnnyHuang
 */
public abstract class DateUtil {
	//hh表示的是12小时制，HH才是24小时制
	private static final String completeDateFormat = "yyyy-MM-dd HH:mm:ss";
	private static final String completeMMMDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String partDateFormat = "yyyy-MM-dd";

	public static String timeToString(long msUsed) {
		if (msUsed < 0L) {
			return String.valueOf(msUsed);
		}
		if (msUsed < 1000L) {
			return String.valueOf(msUsed) + "毫秒";
		}

		msUsed /= 1000L;
		if (msUsed < 60L) {
			return String.valueOf(msUsed) + "秒";
		}
		if (msUsed < 3600L) {
			long nMinute = msUsed / 60L;
			long nSecond = msUsed % 60L;
			return String.valueOf(nMinute) + "分" + String.valueOf(nSecond)
					+ "秒";
		}

		if (msUsed < 86400L) {
			long nHour = msUsed / 3600L;
			long nMinute = (msUsed - nHour * 3600L) / 60L;
			long nSecond = (msUsed - nHour * 3600L) % 60L;
			return String.valueOf(nHour) + "小时" + String.valueOf(nMinute) + "分"
					+ String.valueOf(nSecond) + "秒";
		}

		long nDay = msUsed / 86400L;
		long nHour = (msUsed - nDay * 86400L) / 3600L;
		long nMinute = (msUsed - nDay * 86400L - nHour * 3600L) / 60L;
		long nSecond = (msUsed - nDay * 86400L - nHour * 3600L) % 60L;
		return String.valueOf(nDay) + "天" + String.valueOf(nHour) + "小时"
				+ String.valueOf(nMinute) + "分" + String.valueOf(nSecond) + "秒";
	}

	public static Calendar getThisMonday() {
		return getThatMonday(Calendar.getInstance());
	}

	public static Calendar getThatMonday(Calendar cal) {
		int n = cal.get(7) - 2;
		cal.add(5, n);
		return cal;
	}

	public static Calendar getThisSunday() {
		return getThatSunday(Calendar.getInstance());
	}

	public static Calendar getThatSunday(Calendar cal) {
		int n = 8 - cal.get(7);
		cal.add(5, n);
		return cal;
	}

	public static int minus(Calendar cal1, Calendar cal2) {
		if (cal1.after(cal2)) {
			int nBase = (cal1.get(1) - cal2.get(1)) * 365;
			return nBase + cal1.get(6) - cal2.get(6);
		}

		return minus(cal2, cal1);
	}

	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		return cal;
	}

	public static Date stringToDate(String dateString, String dateFormat) {
		if (("".equals(dateString)) || (dateString == null)) {
			return null;
		}
		try {
			return new SimpleDateFormat(dateFormat).parse(dateString);
		} catch (Exception e) {
		}
		return null;
	}

	public static Date stringToDate(String dateString) {
		if (("".equals(dateString)) || (dateString == null)) {
			return null;
		}
		try {
			boolean isStandardDate = isStandardDate(dateString);
			String dateFormat = "yyyy-MM-dd HH:mm:ss";
			boolean isYmdFormatDate = isYmdFormatDate(dateString);
			if ((isStandardDate) && (isYmdFormatDate)) {
				dateFormat = "yyyy-MM-dd";
			} else if (!isStandardDate) {
				return new SimpleDateFormat(dateFormat).parse(dateString);
			}
			return new SimpleDateFormat(dateFormat).parse(dateString);
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean isYmdFormatDate(String date) {
		String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		return m.matches();
	}

	public static boolean isStandardDate(String date) {
		if (null == date) {
			return false;
		}

		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		return m.matches();
	}

	public static Calendar getCalendar(Calendar cal, int relativeDay) {
		cal.add(5, relativeDay);
		return cal;
	}

	public static Date getDate(int relativeDay) {
		return getCalendar(Calendar.getInstance(), relativeDay).getTime();
	}

	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			return new SimpleDateFormat(pattern).format(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean isDateClose(Date date, Date baseDate, int seconds) {
		long m_time = date.getTime();
		long b_time = baseDate.getTime();
		long ms = seconds * 1000L;

		if (m_time == b_time) {
			return true;
		}
		if (m_time > b_time) {
			return b_time + ms > m_time;
		}
		if (m_time < b_time) {
			return m_time + ms > b_time;
		}

		return true;
	}

	public static Object getFormatDateObj(Object fieldValue) {
		Object ret = null;
		try {
			if ((fieldValue instanceof String)) {
				String format = "yyyy-MM-dd HH:mm:ss";
				if (isYmdFormatDate((String) fieldValue)) {
					format = "yyyy-MM-dd";
				}
				ret = new SimpleDateFormat(format)
						.parseObject((String) fieldValue);
			} else if ((fieldValue instanceof Date)) {
				String format = "yyyy-MM-dd HH:mm:ss";
				String time = dateToString((Date) fieldValue, format);
				if (isYmdFormatDate(time)) {
					format = "yyyy-MM-dd";
				}
				ret = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parseObject(time);
			} else {
				ret = fieldValue;
			}
		} catch (ParseException e1) {
			ret = fieldValue;
		}
		return ret;
	}

	public static String dateToString(Date date) {
		return dateToString(date, completeDateFormat);
	}
	/**
	* 业务描述：返回当前时间 精确到毫秒
	* 作    者：Johnny Huang
	* 完成日期：2015-12-29 	下午05:29:43
	* @return String
	*/
	public static String getNowDateTimeMMM() {
		return dateToString(new Date(), completeMMMDateFormat);
	}
	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 * @return
	 */
	public static String getNowDateTimeStr() {
		return dateToString(new Date(), "yyyyMMddHHmmssSSS");
	}
	public static String dateToStringMMM(Date date) {
		return dateToString(date, completeMMMDateFormat);
	}
	
	public static String getNowDateTime() {
		return dateToString(new Date(), completeDateFormat);
	}
	
	public static String getNowDate() {
		return dateToString(new Date(), partDateFormat);
	}
	
	
	/**
	* 业务描述：获取 两个时间相差 秒数.毫秒数
	* 作    者：Johnny Huang
	* 完成日期：2015-12-29 	下午05:29:43
	* @param @param date1
	* @param @param date2
	* @param date2>date1
	* @return String
	*/
	public static String getDiffDate(String date1,String date2){
		if(date1==null||date2==null){
			return "";
		}
		SimpleDateFormat dfs = new SimpleDateFormat(completeMMMDateFormat);
	    java.util.Date begin = null;
	    java.util.Date end = null;
		try {
			begin = dfs.parse(date1);
			end = dfs.parse(date2);;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
		long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);
        if(ms<10) return s+".00"+ms;
        if(ms<100) return s+".0"+ms;
		return s+"."+ms;
	}
	
	/**
	* 业务描述：获取 两个时间相差 秒数.毫秒数
	* 作    者：Johnny Huang
	* 完成日期：2015-12-29 	下午05:29:43
	* @param @param date1
	* @param @param date2
	* @param date2>date1
	* @return String
	*/
	public static String getDiffDate(Date date1,Date date2){
		return getDiffDate(dateToStringMMM(date1),dateToStringMMM(date2));
	}
}