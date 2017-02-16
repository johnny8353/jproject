package com.zte.html5.sysman.tenant;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface TenantMapper{

	public Tenant get(@Param("id")java.lang.Long id);
	
	public List<Tenant> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Tenant entity);
	
	public int update(Tenant entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Tenant> getPage(Map<String, Object> map);
}