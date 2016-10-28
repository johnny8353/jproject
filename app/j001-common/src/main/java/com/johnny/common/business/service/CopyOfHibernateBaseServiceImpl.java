//package com.johnny.common.business.service;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.johnny.common.access.dao.HibernateBaseDao;
//import com.johnny.common.access.dao.HibernateHandler;
//import com.johnny.common.access.dao.Pagination;
//@Service
//public class CopyOfHibernateBaseServiceImpl<T> implements HibernateBaseService<T>{
//	@Autowired
//	private HibernateBaseDao<T> dao;
//	
//	public Object save(Object entity) {
//		// TODO Auto-generated method stub
//		return dao.save(entity);
//	}
//
//	
//	public void delete(Object entity) {
//		// TODO Auto-generated method stub
//		dao.delete(entity);
//	}
//
//	
//	public void update(Object entity) {
//		// TODO Auto-generated method stub
//		dao.update(entity);
//	}
//
//	
//	public void saveOrUpdate(Object entity) {
//		// TODO Auto-generated method stub
//		dao.saveOrUpdate(entity);
//	}
//
//	
//	public void saveAll(Collection<?> entities) {
//		// TODO Auto-generated method stub
//		dao.saveAll(entities);
//	}
//
//	
//	public void deleteAll(Collection<?> entities) {
//		// TODO Auto-generated method stub
//		dao.deleteAll(entities);
//	}
//
//	
//	public void updateAll(Collection<?> entities) {
//		// TODO Auto-generated method stub
//		dao.updateAll(entities);
//	}
//
//	
//	public void saveOrUpdateAll(Collection<?> entities) {
//		// TODO Auto-generated method stub
//		dao.saveOrUpdateAll(entities);
//	}
//
//	
//	public <T> T get(Class<T> entityClass, Serializable id) {
//		// TODO Auto-generated method stub
//		return dao.get(entityClass, id);
//	}
//
//	
//	public <T> T get(CharSequence queryString, Object... params) {
//		// TODO Auto-generated method stub
//		return dao.get(queryString, params);
//	}
//
//	
//	public <T> T get(CharSequence queryString, Map<String, Object> params) {
//		// TODO Auto-generated method stub
//		return dao.get(queryString, params);
//	}
//
//	
//	public <T> List<T> findList(CharSequence queryString, Object... params) {
//		// TODO Auto-generated method stub
//		return dao.findList(queryString, params);
//	}
//
//	
//	public <T> List<T> findList(CharSequence queryString,
//			Map<String, Object> params) {
//		// TODO Auto-generated method stub
//		return dao.findList(queryString, params);
//	}
//
//	
//	public <T> Pagination<T> findPagination(CharSequence queryString,
//			int pageIndex, int pageSize, Object... params) {
//		// TODO Auto-generated method stub
//		return dao.findPagination(queryString, pageIndex, pageSize, params);
//	}
//
//	
//	public <T> Pagination<T> findPagination(CharSequence queryString,
//			Map<String, Object> params, int pageIndex, int pageSize) {
//		// TODO Auto-generated method stub
//		return dao.findPagination(queryString, params, pageIndex, pageSize);
//	}
//
//	
//	public <T> Pagination<T> findPagination(CharSequence queryString,
//			CharSequence countString, int pageIndex, int pageSize,
//			Object... params) {
//		// TODO Auto-generated method stub
//		return dao.findPagination(queryString, countString, pageIndex, pageSize,
//				params);
//	}
//
//	
//	public <T> Pagination<T> findPagination(CharSequence queryString,
//			CharSequence countString, Map<String, Object> params,
//			int pageIndex, int pageSize) {
//		// TODO Auto-generated method stub
//		return dao.findPagination(queryString, countString, params, pageIndex,
//				pageSize);
//	}
//
//	
//	public <T> Pagination<T> findSqlPagination(CharSequence queryString,
//			CharSequence countString, Map<String, Object> params,
//			int pageIndex, int pageSize) {
//		// TODO Auto-generated method stub
//		return dao.findSqlPagination(queryString, countString, params, pageIndex,
//				pageSize);
//	}
//
//	
//	public Object executeQuery(HibernateHandler handler) {
//		// TODO Auto-generated method stub
//		return dao.executeQuery(handler);
//	}
//
//	
//	public void execute(String hql) {
//		// TODO Auto-generated method stub
//		dao.execute(hql);
//	}
//
//	
//	public void execute(HibernateHandler handler) {
//		// TODO Auto-generated method stub
//		dao.execute(handler);
//	}
//
//	
//	public void executeSql(String sql) {
//		// TODO Auto-generated method stub
//		dao.executeSql(sql);
//	}
//
//	
//	public int executeSqlUpdate(String sql) {
//		// TODO Auto-generated method stub
//		return dao.executeSqlUpdate(sql);
//	}
//
//	
//	public int executeUpdate(String hql) {
//		// TODO Auto-generated method stub
//		return dao.executeUpdate(hql);
//	}
//
//	
//	public Object executeUpdate(HibernateHandler handler) {
//		// TODO Auto-generated method stub
//		return dao.executeUpdate(handler);
//	}
//
//	
//	public void delete(Serializable id) {
//		// TODO Auto-generated method stub
//		dao.delete(id);
//	}
//
//	
//	public void delete(List<T> entitys) {
//		// TODO Auto-generated method stub
//		dao.delete(entitys);
//	}
//
//	
//	public T getById(Serializable id) {
//		// TODO Auto-generated method stub
//		return dao.getById(id);
//	}
//
//	
//	public T saveEntity(T o) {
//		// TODO Auto-generated method stub
//		return dao.saveEntity(o);
//	}
//
//	
//	public void save(List<T> list) {
//		// TODO Auto-generated method stub
//		dao.save(list);
//	}
//
//	
//	public T insert(T entity) {
//		// TODO Auto-generated method stub
//		return dao.insert(entity);
//	}
//
//	
//	public void insert(List<T> entitys) {
//		// TODO Auto-generated method stub
//		dao.insert(entitys);
//	}
//
//	
//	public void update(List<T> entitys) {
//		// TODO Auto-generated method stub
//		dao.update(entitys);
//	}
//
//	
//	public List<T> findByProperty(String name, Object value) {
//		// TODO Auto-generated method stub
//		return dao.findByProperty(name, value);
//	}
//
//	
//	public List<T> findByProperty(Map<String, Object> conditionMap) {
//		// TODO Auto-generated method stub
//		return dao.findByProperty(conditionMap);
//	}
//
//	
//	public <V> List<V> findListByMax(CharSequence queryString, int maxResults,
//			Object... params) {
//		// TODO Auto-generated method stub
//		return dao.findListByMax(queryString, maxResults, params);
//	}
//
//	
//	public <V> List<V> findListByMax(CharSequence queryString, int maxResults,
//			Map<String, Object> params) {
//		// TODO Auto-generated method stub
//		return dao.findListByMax(queryString, maxResults, params);
//	}
//	
//}
