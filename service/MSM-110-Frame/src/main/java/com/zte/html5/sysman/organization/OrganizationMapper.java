package com.zte.html5.sysman.organization;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface OrganizationMapper{

	public Organization get(@Param("id")java.lang.Long id);
	
	public List<Organization> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Organization entity);
	
	public int update(Organization entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Organization> getPage(Map<String, Object> map);
}