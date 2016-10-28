package com.johnny.monitor.business.service;

import java.util.List;
import java.util.Map;

import com.johnny.common.business.service.HibernateBaseService;
import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;

public interface SystemMonitorInstanceService extends
		HibernateBaseService<SystemMonitorInstanceVO> {
	public List<SystemMonitorInstanceVO> findErrorInsList(Map<String,Object> params);
	public Map<String,Object> findErrorCountGroupByType(Map<String,Object> params);
}
