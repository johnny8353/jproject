package com.johnny.monitor.access.dao;

import org.springframework.stereotype.Repository;

import com.johnny.common.dao.HibernateBaseDaoImpl;
import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;
@Repository
public class SystemMonitorInstanceDaoImpl extends
		HibernateBaseDaoImpl<SystemMonitorInstanceVO> implements
		SystemMonitorInstanceDao {

}
