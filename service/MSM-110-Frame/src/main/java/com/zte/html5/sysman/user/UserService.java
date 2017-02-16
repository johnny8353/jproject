package com.zte.html5.sysman.user;

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
public class UserService implements IUserService{
	
	@Autowired
	private UserMapper userDAO = null;
	
	public void setUserDAO(UserMapper userDAO) 
	{
		this.userDAO = userDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public User get(java.lang.Long id) throws Exception
	{
		return userDAO.get(id);
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public User getByAccount(java.lang.String account) throws Exception
	{
		return userDAO.getByAccount(account);
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public User getByToken(java.lang.String token) throws Exception
	{
		return userDAO.getByToken(token);
	}
		
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<User> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<User> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = userDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<User> getRoleUserList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<User> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		
        list = userDAO.getRoleUserList(map);
        
        return list;
	}
	
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return userDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(User entity) throws Exception
	{
		return userDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(User entity) throws Exception
	{
		return userDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = userDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<User> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<User> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = userDAO.getPage(map);
        
        return list;	
	}
	
}