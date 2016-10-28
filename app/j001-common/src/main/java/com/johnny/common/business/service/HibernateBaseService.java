package com.johnny.common.business.service;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.johnny.common.access.dao.HibernateBaseDao;
import com.johnny.common.access.dao.HibernateHandler;
import com.johnny.common.access.dao.Pagination;

public interface HibernateBaseService<T>{

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体主键
	 */
	Object save(T entity);

	/**
	 * 
	 * 删除实体
	 * 
	 * @param entiy
	 *            实体对象
	 * 
	 */
	void delete(T entity);

	/**
	 * 
	 * 更新实体
	 * 
	 * @param entity
	 *            实体对象
	 * 
	 */
	void update(T entity);

	/**
	 * 
	 * 保存或更新实体, 实体没有主键时保存，否则更新
	 * 
	 * @param entity
	 *            实体对象
	 * 
	 */
	void saveOrUpdate(T entity);

	/**
	 * 
	 * 批量保存实体
	 * 
	 * @param entities
	 *            实体集合
	 */
	void saveAll(Collection<?> entities);

	/**
	 * 
	 * 批量删除实体
	 * 
	 * @param entities
	 *            实体集合
	 * 
	 */
	void deleteAll(Collection<?> entities);
	public void delete(Serializable id);
	/**
	 * 
	 * 批量更新实体
	 * 
	 * @param entities
	 *            实体集合
	 * 
	 */
	void updateAll(Collection<?> entity);

	/**
	 * 
	 * 批量保存或更新实体, 实体没有主键时保存，否则更新
	 * 
	 * @param entity
	 *            实体集合
	 * 
	 */
	void saveOrUpdateAll(Collection<?> entities);

	/**
	 * 
	 * 获取单个实体，根据实体类及实体的主键获取。
	 * 
	 * @param entityClass
	 *            实体类
	 * @param id
	 *            实体主键
	 * @return 实体对象
	 */
//	@SuppressWarnings("hiding")
//	<T> T get(Serializable id);

	/**
	 * 获取单个实体，根据查询语句及参数获取。
	 * 
	 * @param queryString
	 *            查询语句
	 * @param params
	 *            可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
	@SuppressWarnings("hiding")
	<T> T get(Map<String, Object> params);

	/**
	 * 获取单个实体，根据查询语句及参数获取。
	 * 
	 * @param queryString
	 *            查询语句
	 * @param params
	 *            可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
//	@SuppressWarnings("hiding")
//	<T> T get(Object... params);

	/**
	 * 
	 * 查询实体列表
	 * 
	 * @param queryString
	 *            查询语句
	 * @param params
	 *            可选的查询参数
	 * @return 实体列表
	 */
//	@SuppressWarnings("hiding")
//	<T> List<T> findList(Object... params);

	/**
	 * 
	 * 查询实体列表
	 * 
	 * @param queryString
	 *            查询语句
	 * @param params
	 *            可选的查询参数
	 * @return 实体列表
	 */
	@SuppressWarnings("hiding")
	<T> List<T> findList(Map<String, Object> params);

	/**
	 * 分页查询实体
	 * 
	 * @param queryString
	 *            查询语句
	 * @param pageIndex
	 *            当前页码，如果pageIndex<1则不分页，且返回pageSize条记录。
	 * @param pageSize
	 *            每页记录数，如果pageSize<1则返回所有记录。
	 * @param params
	 *            可选的查询参数
	 * @return 实体分页对象
	 */
//	@SuppressWarnings("hiding")
//	<T> Pagination<T> findPagination(int pageIndex,
//			int pageSize, Object... params);

	/**
	 * 分页查询实体
	 * 
	 * @param queryString
	 *            查询语句
	 * @param params
	 *            可选的查询参数
	 * @param pageIndex
	 *            当前页码，如果pageIndex<2则不分页，且返回pageSize条记录。
	 * @param pageSize
	 *            每页记录数，如果pageSize<1则返回所有记录。
	 * 
	 * @return 实体分页对象
	 */
	@SuppressWarnings("hiding")
	<T> Pagination<T> findPagination(int pageIndex, int pageSize,Map<String, Object> params);




	/**
	 * 执行数据库更新操作
	 * 
	 * @deprecated 用{@link #executeUpdate(String)}替换
	 * @param hql
	 */
	void execute(String hql);

	/**
	 * 执行数据库更新操作
	 * 
	 * @deprecated 用{@link #executeUpdate(HibernateHandler)}替换
	 * @param hql
	 */
	void execute(HibernateHandler handler);

	/**
	 * 执行数据库更新操作
	 * 
	 * @deprecated 用{@link #executeSqlUpdate(String)}替换
	 * @param sql
	 */
	void executeSql(String sql);

	/**
	 * 执行数据库查询操作
	 * 
	 * @param handler
	 *            处理器
	 * @return
	 * @throws Exception
	 */
	Object executeQuery(HibernateHandler handler);

	/**
	 * 执行数据库更新操作
	 * 
	 * @param sql
	 * @return 更新的记录条数
	 */
	int executeSqlUpdate(String sql);

	/**
	 * 执行数据库更新操作
	 * 
	 * @param hql
	 * @return 更新的记录条数
	 */
	int executeUpdate(String hql);

	/**
	 * 执行数据库更新操作
	 * 
	 * @param handler
	 *            处理器
	 * @return
	 * @throws Exception
	 */
	Object executeUpdate(HibernateHandler handler);

	public T getById(Serializable id);

	public T saveEntity(T o);

	public T insert(T o);

	public void save(List<T> list);

	public void insert(List<T> list);

	public void delete(List<T> list);

	public void update(List<T> list);

	public List<T> findByProperty(String name, Object value);

	public List<T> findByProperty(Map<String, Object> conditionMap);

	/**
	 * 
	 * 查询实体列表
	 * 
	 * @param queryString
	 *            查询语句
	 * @param maxResults
	 *            列表最大数
	 * @param params
	 *            可选的查询参数
	 * @return 实体列表
	 */
//	public <V> List<V> findListByMax(int maxResults,
//			Object... params);

	/**
	 * 
	 * 查询实体列表
	 * 
	 * @param queryString
	 *            查询语句
	 * @param maxResults
	 *            列表最大数
	 * @param params
	 *            可选的查询参数
	 * @return 实体列表
	 */
	public <V> List<V> findListByMax(int maxResults,
			Map<String, Object> params);
}
