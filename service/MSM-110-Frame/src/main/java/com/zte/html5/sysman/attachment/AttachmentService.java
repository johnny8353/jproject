package com.zte.html5.sysman.attachment;

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
public class AttachmentService implements IAttachmentService{
	
	@Autowired
	private AttachmentMapper attachmentDAO = null;
	
	public void setAttachmentDAO(AttachmentMapper attachmentDAO) 
	{
		this.attachmentDAO = attachmentDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Attachment get(java.lang.Long id) throws Exception
	{
		return attachmentDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Attachment> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Attachment> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = attachmentDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return attachmentDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Attachment entity) throws Exception
	{
		return attachmentDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Attachment entity) throws Exception
	{
		return attachmentDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = attachmentDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Attachment> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Attachment> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = attachmentDAO.getPage(map);
        
        return list;	
	}
	
}