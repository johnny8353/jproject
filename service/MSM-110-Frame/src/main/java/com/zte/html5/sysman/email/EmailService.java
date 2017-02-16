package com.zte.html5.sysman.email;

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
public class EmailService implements IEmailService{
	
	@Autowired
	private EmailMapper emailDAO = null;
	
	public void setEmailDAO(EmailMapper emailDAO) 
	{
		this.emailDAO = emailDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Email get(java.lang.Long id) throws Exception
	{
		return emailDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Email> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Email> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = emailDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return emailDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Email entity) throws Exception
	{
		return emailDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Email entity) throws Exception
	{
		return emailDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = emailDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Email> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Email> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = emailDAO.getPage(map);
        
        return list;	
	}
	
}