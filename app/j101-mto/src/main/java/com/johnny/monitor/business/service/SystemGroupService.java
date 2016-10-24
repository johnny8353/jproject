package com.johnny.monitor.business.service;

import com.johnny.common.business.service.HibernateBaseService;
import com.johnny.monitor.access.vo.SystemGroupVO;
import com.johnny.monitor.model.SystemListBO;

public interface SystemGroupService extends HibernateBaseService<SystemGroupVO> {
	public SystemListBO findSystemListBO();
}
