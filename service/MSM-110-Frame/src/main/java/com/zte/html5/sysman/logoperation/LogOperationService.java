package com.zte.html5.sysman.logoperation;

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
public class LogOperationService implements ILogOperationService{
	
	@Autowired
	private LogOperationMapper logOperationDAO = null;
	
	public void setLogOperationDAO(LogOperationMapper logOperationDAO) 
	{
		this.logOperationDAO = logOperationDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public LogOperation get(java.lang.Long id) throws Exception
	{
		return logOperationDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<LogOperation> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<LogOperation> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = logOperationDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return logOperationDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(LogOperation entity) throws Exception
	{
		return logOperationDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(LogOperation entity) throws Exception
	{
		return logOperationDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = logOperationDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<LogOperation> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<LogOperation> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = logOperationDAO.getPage(map);
        
        return list;	
	}
	
}