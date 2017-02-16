package com.zte.html5.sysman.noticefiles;

import java.util.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *服务类 
 */
@Service
public class NoticeFilesService implements INoticeFilesService{
	
	@Autowired
	private NoticeFilesMapper noticeFilesDAO = null;
	
	public void setNoticeFilesDAO(NoticeFilesMapper noticeFilesDAO) 
	{
		this.noticeFilesDAO = noticeFilesDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public NoticeFiles get(java.lang.Long id) throws Exception
	{
		return noticeFilesDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<NoticeFiles> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<NoticeFiles> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = noticeFilesDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return noticeFilesDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(NoticeFiles entity) throws Exception
	{
		return noticeFilesDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(NoticeFiles entity) throws Exception
	{
		return noticeFilesDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = noticeFilesDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<NoticeFiles> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<NoticeFiles> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = noticeFilesDAO.getPage(map);
        
        return list;	
	}
	
}