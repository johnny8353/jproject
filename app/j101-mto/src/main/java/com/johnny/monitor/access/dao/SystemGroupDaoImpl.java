package com.johnny.monitor.access.dao;

import org.springframework.stereotype.Repository;

import com.johnny.common.dao.HibernateBaseDaoImpl;
import com.johnny.monitor.access.vo.SystemGroupVO;
@Repository
public class SystemGroupDaoImpl extends HibernateBaseDaoImpl<SystemGroupVO> implements
		SystemGroupDao {
	
}
