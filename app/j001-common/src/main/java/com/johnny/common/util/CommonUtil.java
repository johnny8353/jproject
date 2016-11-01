package com.johnny.common.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.johnny.common.access.vo.BaseVO;
import com.mchange.v2.c3p0.PooledDataSource;

public class CommonUtil {
	/**
	 * 获取bean实例 业务描述：XXX 作 者：JohnnyHuang 黄福强 完成日期：2015-7-24
	 * 
	 * @param beanId
	 * @return
	 */
	@SuppressWarnings("resource")
	public static Object getBean(String beanId) {
		ApplicationContext wac = ContextLoader
				.getCurrentWebApplicationContext();
		if(wac == null){
			wac = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return wac.getBean(beanId);
	}
	
	/**
	 * 获取connect
	 * @param beanId
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnectionFromSpring(String beanId)
			throws Exception {
		Log log = LogFactory.getLog(CommonUtil.class);
		DataSource dbSource = (DataSource) getBean(beanId); // 配置文件里的beanid
		if ( dbSource instanceof PooledDataSource) { 
			PooledDataSource pds = (PooledDataSource) dbSource; 
			try {
				log.info("num_connections: " + pds.getNumConnectionsDefaultUser());
				log.info("num_busy_connections: " + pds.getNumBusyConnectionsDefaultUser()); 
				log.info("num_idle_connections: " + pds.getNumIdleConnectionsDefaultUser()); 
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} 
		Connection con = dbSource.getConnection();
		return con;
	}
	

	public static void main(String[] args) {
	}

}
