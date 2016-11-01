package com.johnny.monitor.common.run;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.johnny.common.util.CommonUtil;
import com.johnny.common.util.DateUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.run.BaseTask;
import com.johnny.task.common.run.BaseTaskImpl;
import com.mchange.v2.c3p0.PooledDataSource;
@Component("testTask")
@Scope(value="prototype")
public class TestTask extends BaseTaskImpl implements BaseTask{
	private Log log = LogFactory.getLog(getClass());
	private static int i = 0;
	
	public TestTask(){
		log.info("TestTask construct....");
	}
	
	public void doTaskWakeUp(TaskVO taskvo) {
		DataSource ds = (DataSource) CommonUtil.getBean("dataSource"); // 配置文件里的beanid
		 // make sure it's a c3p0 PooledDataSource 
		if ( ds instanceof PooledDataSource) { 
			PooledDataSource pds = (PooledDataSource) ds; 
			try {
				log.info("num_connections: " + pds.getNumConnectionsDefaultUser());
				log.info("num_busy_connections: " + pds.getNumBusyConnectionsDefaultUser()); 
				log.info("num_idle_connections: " + pds.getNumIdleConnectionsDefaultUser()); 
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} 
		else{
			System.err.println("Not a c3p0 PooledDataSource!");
		}
//		System.out.println(taskvo.getClassName()+taskvo.getActlStartDt());
		log.info("TestTask执行_"+(i++)+"__"+DateUtil.getNowDateTimeMMM());
	}

}
