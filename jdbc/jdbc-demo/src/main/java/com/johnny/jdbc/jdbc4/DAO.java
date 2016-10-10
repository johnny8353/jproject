package com.johnny.jdbc.jdbc4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 访问数据的 DAO 接口. 
 * 里边定义好访问数据表的各种方法
 * @param T: DAO 处理的实体类的类型. 
 */
public interface DAO<T> {

	/**
	 * 批量处理的方法
	 * @param connection
	 * @param sql
	 * @param args: 填充占位符的 Object [] 类型的可变参数.
	 * @throws SQLException 
	 */  
	void batch(Connection connection, 
			String sql, Object [] ... args) throws SQLException;
	
	/**
	 * 返回具体的一个值, 例如总人数, 平均工资, 某一个人的 email 等.
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	<E> E getForValue(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * 返回 T 的一个集合
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	List<T> getForList(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * 返回一个 T 的对象
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	T get(Connection connection, String sql, 
			Object ... args) throws SQLException;
	
	/**
	 * INSRET, UPDATE, DELETE
	 * @param connection: 数据库连接
	 * @param sql: SQL 语句
	 * @param args: 填充占位符的可变参数.
	 * @throws SQLException 
	 */
	void update(Connection connection, String sql, 
			Object ... args) throws SQLException;

}
