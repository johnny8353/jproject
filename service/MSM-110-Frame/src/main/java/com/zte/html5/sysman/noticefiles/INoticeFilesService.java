package com.zte.html5.sysman.noticefiles;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface INoticeFilesService{
	
	public NoticeFiles get(java.lang.Long id) throws Exception;
	
	public List<NoticeFiles> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(NoticeFiles entity) throws Exception;
	
	public int update(NoticeFiles entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<NoticeFiles> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}