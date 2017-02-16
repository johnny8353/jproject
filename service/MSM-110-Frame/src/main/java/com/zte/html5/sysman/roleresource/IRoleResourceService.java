package com.zte.html5.sysman.roleresource;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IRoleResourceService{
	
	public RoleResource get(java.lang.Long id) throws Exception;
	
	public List<RoleResource> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<RoleResource> getRoleResource(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int deleteRole(java.lang.Long roleId) throws Exception;
	
	public int insert(RoleResource entity) throws Exception;
	
	public int update(RoleResource entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<RoleResource> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}