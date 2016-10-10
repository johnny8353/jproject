package com.johnny.javaweb.i18n;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：I18NTest
 * 内容摘要：编程实现固定文本的国际化
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
public class I18NTest extends TestCase {
	@Test
	public void testResourceBundle() {
		// 资源包基名(包名+myproperties)
		String basename = "com.johnny.javaweb.i18n.resource.myproperties";
		// 设置语言环境
		Locale cn = Locale.CHINA;// 中文
		Locale us = Locale.US;// 英文
		Locale fr = Locale.CANADA_FRENCH;// 法
		// 根据基名和语言环境加载对应的语言资源文件
		ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename, cn);// 加载myproperties_zh.properties
		ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename, us);// 加载myproperties_en.properties
		ResourceBundle myResourcesFR = ResourceBundle.getBundle(basename, fr);// 加载myproperties.properties

		// 加载资源文件后， 程序就可以调用ResourceBundle实例对象的 getString方法获取指定的资源信息名称所对应的值。
		// String value = myResources.getString(“key");
		String usernameCN = myResourcesCN.getString("username");
		String passwordCN = myResourcesCN.getString("password");

		String usernameUS = myResourcesUS.getString("username");
		String passwordUS = myResourcesUS.getString("password");

		String usernameFR = myResourcesFR.getString("username");
		String passwordFR = myResourcesFR.getString("password");

		System.out.println(usernameCN + "--" + passwordCN);
		System.out.println(usernameUS + "--" + passwordUS);
		System.out.println(usernameFR + "--" + passwordFR);
	}

	/**
	 * MessageFormat: 可以格式化模式字符串
	 * 模式字符串: 带占位符的字符串: "Date: {0}, Salary: {1}"
	 * 可以通过 format 方法会模式字符串进行格式化
	 */
	@Test
	public void testMessageFormat() {
		String str = "Date: {0}, Salary: {1}";

		Locale locale = Locale.CHINA;
		Date date = new Date();
		double sal = 12345.12;

		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,
				locale);
		String dateStr = dateFormat.format(date);

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salStr = numberFormat.format(sal);

		String result = MessageFormat.format(str, dateStr, salStr);
		System.out.println(result);
	}

	/**
	 * NumberFormat: 格式化数字到数字字符串, 或货币字符串的工具类
	 * 1. 通过工厂方法获取 NumberFormat 对象
	 * NumberFormat.getNumberInstance(locale); //仅格式化为数字的字符串
	 * NumberFormat.getCurrencyInstance(locale); //格式为货币的字符串
	 * 
	 * 2. 通过 format 方法来进行格式化
	 * 3. 通过 parse 方法把一个字符串解析为一个 Number 类型. 
	 */
	@Test
	public void testNumberFormat() throws ParseException {
		double d = 123456789.123d;
		Locale locale = Locale.FRANCE;

		//
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

		String str = numberFormat.format(d);
		System.out.println(str);

		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
		str = numberFormat2.format(d);
		System.out.println(str);

		str = "123 456 789,123";
		d = (Double) numberFormat.parse(str);
		System.out.println(d);

		str = "123 456 789,12 €";
		d = (Double) numberFormat2.parse(str);
		System.out.println(d);

	}

	@Test
	public void testDateFormat2() throws ParseException {
		String str = "1990-12-12 12:12:12";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date date = dateFormat.parse(str);
		System.out.println(date);
	}

	/**
	 * DateFormat: 格式化日期的工具类. 
	 * DateFormate 本身是一个抽象类. 
	 * 
	 * 1. 若只希望通过 DateFormat 把一个 Date 对象转为一个字符串, 则可以通过 DateFormat 的工厂方法来获取 DateFormat 对象
	 * 2. 可以获取只格式化 Date 的 DateFormat 对象: getDateInstance(int style, Locale aLocale) 
	 * 3. 可以获取只格式化 Time 的 DateFormat 对象: getTimeInstance(int style, Locale aLocale) 
	 * 4. 可以获取既格式化 Date, 也格式化 Time 的 DateFormat 对象: 
	 * getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale) 
	 * 5. 其中 style 可以取值为: DateFormat 的常量: SHORT, MEDIUM, LONG, FULL. Locale 则为代表国家地区的 Locale 对象
	 * 6. 通过 DateFormat 的 format 方法来格式化个 Date 对象到字符串. 
	 * 
	 * 7. 若有一个字符串, 如何解析为一个 Date 对象呢 ? 
	 * I. 先创建 DateFormat 对象: 创建 DateFormat 的子类 SimpleDateFormat 对象
	 * SimpleDateFormat(String pattern). 
	 * 其中 pattern 为日期, 时间的格式, 例如: yyyy-MM-dd hh:mm:ss
	 * II. 调用 DateFormat 的 parse 方法来解析字符串到 Date 对象.  
	 * 
	 */
	@Test
	public void testDateFormat() {
		Locale locale = Locale.US;

		Date date = new Date();
		System.out.println(date);

		// 获取 DateFormat 对象
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.MEDIUM, locale);
		String str = dateFormat.format(date);
		System.out.println(str);

	}

	/**
	 * Locale: Java 中表示国家或地区的类. JDK 中提供了很多常量.
	 * 也可以通过 Locale(languageCode, countryCode) 的方式来创建 
	 * 在 WEB 应用中可以通过 request.getLocale() 方法来获取. 
	 */
	@Test
	public void testLocale() {
		Locale locale = Locale.CHINA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());

		locale = new Locale("en", "US");
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}
}
