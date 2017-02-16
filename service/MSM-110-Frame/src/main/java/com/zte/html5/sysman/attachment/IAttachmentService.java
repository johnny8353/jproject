package com.zte.html5.sysman.attachment;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IAttachmentService{
	
	public Attachment get(java.lang.Long id) throws Exception;
	
	public List<Attachment> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Attachment entity) throws Exception;
	
	public int update(Attachment entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Attachment> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}