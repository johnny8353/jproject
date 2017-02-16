package com.zte.html5.sysman.sms;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ISmsService{
	
	public Sms get(java.lang.Long id) throws Exception;
	
	public List<Sms> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Sms entity) throws Exception;
	
	public int update(Sms entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Sms> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}