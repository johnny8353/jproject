package com.johnny.monitor.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.business.service.HibernateBaseServiceImpl;
import com.johnny.monitor.access.dao.SystemMonitorInstanceDao;
import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;

@Service
public class SystemMonitorInstanceServiceImpl extends
		HibernateBaseServiceImpl<SystemMonitorInstanceVO> implements
		SystemMonitorInstanceService {
	@Autowired
	private SystemMonitorInstanceDao systemMonitorInstanceDao;

	
}
