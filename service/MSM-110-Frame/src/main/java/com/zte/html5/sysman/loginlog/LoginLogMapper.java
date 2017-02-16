package com.zte.html5.sysman.loginlog;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface LoginLogMapper{

	public LoginLog get(@Param("id")java.lang.Long id);
	
	public List<LoginLog> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(LoginLog entity);
	
	public int update(LoginLog entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<LoginLog> getPage(Map<String, Object> map);
}