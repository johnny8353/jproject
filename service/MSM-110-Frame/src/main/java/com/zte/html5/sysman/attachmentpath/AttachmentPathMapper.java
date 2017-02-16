package com.zte.html5.sysman.attachmentpath;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface AttachmentPathMapper{

	public AttachmentPath get(@Param("id")java.lang.Long id);
	
	public List<AttachmentPath> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(AttachmentPath entity);
	
	public int update(AttachmentPath entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<AttachmentPath> getPage(Map<String, Object> map);
}