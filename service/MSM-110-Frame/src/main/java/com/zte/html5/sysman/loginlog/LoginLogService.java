package com.zte.html5.sysman.loginlog;

import java.util.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *服务类 
 */
@Service
public class LoginLogService implements ILoginLogService{
	
	@Autowired
	private LoginLogMapper loginLogDAO = null;
	
	public void setLoginLogDAO(LoginLogMapper loginLogDAO) 
	{
		this.loginLogDAO = loginLogDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public LoginLog get(java.lang.Long id) throws Exception
	{
		return loginLogDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<LoginLog> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<LoginLog> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = loginLogDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return loginLogDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(LoginLog entity) throws Exception
	{
		return loginLogDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(LoginLog entity) throws Exception
	{
		return loginLogDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = loginLogDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<LoginLog> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<LoginLog> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = loginLogDAO.getPage(map);
        
        return list;	
	}
	
}