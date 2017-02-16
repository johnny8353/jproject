package com.zte.html5.sysman.userrole;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface UserRoleMapper{

	public UserRole get(@Param("id")java.lang.Long id);
	
	public List<UserRole> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int deleteByRole(@Param("roleId")java.lang.Long roleId);
	
	public int insert(UserRole entity);
	
	public int insertBatch(List<UserRole> entitys);
	
	public int update(UserRole entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<UserRole> getPage(Map<String, Object> map);
}