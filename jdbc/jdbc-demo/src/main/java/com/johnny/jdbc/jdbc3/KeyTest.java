package com.johnny.jdbc.jdbc3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

public class KeyTest {

	/**
	 * 取得数据库自动生成的主键 
	 */
	@Test
	public void testGetKeyValue() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCTools.getConnection();
			String sql = "INSERT INTO customers(name, email, birth)" +
					"VALUES(?,?,?)";
//			preparedStatement = connection.prepareStatement(sql);

			//使用重载的 prepareStatement(sql, flag) 
			//来生成 PreparedStatement 对象
			preparedStatement = connection.prepareStatement(sql, 
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, "ABCDE");
			preparedStatement.setString(2, "abcde@johnny.com");
			preparedStatement.setDate(3, 
					new Date(new java.util.Date().getTime()));
			
			preparedStatement.executeUpdate();
			
			//通过 getGeneratedKeys() 获取包含了新生成的主键的 ResultSet 对象
			//在 ResultSet 中只有一列 GENERATED_KEY, 用于存放新生成的主键值.
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if(rs.next()){
				System.out.println(rs.getObject(1));
			}
			
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 0; i < rsmd.getColumnCount(); i++){
				System.out.println(rsmd.getColumnName(i + 1)); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
		
	}

}
