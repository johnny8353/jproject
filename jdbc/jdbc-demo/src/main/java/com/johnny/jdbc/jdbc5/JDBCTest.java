package com.johnny.jdbc.jdbc5;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTest {

	/**
	 * 如何使用 JDBC 调用存储在数据库中的函数或存储过程
	 */
	@Test
	public void testCallableStatment() {

		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			connection = JDBCTools.getConnection();

			// 1. 通过 Connection 对象的 prepareCall()
			// 方法创建一个 CallableStatement 对象的实例.
			// 在使用 Connection 对象的 preparedCall() 方法时,
			// 需要传入一个 String 类型的字符串, 该字符串用于指明如何调用存储过程.
			String sql = "{?= call sum_salary(?, ?)}";
			callableStatement = connection.prepareCall(sql);

			// 2. 通过 CallableStatement 对象的 
			//reisterOutParameter() 方法注册 OUT 参数.
			callableStatement.registerOutParameter(1, Types.NUMERIC);
			callableStatement.registerOutParameter(3, Types.NUMERIC);
			
			// 3. 通过 CallableStatement 对象的 setXxx() 方法设定 IN 或 IN OUT 参数. 若想将参数默认值设为
			// null, 可以使用 setNull() 方法.
			callableStatement.setInt(2, 80);
			
			// 4. 通过 CallableStatement 对象的 execute() 方法执行存储过程
			callableStatement.execute();
			
			// 5. 如果所调用的是带返回参数的存储过程, 
			//还需要通过 CallableStatement 对象的 getXxx() 方法获取其返回值.
			double sumSalary = callableStatement.getDouble(1);
			long empCount = callableStatement.getLong(3);
			
			System.out.println(sumSalary);
			System.out.println(empCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, callableStatement, connection);
		}


	}

	@Test
	public void testC3P0() throws SQLException {
		DataSource dataSource = new ComboPooledDataSource("helloc3p0");

		System.out.println(dataSource.getConnection());
	}

}
