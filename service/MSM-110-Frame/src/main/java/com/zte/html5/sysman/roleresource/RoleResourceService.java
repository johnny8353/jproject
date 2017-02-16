package com.zte.html5.sysman.roleresource;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zte.html5.sysman.resource.ResourceService;

/**
 *服务类 
 */
@Service
public class RoleResourceService implements IRoleResourceService{
	
	@Autowired
	private RoleResourceMapper roleResourceDAO = null;
	
	public void setRoleResourceDAO(RoleResourceMapper roleResourceDAO) 
	{
		this.roleResourceDAO = roleResourceDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public RoleResource get(java.lang.Long id) throws Exception
	{
		return roleResourceDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<RoleResource> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<RoleResource> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = roleResourceDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<RoleResource> getRoleResource(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<RoleResource> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = roleResourceDAO.getRoleResource(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return roleResourceDAO.delete(id);
	}
	
	/**
	 * 删除指定角色权限
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int deleteRole(java.lang.Long roleId) throws Exception
	{
		return roleResourceDAO.deleteRole(roleId);
	}
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(RoleResource entity) throws Exception
	{
		return roleResourceDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(RoleResource entity) throws Exception
	{
		return roleResourceDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = roleResourceDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<RoleResource> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<RoleResource> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = roleResourceDAO.getPage(map);
        
        return list;	
	}
	
	
	
}