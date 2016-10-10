package com.johnny.jdbc.jdbc4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 使用 QueryRunner 提供其具体的实现
 * @param <T>: 子类需传入的泛型类型. 
 */
public class JdbcDaoImpl<T> implements DAO<T> {

	private QueryRunner queryRunner = null;
	private Class<T> type;
	
	public JdbcDaoImpl() {
		queryRunner = new QueryRunner();
		type = ReflectionUtils.getSuperGenericType(getClass());
	}
	
	@Override
	public void batch(Connection connection, String sql, Object[]... args) throws SQLException {
		queryRunner.batch(connection, sql, args);
	}

	@Override
	public <E> E getForValue(Connection connection, String sql, Object... args) throws SQLException {
		return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
	}

	@Override 
	public List<T> getForList(Connection connection, String sql, Object... args) 
			throws SQLException {
		return queryRunner.query(connection, sql, 
				new BeanListHandler<>(type), args);
	}

	@Override
	public T get(Connection connection, String sql, Object... args) throws SQLException { 
		return queryRunner.query(connection, sql, 
				new BeanHandler<>(type), args);
	}

	@Override
	public void update(Connection connection, String sql, Object... args) throws SQLException {
		queryRunner.update(connection, sql, args);
	}
	
}
