package com.zte.html5.sysman.loginlog;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ILoginLogService{
	
	public LoginLog get(java.lang.Long id) throws Exception;
	
	public List<LoginLog> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(LoginLog entity) throws Exception;
	
	public int update(LoginLog entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<LoginLog> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}