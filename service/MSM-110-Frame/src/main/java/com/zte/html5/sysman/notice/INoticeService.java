package com.zte.html5.sysman.notice;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface INoticeService{
	
	public Notice get(java.lang.Long id) throws Exception;
	
	public List<Notice> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Notice entity) throws Exception;
	
	public int update(Notice entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Notice> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}