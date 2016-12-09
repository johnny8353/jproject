package com.johnny.task.business.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.business.service.HibernateBaseServiceImpl;
import com.johnny.task.access.dao.TaskDao;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.data.SysDataDictionary;

@Service
public class TaskServiceImpl extends HibernateBaseServiceImpl<TaskVO> implements
		TaskService {
	private Log log = LogFactory.getLog(getClass());
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
	
	/**
	 SELECT COUNT(1) FROM `mto`.`jt_task` t WHERE t.par_row_id = 3 AND T.CREATE_DATE BETWEEN
   		DATE_SUB(NOW(),INTERVAL (SELECT rpt_interval  FROM `mto`.`jt_task` T  WHERE t.row_id = 3) SECOND) AND  NOW()
	 */
	@Override
	public Integer GetCountInOnePeriod(Long taskPid) {
		Integer count = 0;
		String sql = "SELECT COUNT(1) FROM `jt_task` t WHERE t.par_row_id = :par_row_id AND "
				+ "T.CREATE_DATE BETWEEN DATE_SUB(NOW(),INTERVAL (SELECT rpt_interval  FROM `mto`.`jt_task` T  WHERE t.row_id = :par_row_id)"
				+ " SECOND) AND  NOW()";
		Map<String, Object> params = new  HashMap<String, Object>();
		params.put("par_row_id", taskPid);
		List<Object[]> objs = taskDao.findSqlList(sql, params );
		try{
			Object obj = objs.get(0);
			if(obj instanceof BigInteger){
				count = ((BigInteger)obj).intValue();
			}
			else{
				count = (Integer) obj;
			}
		}catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
}
