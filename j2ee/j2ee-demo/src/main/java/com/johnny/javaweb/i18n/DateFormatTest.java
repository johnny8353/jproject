package com.johnny.javaweb.i18n;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * 类 编 号：
 * 类 名 称：DateFormatTest
 * 内容摘要：DateFormat类可以将一个日期/时间对象格式化为表示某个国家地区的日期/时间字符串
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
public class DateFormatTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date(); // 当前这一刻的时间（日期、时间）

        // 输出日期部分
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
        String result = df.format(date);
        System.out.println(result);

        // 输出时间部分
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // 输出日期和时间
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // 把字符串反向解析成一个date对象
        String s = "10-9-26 下午02时49分53秒";
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        Date d = df.parse(s);
        System.out.println(d);
    }
}