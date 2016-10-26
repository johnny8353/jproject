package com.johnny.task.business.service;

import java.util.List;

import com.johnny.common.business.service.HibernateBaseService;
import com.johnny.task.access.vo.TaskVO;

public interface TaskService extends HibernateBaseService<TaskVO>{
	public List<TaskVO> getStartupRpdTask();
	
	public Integer GetCountInOnePeriod(Long taskPid);
}
