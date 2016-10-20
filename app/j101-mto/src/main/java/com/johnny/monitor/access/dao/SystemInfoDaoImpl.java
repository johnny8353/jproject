package com.johnny.monitor.access.dao;

import org.springframework.stereotype.Repository;

import com.johnny.common.dao.HibernateBaseDaoImpl;
import com.johnny.monitor.access.vo.SystemInfoVO;
@Repository
public class SystemInfoDaoImpl extends HibernateBaseDaoImpl<SystemInfoVO> implements
		SystemInfoDao {

}
