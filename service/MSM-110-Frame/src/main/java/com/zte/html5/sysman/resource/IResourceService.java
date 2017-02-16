package com.zte.html5.sysman.resource;

import java.util.*;
import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zte.html5.sysman.user.User;

 

/**
 *服务接口类 
 */
public interface IResourceService{
	
	public Resource get(java.lang.Long id) throws Exception;
	
	public List<Resource> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Resource> getUserMenuIDs(Long userId) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Resource entity) throws Exception;
	
	public int update(Resource entity) throws Exception;
	
	public int updateState(Resource entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Resource> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
	/**
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<Resource> listAllMenuQx(String MENU_ID) throws Exception;
	
	/**
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> listSubMenuByParentId(String parentId)throws Exception;
	
	/**
	 * 根据用户和组织验证服务请求地址是否可以访问
	 * @param serverUrl 服务请求地址
	 * @param user 用户对象
	 * @param orgId 组织ID
	 * @return
	 */
	public boolean validationServiceRequest(String serverUrl, User user, String orgId);
}