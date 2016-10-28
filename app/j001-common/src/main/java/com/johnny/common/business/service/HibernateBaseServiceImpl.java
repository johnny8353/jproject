package com.johnny.common.business.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnny.common.access.dao.HibernateBaseDao;
import com.johnny.common.access.dao.HibernateHandler;
import com.johnny.common.access.dao.Pagination;

@Service
public class HibernateBaseServiceImpl<T> implements HibernateBaseService<T> {
	@Autowired
	private HibernateBaseDao<T> dao;

	public Object save(T entity) {
		
		return dao.save(entity);
	}

	public void delete(T entity) {
		
		dao.delete(entity);
	}

	public void update(T entity) {
		
		dao.update(entity);
	}

	public void saveOrUpdate(T entity) {
		
		dao.saveOrUpdate(entity);
	}

	public void saveAll(Collection<?> entities) {
		
		dao.saveAll(entities);
	}

	public void deleteAll(Collection<?> entities) {
		
		dao.deleteAll(entities);
	}

	public void updateAll(Collection<?> entities) {
		
		dao.updateAll(entities);
	}

	public void saveOrUpdateAll(Collection<?> entities) {
		
		dao.saveOrUpdateAll(entities);
	}

	public <T> T get(Serializable id) {
		return null;
	}

	public <T> T get(Object... params) {
		return null;
	}

	public <T> T get(Map<String, Object> params) {
		
		return null;
	}

	public <T> List<T> findList(Object... params) {
		return null;
	}

	public <T> List<T> findList(Map<String, Object> params) {
		return null;
	}

	public <T> Pagination<T> findPagination(int pageIndex, int pageSize,Object... params) {
		return null;
	}

	public <T> Pagination<T> findPagination(int pageIndex, int pageSize,Map<String, Object> params) {
		return null;
	}

	public Object executeQuery(HibernateHandler handler) {
		return dao.executeQuery(handler);
	}

	public void execute(String hql) {
		dao.execute(hql);
	}

	public void execute(HibernateHandler handler) {
		dao.execute(handler);
	}

	public void executeSql(String sql) {
		dao.executeSql(sql);
	}

	public int executeSqlUpdate(String sql) {
		return dao.executeSqlUpdate(sql);
	}

	public int executeUpdate(String hql) {
		return dao.executeUpdate(hql);
	}

	public Object executeUpdate(HibernateHandler handler) {
		return dao.executeUpdate(handler);
	}

	public void delete(Serializable id) {
		dao.delete(id);
	}

	public void delete(List<T> entitys) {
		dao.delete(entitys);
	}

	public T getById(Serializable id) {
		return dao.getById(id);
	}

	public T saveEntity(T o) {
		return dao.saveEntity(o);
	}

	public void save(List<T> list) {
		dao.save(list);
	}

	public T insert(T entity) {
		return dao.insert(entity);
	}

	public void insert(List<T> entitys) {
		dao.insert(entitys);
	}

	public void update(List<T> entitys) {
		dao.update(entitys);
	}

	public List<T> findByProperty(String name, Object value) {
		return dao.findByProperty(name, value);
	}

	public List<T> findByProperty(Map<String, Object> conditionMap) {
		return dao.findByProperty(conditionMap);
	}

	public <V> List<V> findListByMax(int maxResults, Object... params) {
		return null;
	}

	public <V> List<V> findListByMax(int maxResults, Map<String, Object> params) {
		return null;
	}

}
