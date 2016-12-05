package com.johnny.druid.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.druid.model.TableOperator;
import com.johnny.druid.util.DataSourceUtil;


public class MutilThreadTest {
	private ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static void test(int dbType, int times)
		throws Exception { 
		int numOfThreads =Runtime.getRuntime().availableProcessors()*2;
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);  
        final TableOperator test = new TableOperator();
//        int dbType = DataSourceUtil.DRUID_MYSQL_SOURCE;
//        dbType = DataSourceUtil.DBCP_SOURCE;
        test.setDataSource(DataSourceUtil.getDataSource(dbType));
        
        boolean createResult = false;
        try {
			test.createTable();
			createResult = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (createResult) {
			List<Future<Long>> results = new ArrayList<Future<Long>>();   
	        for (int i = 0; i < times; i++) {  
	            results.add(executor.submit(new Callable<Long>() {  
	                public Long call() throws Exception {  
	                        long begin = System.currentTimeMillis();
	                			try {
	                				test.insert();
	                				//insertResult = true;
	                			} catch (Exception e) {
	                				e.printStackTrace();
	                			}	                		
	                        long end = System.currentTimeMillis();  
	                    return end - begin;  
	                }  
	            }));  
	        }  
	        executor.shutdown();  
	        while(!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS));  
	          
	        long sum = 0;  
	        for (Future<Long> result : results) {  
	            sum += result.get();  
	        }  
	          
	          
	        System.out.println("---------------db type "+dbType+"------------------");  
	        System.out.println("number of threads :" + numOfThreads + " times:" + times);  
	        System.out.println("running time: " + sum + "ms");  
	        System.out.println("TPS: " + (double)(100000 * 1000) / (double)(sum));  
	        System.out.println();  
	        try {
				test.tearDown();
				//dropResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("初始化数据库失败");
		}
        
    }  
	
	public static void main (String argc[])
		throws Exception {
		test(DataSourceUtil.DBCP_SOURCE,50);
		test(DataSourceUtil.DRUID_MYSQL_SOURCE,50);
		
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testDataSource2() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSourceDbcp");
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testDataSource3() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSourceC3P0");
		System.out.println(dataSource.getConnection());
	}
}
