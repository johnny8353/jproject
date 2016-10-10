package com.johnny.jdbc.jdbc3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaDataTest {

	/**
	 * ResultSetMetaData: 描述结果集的元数据. 
	 * 可以得到结果集中的基本信息: 结果集中有哪些列, 列名, 列的别名等.
	 * 结合反射可以写出通用的查询方法. 
	 */
	@Test
	public void testResultSetMetaData(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCTools.getConnection();
			String sql = "SELECT id, name customerName, email, birth " +
					"FROM customers";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			//1. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			//2. 得到列的个数
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			resultSet.next();
			for(int i = 0 ; i < columnCount; i++){
				
				//3. 得到列名
				String columnName = rsmd.getColumnName(i + 1);
				
				//4. 得到列的别名
				String columnLabel = rsmd.getColumnLabel(i + 1);
				
				System.out.println(columnName + ", " + columnLabel+","+resultSet.getObject(i+1));
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}
	
	/**
	 * DatabaseMetaData 是描述 数据库 的元数据对象.
	 * 可以由 Connection 得到. 
	 * 了解. 
	 */
	@Test
	public void testDatabaseMetaData(){
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCTools.getConnection();
			DatabaseMetaData data = connection.getMetaData();
			
			//可以得到数据库本身的一些基本信息
			//1. 得到数据库的版本号
			int version = data.getDatabaseMajorVersion();
			System.out.println(version);
			
			//2. 得到连接到数据库的用户名
			String user = data.getUserName();
			System.out.println(user);
			
			//3. 得到 MySQL 中有哪些数据库
			resultSet = data.getCatalogs();
			while(resultSet.next()){
				System.out.println(resultSet.getString(1));
			}
			
			//...
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(resultSet, null, connection);
		}
	}

}
