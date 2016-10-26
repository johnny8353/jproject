package com.johnny.common.util;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

public class ContextUtil {
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
		DataSource dbSource = (DataSource) getBean(beanId); // 配置文件里的beanid
		Connection con = dbSource.getConnection();
		return con;
	}

	public static void main(String[] args) {
	}

}
