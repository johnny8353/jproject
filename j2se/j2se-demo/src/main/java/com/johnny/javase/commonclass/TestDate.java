package com.johnny.javase.commonclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * 与时间相关的类：
 * 1.System 类下的currentTimeMillis();
 * 2.Date类:java.util.Date 
 *    如何创建其实例；其下的方法：toString()、getTime()
 *    (以及其子类java.sql.Date)
 * 3.SimpleDateFormat类
 * 4.Calendar类
 */
public class TestDate {
	
	
	//日历：Calendar类   get()/add()/set()/Date getTime()/setTime(Date d)
	@Test
	public void test4(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		c.add(Calendar.DAY_OF_MONTH, -2);
		day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		c.set(Calendar.DAY_OF_MONTH, 23);
		Date d = c.getTime();
		System.out.println(d);
		
	}
	
	
	/*
	 * “三天打渔两天晒网”  1990-01-01  XXXX-XX-XX 打渔？晒网？
	 */
	//返回date1与date2之间的天数,date1早于date2
	public int getDays(String date1,String date2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long milliTime = d2.getTime()-d1.getTime();
		return (int)milliTime/1000/3600/24 + 1;
		
	}
	
	@Test
	public void test3() throws ParseException{
		String str1 = "1990-01-01";
		String str2 = "1990-01-06";
		int dates = getDays(str1,str2);
		
		if(dates % 5 == 0 || dates % 5 == 4){
			System.out.println("晒网");
		}else{
			System.out.println("打渔");
		}
	}
	
	/*
	 * java.text.SimpleDateFormat类易于国际化
	 * 格式化：日期--->文本 使用SimpleDateFormat的format()方法
	 * 解析：文本--->日期 使用SimpleDateFormat的parse()方法
	 */
	@Test
	public void test2() throws Exception{
		//1.格式化1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());
		System.out.println(date);//14-5-12 下午3:24
		//2.格式化2
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		date = sdf1.format(new Date());
		System.out.println(date);//星期一, 12 五月 2014 15:29:16 +0800
		
		//3.解析：
		Date date1 = sdf.parse("14-5-12 下午3:24");
		System.out.println(date1);
		
		date1 = sdf1.parse("星期一, 12 五月 2014 15:29:16 +0800");
//		date1 = sdf1.parse("14-5-12 下午3:24");
		System.out.println(date1);
	}
	//java.util.Date不易于国际化
	@Test
	public void test1(){
//		java.sql.Date d2 = new java.sql.Date(15342515326235L);
//		System.out.println(d2);//2456-03-08
		//创建一个Date的实例
		Date d1 = new Date();
		System.out.println(d1.toString());//Mon May 12 15:17:01 CST 2014
		System.out.println(d1.getTime());//1399879144434
		Date d2 = new Date(1399879144434L);
		System.out.println(d2);
	}
}	
