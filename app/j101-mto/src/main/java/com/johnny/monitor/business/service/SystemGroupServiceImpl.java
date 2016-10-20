package com.johnny.monitor.business.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.service.HibernateBaseServiceImpl;
import com.johnny.monitor.access.dao.SystemGroupDao;
import com.johnny.monitor.access.dao.SystemInfoDao;
import com.johnny.monitor.access.vo.SystemGroupVO;
import com.johnny.monitor.access.vo.SystemInfoVO;
import com.johnny.monitor.model.SystemBO;
import com.johnny.monitor.model.SystemListBO;

@Service
public class SystemGroupServiceImpl extends
		HibernateBaseServiceImpl<SystemGroupVO> implements SystemGroupService {
	@Autowired
	private SystemGroupDao systemGroupDao;
	@Autowired
	private SystemInfoDao systemInfoDao;

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return systemGroupDao.get(entityClass, id);
	}

	@Override
	public SystemListBO findSystemListBO() {
		SystemListBO systemListBO = new SystemListBO();
		Map<String, Object> params = new HashMap<>();
		// 获取所有group
		ArrayList<SystemBO> systemboList = new ArrayList<>();
		List<SystemGroupVO> groups = systemGroupDao.findList(
				"from SystemGroupVO s order by s.orderBy asc", params);
		for (SystemGroupVO systemGroupVO : groups) {
			SystemBO systemBO = new SystemBO();
			systemBO.setGroupVO(systemGroupVO);
			// 获取group下的system
			params.put("groupId", systemGroupVO.getRowId());
			List<SystemInfoVO> systemInfos = systemInfoDao
					.findList(
							"from SystemInfoVO s where s.groupId=:groupId order by s.orderby asc",
							params);
			List<SystemInfoVO> systemInfoVOs = new ArrayList<SystemInfoVO>();
			for (SystemInfoVO systemInfoVO : systemInfos) {
				systemInfoVOs.add(systemInfoVO);
			}
			systemBO.setSystemInfoVOList(systemInfoVOs);

			systemboList.add(systemBO);
		}
		systemListBO.setSystemBOList(systemboList);
		return systemListBO;
	}

}
