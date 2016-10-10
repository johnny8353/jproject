package com.johnny.ui.baisc.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/**
 * 内容摘要：主应用常量
 * 完成日期：Jul 14, 2016
 * 编码作者：JohnnyHunag
 */
public class AppConstants {
	/**
	 * 主应用配置
	 */
	public static String APP_VERSION = "DefaultVersion";//应用版本
	public static String APP_CONFIG_FILE = "applicationConfig.properties";//应用配置文件名
	public static Locale APP_LOCALE = new Locale("zh", "CN");//默认语言
	public static String APP_ENCODING = "UTF-8";//默认编码
	public static String APP_DECIMAL_FORMATE = "0.##"; //默认数字
	public static String APP_DATE_FORMATE = "yyyy-MM-dd"; //默认日期格式
	public static String APP_DATETIME_FORMATE = "yyyy-MM-dd HH:mm:ss";//默认时间格式
	
	/**
	 * 主程序配置Key值 
	 */
	public final static String KEY_VERSION = "application.version";//主程序版本
	public final static String KEY_LOCALE = "application.locale";//主程序语言
	public final static String KEY_ENCODING ="application.encoding";//主程序编码
	public final static String KEY_DECIMAL_FORMATE = "application.decimalformat"; //主程序日期格式
	public final static String KEY_DATE_FORMATE = "application.dateformat"; //主程序日期格式
	public final static String KEY_DATETIME_FORMATE = "application.datetimeformat";//主程序时间格式
	
	/**
	 * 格式化类
	 */
	//主程序数字格式器
	public static DecimalFormat decimalFormatter = new DecimalFormat(AppConstants.APP_DECIMAL_FORMATE);
	//主程序日期格式器
	public static SimpleDateFormat dateFormatter = new SimpleDateFormat(AppConstants.APP_DATE_FORMATE);
	//主程序时间格式器
	public static SimpleDateFormat datetimeFormatter = new SimpleDateFormat(AppConstants.APP_DATETIME_FORMATE);
	
}
