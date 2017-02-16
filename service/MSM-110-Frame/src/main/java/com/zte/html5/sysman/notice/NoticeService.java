package com.zte.html5.sysman.notice;

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
public class NoticeService implements INoticeService{
	
	@Autowired
	private NoticeMapper noticeDAO = null;
	
	public void setNoticeDAO(NoticeMapper noticeDAO) 
	{
		this.noticeDAO = noticeDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Notice get(java.lang.Long id) throws Exception
	{
		return noticeDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Notice> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Notice> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = noticeDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return noticeDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Notice entity) throws Exception
	{
		return noticeDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Notice entity) throws Exception
	{
		return noticeDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = noticeDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Notice> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Notice> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = noticeDAO.getPage(map);
        
        return list;	
	}
	
}