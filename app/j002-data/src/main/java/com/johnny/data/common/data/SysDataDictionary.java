package com.johnny.data.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.johnny.data.access.vo.SystemPreferenceVO;

public class SysDataDictionary {
	
	//系统首选项 类型ing
	public static final String SYS_PREF_TYPE_SERINIT = "SERVER_INIT";
	public static final String SYS_PREF_TYPE_OTHERS = "OTHERS";
	
	public static List<SystemPreferenceVO> SYS_PREF_LISTS;// = new ArrayList<>();
	public static Map<String,String> SYS_PREF_MAPS;// = new HashMap<String, String>();
	
	public static String getSysPref(String name){
		String val = SYS_PREF_MAPS.get(name);
		return val;
	}
}
