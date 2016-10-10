
package com.johnny.javaweb.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.junit.Test;

public class MessageFormatTest extends TestCase{
	@Test
	public void testMessageFormat(){
		 //模式字符串
        String pattern = "On {0}, a hurricance destroyed {1} houses and caused {2} of damage.";
        //实例化MessageFormat对象，并装载相应的模式字符串
        MessageFormat format = new MessageFormat(pattern, Locale.CHINA);
        Object arr[] = {new Date(), 99, 100000000};
        //格式化模式字符串，参数数组中指定占位符相应的替换对象
        String result = format.format(arr);
        System.out.println(result);
	}
	@Test
	public void testMessageFormat2(){
		 //模式字符串
        String pattern = "At {0, time, short} on {0, date}, a destroyed {1} houses and caused {2, number, currency} of damage.";
        //实例化MessageFormat对象，并装载相应的模式字符串
        MessageFormat format = new MessageFormat(pattern, Locale.US);
        Object arr[] = {new Date(), 99, 100000000};
        //格式化模式字符串，参数数组中指定占位符相应的替换对象
        String result = format.format(arr);
        System.out.println(result);
	}
}