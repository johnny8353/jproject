package com.zte.html5.sysman.attachment;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface AttachmentMapper{

	public Attachment get(@Param("id")java.lang.Long id);
	
	public List<Attachment> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Attachment entity);
	
	public int update(Attachment entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Attachment> getPage(Map<String, Object> map);
}