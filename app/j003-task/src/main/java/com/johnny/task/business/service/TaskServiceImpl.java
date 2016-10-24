package com.johnny.task.business.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.business.service.HibernateBaseServiceImpl;
import com.johnny.task.access.dao.TaskDao;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.data.SysDataDictionary;

@Service
public class TaskServiceImpl extends HibernateBaseServiceImpl<TaskVO> implements
		TaskService {
	@Autowired
	private TaskDao taskDao;

	/**
	 * 获取 状态为 排队、活动、挂起的线程 ，重复任务
	 */
	@Override
	public List<TaskVO> getStartupRpdTask() {
		List<TaskVO> tasks = new ArrayList<>();
		CharSequence queryString = "from TaskVO vo where vo.rptFlag='Y' and vo.status in (:status)";
		Map<String, Object> params = new HashMap<>();
		String[] stringArray = new String[]{ SysDataDictionary.THREAD_STATUS_ACTIVE,
				SysDataDictionary.THREAD_STATUS_PENDING,
				SysDataDictionary.THREAD_STATUS_WAIT };
		StringBuffer status = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) {
			status.append( "'"+stringArray[i]+"'" );
			if(i<stringArray.length-1){
				status.append(",");
			}
		}
		params.put("status", Arrays.asList(stringArray));
		tasks = taskDao.findList(queryString, params);
		return tasks;
	}
}
