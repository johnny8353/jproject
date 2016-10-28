package com.johnny.data.access.dao;

import org.springframework.stereotype.Repository;

import com.johnny.common.access.dao.HibernateBaseDaoImpl;
import com.johnny.data.access.vo.SystemPreferenceVO;

@Repository
public class SystemPreferenceDaoImpl extends
		HibernateBaseDaoImpl<SystemPreferenceVO> implements SystemPreferenceDao {

}
