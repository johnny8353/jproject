package com.johnny.monitor.business.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.business.service.HibernateBaseServiceImpl;
import com.johnny.monitor.access.dao.SystemMonitorInstanceDao;
import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;
import com.johnny.monitor.common.data.SysDataDictionary;

@Service
public class SystemMonitorInstanceServiceImpl extends
		HibernateBaseServiceImpl<SystemMonitorInstanceVO> implements
		SystemMonitorInstanceService {
	@Autowired
	private SystemMonitorInstanceDao systemMonitorInstanceDao;

	@Override
	public List<SystemMonitorInstanceVO> findErrorInsList(Map<String,Object> params) {
		String hql = "from SystemMonitorInstanceVO vo where vo.result=:result and vo.batchNum = :batchNum";
		params.put("result", SysDataDictionary.MONITOR_RESULT_FAIL_NAME);
		return systemMonitorInstanceDao.findList(hql, params);
	}
	/**
	 SELECT info.ENVIROMENT_TYPE,COUNT(1)
	FROM `mto`.`jt_system_monitor_instance` ins
	LEFT JOIN mto.`jt_system_group` g ON g.`ROW_ID` = ins.`GROUP_ID`
	LEFT JOIN mto.`jt_system_info` info ON info.`ROW_ID` = ins.`SYSTEM_ID`
	WHERE ins.BATCH_NUM='20161027170000222' AND ins.RESULT='错误' AND g.SYS_CODE='MSM'
	GROUP BY info.ENVIROMENT_TYPE;
	 */
	public Map<String,Object> findErrorCountGroupByType(Map<String,Object> params){
		Map<String,Object> maps = new HashMap<String, Object>();
		String sql = "SELECT info.ENVIROMENT_TYPE,COUNT(1) " +
				"FROM `mto`.`jt_system_monitor_instance` ins " +
				"LEFT JOIN mto.`jt_system_group` g ON g.`ROW_ID` = ins.`GROUP_ID` " +
				"LEFT JOIN mto.`jt_system_info` info ON info.`ROW_ID` = ins.`SYSTEM_ID` " +
				"WHERE ins.BATCH_NUM=:batchNum AND ins.RESULT='错误' AND g.SYS_CODE=:sysCode " +
				"GROUP BY info.ENVIROMENT_TYPE";
		List<Object[]> list = systemMonitorInstanceDao.findSqlList(sql, params);
		for(Object [] objs: list){
			maps.put((String) objs[0], objs[1]);
		}
		return maps;
	}

	
}
