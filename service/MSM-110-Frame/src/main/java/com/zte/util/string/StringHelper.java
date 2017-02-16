package com.zte.util.string;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StringHelper {

	/**
	 * 获取一个GUID
	 * 
	 * @return
	 */
	public static String GetGUID() {
		UUID uuid = java.util.UUID.randomUUID();
		String id = uuid.toString();
		return id;
	}
	
	/**
	 * 生成各種編碼
	 * 
	 * @return
	 */
	public static String GenerateCodeValue(String head) {
		DateFormat formater = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuilder sb = new StringBuilder(formater.format(new Date()));
		int i = (int) (Math.random() * 90) + 10; // 生成3位随机数
		String strAm1 = String.valueOf(i);
		String msgNo = head + sb.append(strAm1).toString();
		return msgNo;
	}

	/**
	 * 判断对象为空
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof List)) {
			return ((List) obj).size() == 0;
		}
		if ((obj instanceof String)) {
			return ((String) obj).trim().equals("");
		}
		return false;
	}
	 /**
	  * 判断对象不为空
	  */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
