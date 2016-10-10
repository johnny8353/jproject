package com.johnny.jdbc.jdbc3.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import com.johnny.jdbc.jdbc3.JDBCTools;

/**
 * 1. 使用 PreparedStatement: Statement 的子接口, 用于执行带占位符的 SQL
 * 2. 使用 JDBC 的元数据 ResultSetMetaData. 和反射结合写一个通用的查询类
 */
public class ReviewTest {

	@Test
	public void testResultSetMetaData(){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCTools.getConnection();
			String sql = "SELECT id, name cusstomerName, email, birth " +
					"FROM customers";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			//1. 得到 ResultSetMetaData 对象: 调用 ResultSet 的  getMetaData() 方法
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			//2. 得到结果集中有多少列, 以及每一列的列的别名都是什么
			//getColumnCount(), getColumnLabel()
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			
			for(int i = 0; i < columnCount; i++){
				String columnLabel = rsmd.getColumnLabel(i + 1);
				System.out.println(columnLabel); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		
	}
	
	@Test
	public void testPreparedStatement(){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCTools.getConnection();
			
			//1. 获取 PreparedStatement 
			String sql = "UPDATE customers SET email = ? " +
					"WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);

			//2. 填充占位符
			preparedStatement.setString(1, "johnny@gmail.com");
			preparedStatement.setInt(2, 5);
			
			//3. 调用 executeUpdate() 或 executeQuery() 方法执行 SQL 操作. 
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
		
	}
	
}
