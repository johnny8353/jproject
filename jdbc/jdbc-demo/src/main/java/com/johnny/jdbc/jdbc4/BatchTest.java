package com.johnny.jdbc.jdbc4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

/**
 * Commons-dbcp.jar：连接池的实现
	Commons-pool.jar：连接池实现的依赖库
	该例子使用oracle数据库测试效果较明显，因为mysql插入10万条很慢，而且相差不多
 * 完成日期：2016年8月10日
 * 编码作者：JohnnyHuang 黄福强
 */
public class BatchTest {
	private final int COUNT = 100;
	
	@Test
	public void testJdbcTools() throws Exception{
		Connection connection = JDBCTools.getConnection();
		System.out.println(connection); 
	}
	
	
	@Test
	public void testBatch(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			Date date = new Date(new java.util.Date().getTime());
			
			long begin = System.currentTimeMillis();
			for(int i = 0; i < COUNT; i++){
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);
				
				//"积攒" SQL 
				preparedStatement.addBatch();
				
				//当 "积攒" 到一定程度, 就统一的执行一次. 并且清空先前 "积攒" 的 SQL
				if((i + 1) % 300 == 0){
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			
			//若总条数不是批量数值的整数倍, 则还需要再额外的执行一次. 
			if(100000 % 300 != 0){
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("Time: " + (end - begin)); //569
			
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
	

	@Test
	public void testBatchWithPreparedStatement(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			Date date = new Date(new java.util.Date().getTime());
			
			long begin = System.currentTimeMillis();
			for(int i = 0; i < COUNT; i++){
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);
				
				preparedStatement.executeUpdate();
			}
			long end = System.currentTimeMillis();
			
			System.out.println("Time: " + (end - begin)); //9819
			
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
	
	/**
	 * 向  Oracle 的 customers 数据表中插入 10 万条记录
	 * 测试如何插入, 用时最短. 
	 * 1. 使用 Statement.
	 */
	@Test
	public void testBatchWithStatement(){
		Connection connection = null;
		Statement statement = null;
		String sql = null;
		
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			
			statement = connection.createStatement();
			Date date = new Date(new java.util.Date().getTime());
			long begin = System.currentTimeMillis();
			for(int i = 0; i < COUNT; i++){
				sql = "INSERT INTO customers(name,email,birth) VALUES(" + (i + 1) 
						+ ", 'name_" + i + "', '2011-1-1')";
//				statement.addBatch(sql);
				statement.execute(sql);
			}
			long end = System.currentTimeMillis();
			
			System.out.println("Time: " + (end - begin)); //39567
			
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, statement, connection);
		}
	}

}
