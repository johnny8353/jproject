package com.zte.html5.sysman.userrole;

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
public class UserRoleService implements IUserRoleService{
	
	@Autowired
	private UserRoleMapper userRoleDAO = null;
	
	public void setUserRoleDAO(UserRoleMapper userRoleDAO) 
	{
		this.userRoleDAO = userRoleDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public UserRole get(java.lang.Long id) throws Exception
	{
		return userRoleDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<UserRole> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<UserRole> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = userRoleDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return userRoleDAO.delete(id);
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int deleteByRole(java.lang.Long roleId) throws Exception
	{
		return userRoleDAO.deleteByRole(roleId);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(UserRole entity) throws Exception
	{
		return userRoleDAO.insert(entity);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insertBatch(List<UserRole> entitys) throws Exception
	{
		return userRoleDAO.insertBatch(entitys);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(UserRole entity) throws Exception
	{
		return userRoleDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = userRoleDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<UserRole> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<UserRole> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = userRoleDAO.getPage(map);
        
        return list;	
	}
	
	/**
	 * 先删除再重新写入
	 * @param userRoles
	 * @return
	 * @throws Exception
	 */
	public int saveEditByRole(Long roleId, List<UserRole> userRoles)throws Exception
	{
		int result = deleteByRole(roleId);
		if(!userRoles.isEmpty()){
			result = insertBatch(userRoles);
		}
		return result;
	}
}