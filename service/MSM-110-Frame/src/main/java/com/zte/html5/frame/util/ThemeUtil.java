package com.zte.html5.frame.util;

import javax.servlet.http.*;

//系统主题样式处理工具类
public class ThemeUtil {
	public static String getThemePath(HttpSession session){
		Object themeobj = session.getAttribute("SYSTEM_THEME");
		return (themeobj==null)?"/jquery-easyui/themes/default/easyui.css":(String)themeobj;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
