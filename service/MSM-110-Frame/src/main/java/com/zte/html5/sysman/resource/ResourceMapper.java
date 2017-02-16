package com.zte.html5.sysman.resource;

import java.util.*;
import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface ResourceMapper{

	public Resource get(@Param("id")java.lang.Long id);
	
	public List<Resource> getList(Map<String, Object> map);
	
	public List<Resource> getUserMenuIDs(@Param("userId")Long userId);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Resource entity);
	
	public int update(Resource entity);
	
	public int updateState(Resource entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Resource> getPage(Map<String, Object> map);
	
	public List<Resource> listSubMenuByParentId(String parentId);
	
	
 
}