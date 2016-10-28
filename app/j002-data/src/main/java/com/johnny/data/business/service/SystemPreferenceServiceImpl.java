package com.johnny.data.business.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.business.service.HibernateBaseServiceImpl;
import com.johnny.data.access.dao.SystemPreferenceDao;
import com.johnny.data.access.vo.SystemPreferenceVO;
@Service
public class SystemPreferenceServiceImpl extends
		HibernateBaseServiceImpl<SystemPreferenceVO> implements
		SystemPreferenceService {
	@Autowired
	private SystemPreferenceDao systemPreferenceDao;
	@Override
	public Object save(SystemPreferenceVO entity) {
		SystemPreferenceVO baseVO = (SystemPreferenceVO) entity;
		baseVO.setConflictId("");
		baseVO.setCreateDate(new Date());
		baseVO.setCreatedBy("");
		baseVO.setDbLastUpd(new Date());
		baseVO.setDbLastUpdSrc("Script");
		baseVO.setLastUpdDate(new Date());
		baseVO.setModificationNum(1L);
		baseVO.setLastUpdBy("");
		return systemPreferenceDao.save(baseVO);
	}

	@Override
	public void update(SystemPreferenceVO entity) {
		SystemPreferenceVO baseVO = (SystemPreferenceVO) entity;
		baseVO.setLastUpdDate(new Date());
		baseVO.setModificationNum(baseVO.getModificationNum()+1);
		systemPreferenceDao.update(baseVO);
	}
	@Override
	public <T> T get(Map<String, Object> params) {
		String hql = "from SystemPreferenceVO vo where vo.name=:name";
		return systemPreferenceDao.get(hql, params);
	}

	@Override
	public <T> List<T> findList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return systemPreferenceDao.findList("from SystemPreferenceVO vo ",params);
	}
	
}
