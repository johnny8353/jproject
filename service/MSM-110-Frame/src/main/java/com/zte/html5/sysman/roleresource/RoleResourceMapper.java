package com.zte.html5.sysman.roleresource;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface RoleResourceMapper{

	public RoleResource get(@Param("id")java.lang.Long id);
	
	public List<RoleResource> getList(Map<String, Object> map);
	
	public List<RoleResource> getRoleResource(Map<String, Object> map); 
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int deleteRole(@Param("roleId")java.lang.Long roleId);
	
	public int insert(RoleResource entity);
	
	public int update(RoleResource entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<RoleResource> getPage(Map<String, Object> map);
	
}