package com.zte.html5.sysman.test1;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ITest1Service{
	
	public Test1 get(java.lang.Long id) throws Exception;
	
	public List<Test1> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Test1 entity) throws Exception;
	
	public int update(Test1 entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Test1> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}