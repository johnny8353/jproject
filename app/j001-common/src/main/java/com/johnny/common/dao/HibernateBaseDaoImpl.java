package com.johnny.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateBaseDaoImpl<T> extends HibernateSessionDao implements
		HibernateBaseDao<T> {

	protected Class<T> entityClazz;

	@SuppressWarnings("unchecked")
	public HibernateBaseDaoImpl() {
		@SuppressWarnings("unused")
		java.lang.reflect.Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			this.entityClazz = (Class<T>) ((ParameterizedType) type)
					.getActualTypeArguments()[0];
		} else {
			this.entityClazz = null;
		}
	}

	@SuppressWarnings("unchecked")
	public Object save(Object entity) {
		return (T) getSession().save(entity);
	}

	public void delete(Object entity) {

		getSession().delete(entity);
	}

	public void update(Object entity) {

		getSession().update(entity);
	}

	public void saveOrUpdate(Object entity) {

		getSession().saveOrUpdate(entity);
	}

	public void saveAll(Collection<?> entities) {

		for (@SuppressWarnings("rawtypes")
		Iterator localIterator = entities.iterator(); localIterator.hasNext();) {
			Object entity = localIterator.next();
			getSession().save(entity);
		}
	}

	public void deleteAll(Collection<?> entities) {

		for (@SuppressWarnings("rawtypes")
		Iterator localIterator = entities.iterator(); localIterator.hasNext();) {
			Object entity = localIterator.next();
			getSession().delete(entity);
		}
	}

	public void updateAll(Collection<?> entities) {

		for (@SuppressWarnings("rawtypes")
		Iterator localIterator = entities.iterator(); localIterator.hasNext();) {
			Object entity = localIterator.next();
			getSession().update(entity);
		}
	}

	public void saveOrUpdateAll(Collection<?> entities) {

		for (@SuppressWarnings("rawtypes")
		Iterator localIterator = entities.iterator(); localIterator.hasNext();) {
			Object entity = localIterator.next();
			getSession().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T get(Class<T> entityClass, Serializable id) {

		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "hiding" })
	public <T> T get(CharSequence queryString, Object... params) {

		Query qry = getSession().createQuery(queryString.toString());
		for (int i = 0; i < params.length; ++i) {
			qry.setParameter(i, params[i]);
		}
		List list = qry.setMaxResults(1).list();
		if (list.isEmpty())
			return null;
		return (T) list.get(0);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T get(CharSequence queryString, Map<String, Object> params) {

		Query qry = getSession().createQuery(queryString.toString());
		setParameter(qry, params);
		@SuppressWarnings("rawtypes")
		List list = qry.setMaxResults(1).list();
		if (list.isEmpty())
			return null;
		return (T) list.get(0);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> findList(CharSequence queryString, Object... params) {
		Query query = getSession().createQuery(queryString.toString());
		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> findList(CharSequence queryString,
			Map<String, Object> params) {
		Query query = getSession().createQuery(queryString.toString());
		setParameter(query, params);
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> Pagination<T> findPagination(CharSequence queryString,
			int pageIndex, int pageSize, Object... params) {
		Query query = getSession().createQuery(queryString.toString());

		if ((pageSize > 0) && (pageIndex > 0)) {
			query.setFirstResult((pageIndex < 2) ? 0 : (pageIndex - 1)
					* pageSize);
			query.setMaxResults(pageSize);
		}

		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i, params[i]);
		}
		@SuppressWarnings("rawtypes")
		List items = query.list();
		long rowsCount = 0L;

		if ((pageSize > 0) && (pageIndex > 0)) {
			String hql = parseSelectCount(queryString.toString());
			rowsCount = ((Long) get(hql, params)).longValue();
		} else {
			rowsCount = items.size();
		}

		@SuppressWarnings("rawtypes")
		Pagination pagination = new Pagination(pageIndex, pageSize, rowsCount);
		pagination.setItems(items);
		return pagination;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> Pagination<T> findPagination(CharSequence queryString,
			Map<String, Object> params, int pageIndex, int pageSize) {
		Query query = getSession().createQuery(queryString.toString());

		if ((pageSize > 0) && (pageIndex > 0)) {
			query.setFirstResult((pageIndex < 2) ? 0 : (pageIndex - 1)
					* pageSize);
			query.setMaxResults(pageSize);
		}

		setParameter(query, params);
		@SuppressWarnings({ "rawtypes" })
		List items = query.list();
		long rowsCount = 0L;

		if ((pageSize > 0) && (pageIndex > 0)) {
			String hql = parseSelectCount(queryString.toString());
			rowsCount = ((Long) get(hql, params)).longValue();
		} else {
			rowsCount = items.size();
		}

		@SuppressWarnings("rawtypes")
		Pagination pagination = new Pagination(pageIndex, pageSize, rowsCount);
		pagination.setItems(items);
		return pagination;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> Pagination<T> findPagination(CharSequence queryString,
			CharSequence countString, int pageIndex, int pageSize,
			Object... params) {
		Query query = getSession().createQuery(queryString.toString());

		if ((pageSize > 0) && (pageIndex > 0)) {
			query.setFirstResult((pageIndex < 2) ? 0 : (pageIndex - 1)
					* pageSize);
			query.setMaxResults(pageSize);
		}

		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i, params[i]);
		}
		@SuppressWarnings("rawtypes")
		List items = query.list();
		long rowsCount = 0L;

		if ((pageSize > 0) && (pageIndex > 0)) {
			rowsCount = ((Long) get(countString, params)).longValue();
		} else
			rowsCount = items.size();

		@SuppressWarnings("rawtypes")
		Pagination pagination = new Pagination(pageIndex, pageSize, rowsCount);
		pagination.setItems(items);
		return pagination;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> Pagination<T> findPagination(CharSequence queryString,
			CharSequence countString, Map<String, Object> params,
			int pageIndex, int pageSize) {
		Query query = getSession().createQuery(queryString.toString());

		if ((pageSize > 0) && (pageIndex > 0)) {
			query.setFirstResult((pageIndex < 2) ? 0 : (pageIndex - 1)
					* pageSize);
			query.setMaxResults(pageSize);
		}

		setParameter(query, params);
		@SuppressWarnings("rawtypes")
		List items = query.list();
		long rowsCount = 0L;

		if ((pageSize > 0) && (pageIndex > 0)) {
			rowsCount = ((Long) get(countString, params)).longValue();
		} else
			rowsCount = items.size();

		@SuppressWarnings("rawtypes")
		Pagination pagination = new Pagination(pageIndex, pageSize, rowsCount);
		pagination.setItems(items);
		return pagination;
	}

	@SuppressWarnings({ "serial", "unchecked", "hiding" })
	public <T> Pagination<T> findSqlPagination(CharSequence queryString,
			final CharSequence countString, final Map<String, Object> params,
			int pageIndex, int pageSize) {
		SQLQuery query = getSession().createSQLQuery(queryString.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		if ((pageSize > 0) && (pageIndex > 0)) {
			query.setFirstResult((pageIndex < 2) ? 0 : (pageIndex - 1)
					* pageSize);
			query.setMaxResults(pageSize);
		}
		if ((params != null) && (!(params.isEmpty()))) {
			setParameter(query, params);
		}
		@SuppressWarnings("rawtypes")
		List items = query.list();
		BigInteger rowsCount = BigInteger.valueOf(0L);

		if ((pageSize > 0) && (pageIndex > 0)) {
			rowsCount = (BigInteger) executeQuery(new HibernateHandler() {
				public Object doInHibernate(Session session) {
					SQLQuery query = session.createSQLQuery(countString
							.toString());
					if ((params != null) && (!(params.isEmpty()))) {
						setParameter(query, params);
					}
					return query.uniqueResult();
				}
			});
		}

		@SuppressWarnings("rawtypes")
		Pagination pagination = new Pagination(pageIndex, pageSize,
				rowsCount.intValue());
		pagination.setItems(items);
		return pagination;
	}

	public Object executeQuery(HibernateHandler handler) {
		return handler.doInHibernate(getSession());
	}

	public void execute(String hql) {
		executeUpdate(hql);
	}

	public void execute(HibernateHandler handler) {
		executeUpdate(handler);
	}

	public void executeSql(String sql) {
		executeSqlUpdate(sql);
	}

	public int executeSqlUpdate(String sql) {
		return getSession().createSQLQuery(sql).executeUpdate();
	}

	public int executeUpdate(String hql) {
		return getSession().createQuery(hql).executeUpdate();
	}

	public Object executeUpdate(HibernateHandler handler) {
		return handler.doInHibernate(getSession());
	}

	protected Query setParameter(Query query, Map<String, Object> parameterMap) {
		if(parameterMap==null) return query;
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = parameterMap.keySet().iterator(); iterator
				.hasNext();) {
			String key = (String) iterator.next();
			query.setParameter(key, parameterMap.get(key));
		}
		return query;
	}

	protected boolean followWithWord(String s, String sub, int pos) {
		int i = 0;
		for (; (pos < s.length()) && (i < sub.length()); ++i) {
			if (s.charAt(pos) != sub.charAt(i))
				return false;
			++pos;
		}

		if (i < sub.length()) {
			return false;
		}

		if (pos >= s.length()) {
			return true;
		}
		return (!(isAlpha(s.charAt(pos))));
	}

	protected String parseSelectCount(String queryString) {
		String hql = queryString.toLowerCase();
		int noBlankStart = 0;
		for (int len = hql.length(); noBlankStart < len; ++noBlankStart) {
			if (hql.charAt(noBlankStart) > ' ') {
				break;
			}
		}

		int pair = 0;

		if (!(followWithWord(hql, "select", noBlankStart))) {
			pair = 1;
		}
		int fromPos = -1;
		for (int i = noBlankStart; i < hql.length();) {
			if (followWithWord(hql, "select", i)) {
				++pair;
				i += "select".length();
			} else if (followWithWord(hql, "from", i)) {
				--pair;
				if (pair == 0) {
					fromPos = i;
					break;
				}
				i += "from".length();
			} else {
				++i;
			}
		}
		if (fromPos == -1) {
			throw new IllegalArgumentException(
					"parse count sql error, check your sql/hql");
		}

		String countHql = "select count(*) " + queryString.substring(fromPos);
		return countHql;
	}

	protected boolean isAlpha(char c) {
		return ((c == '_') || (('0' <= c) && (c <= '9'))
				|| (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')));
	}

	public void delete(Serializable id) {
		T entity = getById(id);
		delete(entity);
	}

	public void delete(List<T> entitys) {
		for (T entity : entitys) {
			delete(entity);
		}
	}

	public T getById(Serializable id) {
		if (id == null)
			return null;

		return (T) get(entityClazz, id);
	}

	@Override
	public T saveEntity(T o) {
		saveOrUpdate(o);
		return o;
	}

	@Override
	public void save(List<T> list) {
		saveOrUpdateAll(list);
	}

	@Override
	public T insert(T entity) {
		save(entity);
		return entity;
	}

	@Override
	public void insert(List<T> entitys) {
		for (T entity : entitys) {
			save(entity);
		}
	}

	@Override
	public void update(List<T> entitys) {
		for (T entity : entitys) {
			update(entity);
		}
	}

	@Override
	public List<T> findByProperty(String name, Object value) {
		String hql = "from  " + entityClazz.getSimpleName() + " where " + name
				+ "=? ";
		return findList(hql, value);
	}

	@Override
	public List<T> findByProperty(Map<String, Object> conditionMap) {
		StringBuilder hql = new StringBuilder();
		hql.append("from  " + entityClazz.getSimpleName());
		if (!conditionMap.isEmpty()) {
			Iterator<String> it = conditionMap.keySet().iterator();
			String key = it.next();
			hql.append(" where  " + key + "=:" + key);
			while (it.hasNext()) {
				key = it.next();
				hql.append(" and  " + key + "=:" + key);
			}
		}
		return findList(hql.toString(), conditionMap);
	}

	@Override
	public <V> List<V> findListByMax(final CharSequence queryString,
			final int maxResults, final Object... params) {
		@SuppressWarnings({ "unchecked", "serial" })
		List<V> list = (List<V>) executeQuery(new HibernateHandler() {
			@Override
			public List<V> doInHibernate(Session paramSession) {
				try {
					Query query = paramSession.createQuery(queryString
							.toString());
					for (int i = 0; i < params.length; ++i) {
						query.setParameter(i, params[i]);
					}
					return query.setMaxResults(maxResults).list();
				} catch (RuntimeException re) {
					throw re;
				}
			}
		});
		return list;
	}

	@Override
	public <V> List<V> findListByMax(final CharSequence queryString,
			final int maxResults, final Map<String, Object> params) {
		@SuppressWarnings({ "unchecked", "serial" })
		List<V> list = (List<V>) executeQuery(new HibernateHandler() {
			@Override
			public List<V> doInHibernate(Session paramSession) {
				try {
					Query query = paramSession.createQuery(queryString
							.toString());
					for (Iterator<String> iterator = params.keySet().iterator(); iterator
							.hasNext();) {
						String key = iterator.next();
						query.setParameter(key, params.get(key));
					}
					return query.setMaxResults(maxResults).list();
				} catch (RuntimeException re) {
					throw re;
				}
			}

		});
		return list;
	}
}
