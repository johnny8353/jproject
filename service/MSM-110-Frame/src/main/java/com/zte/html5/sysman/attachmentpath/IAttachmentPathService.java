package com.zte.html5.sysman.attachmentpath;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IAttachmentPathService{
	
	public AttachmentPath get(java.lang.Long id) throws Exception;
	
	public List<AttachmentPath> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(AttachmentPath entity) throws Exception;
	
	public int update(AttachmentPath entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<AttachmentPath> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}