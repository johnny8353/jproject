package com.zte.html5.sysman.noticefiles;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface NoticeFilesMapper{

	public NoticeFiles get(@Param("id")java.lang.Long id);
	
	public List<NoticeFiles> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(NoticeFiles entity);
	
	public int update(NoticeFiles entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<NoticeFiles> getPage(Map<String, Object> map);
}