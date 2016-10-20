package com.johnny.monitor.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.service.HibernateBaseServiceImpl;
import com.johnny.monitor.access.vo.SystemInfoVO;

@Service
public class SystemInfoServiceImpl extends HibernateBaseServiceImpl<SystemInfoVO> implements SystemInfoService {
	
}
