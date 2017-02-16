package com.zte.html5.sysman.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zte.html5.sysman.user.User;

/**
 *服务类 
 */
@Service
public class ResourceService implements IResourceService{
	
	@Autowired
	private ResourceMapper resourceDAO = null;
	
	public void setResourceDAO(ResourceMapper resourceDAO) 
	{
		this.resourceDAO = resourceDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public com.zte.html5.sysman.resource.Resource get(java.lang.Long id) throws Exception
	{
		return resourceDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<com.zte.html5.sysman.resource.Resource> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<com.zte.html5.sysman.resource.Resource> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = resourceDAO.getList(map);
        
        return list;
	}
	
	/**
	 *获取用户有权限的菜单ID集合
	 */
	public List<Resource> getUserMenuIDs(Long userId) throws Exception
	{
		List<com.zte.html5.sysman.resource.Resource> list = null;
        
        list = resourceDAO.getUserMenuIDs(userId);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return resourceDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(com.zte.html5.sysman.resource.Resource entity) throws Exception
	{
		return resourceDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(com.zte.html5.sysman.resource.Resource entity) throws Exception
	{
		return resourceDAO.update(entity);
	}
	
	/**
	 * 修改状态
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int updateState(com.zte.html5.sysman.resource.Resource entity) throws Exception
	{
		return resourceDAO.updateState(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = resourceDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<com.zte.html5.sysman.resource.Resource> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<com.zte.html5.sysman.resource.Resource> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = resourceDAO.getPage(map);
        
        return list;	
	}
	
	
	/**
	 * 获取所有菜单并填充每个菜单的子菜单列表(系统菜单列表)(递归处理)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<com.zte.html5.sysman.resource.Resource> listAllMenuQx(String MENU_ID) throws Exception {
		List<com.zte.html5.sysman.resource.Resource> menuList = this.listSubMenuByParentId(MENU_ID);
	 
	 
		for(com.zte.html5.sysman.resource.Resource menu : menuList){
		
			menu.setSubMenu(this.listAllMenuQx(menu.getId().toString()));
			// menu.setTarget("treeFrame");
		}
		return menuList;
	}

	/**
	 * 通过ID获取其子一级菜单
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<com.zte.html5.sysman.resource.Resource> listSubMenuByParentId(String parentId) throws Exception {
		List<com.zte.html5.sysman.resource.Resource> list = resourceDAO.listSubMenuByParentId(parentId);
		return list;
	}
 
	/**
	 * 根据用户和组织验证服务请求地址是否可以访问
	 * @param serverUrl 服务请求地址
	 * @param user 用户对象
	 * @param orgId 组织ID
	 * @return
	 */
	public boolean validationServiceRequest(String serverUrl, User user, String orgId) {
		// 根据服务地址查询是否有可配置的资源对象
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("resourceValue", serverUrl);
		map.put("resourceType", "'2'"); // 资源类型为服务
		map.put("enableFlag", "Y");
		List<Resource> lsResources = resourceDAO.getList(map);
		List<Resource> lsResourcesReq = new ArrayList<Resource>();
		
		for (Resource re : lsResources){
			// 正则表达式规则
			String regEx = re.getResourceValue() + '*';
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(serverUrl);
			if (matcher.find()){
				lsResourcesReq.add(re);
			}
		}
		
		// 如果没找到服务地址的资源对象，不可以访问服务，直接返回false
		if (lsResourcesReq == null || lsResourcesReq.size() == 0){
			return false;
		}
		
		for (Resource resource : lsResourcesReq){
			// 如果服务资源对象需要鉴权
			if (resource.getPrivilegeFlag().equals("Y")){
				// 如果用户为空，不可以访问服务，直接返回false
				if (user == null){
					return false;
				}
				
				// 判断用户是否具有访问该服务的权限
				map = new HashMap<String, Object>();
				map.put("id", resource.getId());
				map.put("fUserId", user.getId());
				map.put("fOrgId", orgId);
				map.put("enableFlag", "Y");
				
				lsResources = resourceDAO.getList(map);
				
				// 如果该用户没有授权该服务，不可以访问服务，直接返回false
				if (lsResources == null || lsResources.size() == 0){
					return false;
				}
			} 
		}
		
		return true;
	}
}