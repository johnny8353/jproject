package com.zte.html5.sysman.role;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface RoleMapper{

	public Role get(@Param("id")java.lang.Long id);
	
	public List<Role> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Role entity);
	
	public int update(Role entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Role> getPage(Map<String, Object> map);
}