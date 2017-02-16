package com.zte.html5.sysman.dictionary;

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
public class DictionaryService implements IDictionaryService{
	
	@Autowired
	private DictionaryMapper dictionaryDAO = null;
	
	public void setDictionaryDAO(DictionaryMapper dictionaryDAO) 
	{
		this.dictionaryDAO = dictionaryDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Dictionary get(java.lang.Long id) throws Exception
	{
		return dictionaryDAO.get(id);
	}
	
	/**
	 * 根据字典代码和字典组织ID获取组织字典对象 
	 */
	public Dictionary getByOrgId(Map<String, Object> map) throws Exception
	{
		return dictionaryDAO.getByOrgId(map);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Dictionary> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Dictionary> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = dictionaryDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return dictionaryDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Dictionary entity) throws Exception
	{
		return dictionaryDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Dictionary entity) throws Exception
	{
		return dictionaryDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = dictionaryDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Dictionary> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Dictionary> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = dictionaryDAO.getPage(map);
        
        return list;	
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Dictionary> getMyOrgList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Dictionary> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);   
        list = dictionaryDAO.getMyOrgList(map);
        
        return list;
	}
	
	
}