package com.johnny.data.common.observer;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnny.data.access.vo.SystemPreferenceVO;
import com.johnny.data.business.service.SystemPreferenceService;
import com.johnny.data.common.data.SysDataDictionary;

/**
 * 类 编 号：
 * 类 名 称：SysPrefCacheObserver
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月27日
 * 编码作者：JohnnyHuang 黄福强
 */
@Component
public class SysPrefCacheObserver implements Observer{
	protected Log log = LogFactory.getLog(getClass());
	@Autowired
	private SystemPreferenceService systemPreferenceService;
	
	@Override
	public void update(Observable o, Object arg) {
		log.info("--init SYS_PREF_MAPS inti--");
		SysDataDictionary.SYS_PREF_LISTS = systemPreferenceService.findList(null);
		SysDataDictionary.SYS_PREF_MAPS = new HashMap<String, String>();
		for (SystemPreferenceVO sysPref : SysDataDictionary.SYS_PREF_LISTS) {
			SysDataDictionary.SYS_PREF_MAPS.put(sysPref.getName(), sysPref.getVal());
		}
		log.info("--init SYS_PREF_MAPS finished,total :"+SysDataDictionary.SYS_PREF_LISTS.size());
	}


}
