package com.zte.html5.sysman.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zte.html5.frame.common.BusiException;
import com.zte.html5.frame.common.FormData;
import com.zte.html5.frame.common.PageRows;
import com.zte.html5.frame.common.ServiceData;
import com.zte.html5.frame.common.ValidationException;
import com.zte.html5.sysman.function.IFunctionService;
import com.zte.html5.sysman.roleresource.IRoleResourceService;
import com.zte.html5.sysman.roleresource.RoleResource;
import com.zte.html5.sysman.user.User;

/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/sysman/Resource")
public class ResourceController {
	// 日志对象
	private static final Logger log = Logger.getLogger(ResourceController.class);

	// 服务对象，SPRING自动装配
	@Autowired
	IResourceService resourceService = null;
	@Autowired
	IRoleResourceService roleResourceService = null;
	@Autowired
	IFunctionService functionService = null;

	// 服务对象，SPRING自动装配	
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	// 服务对象，SPRING自动装配
	public void setRoleResourceService(IRoleResourceService roleResourceService) {
		this.roleResourceService = roleResourceService;
	}

	// 服务对象，SPRING自动装配
	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}

	/**
	 * 根据主键获取实体对象
	 */
	@RequestMapping(value = "/get.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody Resource entity) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		// 业务操作可以不捕获异常,由统一的异常处理方法处理
		Resource resource = resourceService.get(entity.getId());

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(resource);

		return ret;
	}

	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 * 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value = "/getList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getList(HttpServletRequest request, @RequestBody FormData<Resource> from) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();

		// 设置查询条件
		map.put("id", from.getBo().getId());
		map.put("parentId", from.getBo().getParentId());

		// System.out.println(from.getBo().getParentId());

		List<Resource> list = resourceService.getList(map, from.getSort(), from.getOrder());

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(list);

		return ret;
	}

	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 * 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value = "/getMenuList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getMenuList(HttpServletRequest request, @RequestBody FormData<Resource> from) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();

		// 设置查询条件
		map.put("id", from.getBo().getId());
		List<Resource> list = resourceService.listAllMenuQx("0");

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(list);

		return ret;
	}

	@RequestMapping(value = "/getMenusPageJSON.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getMenusPageJSON(HttpServletRequest request, @RequestBody FormData<Resource> from)
			throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();
		String userId = "";
		// 获取登陆用户对象
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			log.info("当前用户ID:" + user.getId());

			userId = user.getId().toString();
			map.put("fUserId", userId);
			
			if (request.getAttribute("orgId") != null) {
				map.put("fOrgId", request.getAttribute("orgId"));
			} else {
				map.put("fOrgId", user.getOrgId());
			}			
		} 
			
		map.put("resourceType", "'0', '1'");
		
		map.put("enableFlag", "Y");

		List<Resource> list = resourceService.getList(map, from.getSort(), from.getOrder());

		List<ResMenu> lsMenus = getTreeMenus(list);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(lsMenus);

		return ret;
	}

	private List<ResMenu> getTreeMenus(List<Resource> list) {
		List<ResMenu> lsMenus = new ArrayList<ResMenu>();
		AddMenus(lsMenus, list);
		return lsMenus;
	}

	private void AddMenus(List<ResMenu> lsMenus, List<Resource> list) {
		for (Resource res : list) {
			ResMenu resMenu = new ResMenu();
			if (res.getParentId().toString().equals("0")) {
				resMenu.setId(res.getId().toString());
				resMenu.setIcon(res.getIconValue());
				resMenu.setText(res.getResourceName());
				AddChildMenus(resMenu, list);
				lsMenus.add(resMenu);
			}
		}
	}

	private void AddChildMenus(ResMenu resMenu, List<Resource> list) {
		for (Resource res : list) {
			if (resMenu.getId().equals(res.getParentId().toString())) {
				ResMenu childMenu = new ResMenu();
				childMenu.setId(res.getId().toString());
				childMenu.setIcon(res.getIconValue());
				childMenu.setUrl(res.getResourceValue());
				childMenu.setText(res.getResourceName());
				AddChildMenus(childMenu, list);
				resMenu.getMenus().add(childMenu);
			}
		}
	}

	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 * 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value = "/getMenus.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getMenus(HttpServletRequest request, @RequestBody FormData<Resource> from) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();

		// 获取登陆用户对象
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			map.put("fUserId", user.getId().toString());
			
			if (request.getAttribute("orgId") != null) {
				map.put("fOrgId", request.getAttribute("orgId"));
			} else {
				map.put("fOrgId", user.getOrgId());
			}			
		} 
		map.put("resourceType", from.getBo().getResourceType());
		map.put("enableFlag", "Y");
		List<Resource> list = resourceService.getList(map, from.getSort(), from.getOrder());

		if (from.getBo().getId() != null) {
			
			// 设置查询条件
			map.put("roleId", from.getBo().getId());
			List<RoleResource> rRourceList = roleResourceService.getList(map, from.getSort(), from.getOrder());
			
			Map<Long, Boolean> rMap = new HashMap<Long, Boolean>();
			for(RoleResource rResource:rRourceList){
				rMap.put( rResource.getResourceId(), true);
			}
			
			for(Resource resource:list){
				if (rMap.get(resource.getId()) != null)
					resource.setChecked(true);
			}
			
			/*
			Resource resource = new Resource();
			RoleResource rResource = new RoleResource();
			for (int i = 0; i < list.size(); i++) {
				resource = list.get(i);
				for (int j = 0; j < rRourceList.size(); j++) {
					rResource = rRourceList.get(j);
					if (resource.getId() == rResource.getResourceId()) {
						list.get(i).setChecked(true);
						break;
					} else {
						list.get(i).setChecked(false);
					}

				}
			}
			*/
		}
		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(list);

		return ret;
	}

	/**
	 * 删除指定记录
	 */
	@RequestMapping(value = "/delete.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody Resource entity) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", entity.getId());

		if (resourceService.getList(map, "", "").size() > 0) {
			throw new Exception("此业务菜单下包含系统菜单,不能删除！");
		}

		map.put("resourceId", entity.getId());

		if (functionService.getList(map, "", "").size() > 0) {
			throw new Exception("此系统菜单下包含功能按钮,不能删除！");
		}

		int count = resourceService.delete(entity.getId());

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));

		return ret;
	}

	/**
	 * 新增指定记录
	 */
	@RequestMapping(value = "/insert.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody Resource entity, BindingResult result)
			throws Exception {
		// 检查数据效验结果,如果有验证错误,抛出数据验证异常
		if (result != null && result.hasErrors()) {
			throw new ValidationException(result);
		}

		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			entity.setCreatedBy(user.getId());
		}

		// 业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = resourceService.insert(entity);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));

		return ret;
	}

	/**
	 * 修改指定记录
	 */
	@RequestMapping(value = "/update.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody Resource entity, BindingResult result)
			throws Exception {
		// 检查数据效验结果,如果有验证错误,抛出数据验证异常
		if (result != null && result.hasErrors()) {
			throw new ValidationException(result);
		}

		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			entity.setLastUpdatedBy(user.getId());
		}

		// 业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = resourceService.update(entity);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));

		return ret;
	}

	/**
	 * 修改指定记录
	 */
	@RequestMapping(value = "/updateState.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData updateState(HttpServletRequest request, @Valid @RequestBody Resource entity,
			BindingResult result) throws Exception {
		// 检查数据效验结果,如果有验证错误,抛出数据验证异常
		if (result != null && result.hasErrors()) {
			throw new ValidationException(result);
		}

		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", entity.getId());

		if (resourceService.getList(map, "", "").size() > 0) {
			throw new Exception("此业务菜单下包含系统菜单,不能更改状态！");
		}

		map.put("resourceId", entity.getId());

		if (functionService.getList(map, "", "").size() > 0) {
			throw new Exception("此系统菜单下包含功能按钮,不能更改状态！");
		}

		// 业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = resourceService.updateState(entity);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));

		return ret;
	}

	/**
	 * 获取符合条件的分页记录，包括当页数据/记录总数, 先按指定属性排序,再分页
	 */
	@RequestMapping(value = "/getPage.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<Resource> form) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		Map<String, Object> map = new HashMap<String, Object>();

		// 设置查询条件
		map.put("id", form.getBo().getId());
		long total = resourceService.getCount(map, form.getSort(), form.getOrder());
		List<Resource> list = resourceService.getPage(map, form.getSort(), form.getOrder(), form.getPage(),
				form.getRows());

		PageRows<Resource> page = new PageRows<Resource>();
		page.setCurrent(form.getPage());
		page.setTotal(total);
		page.setRows(list);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(page);

		return ret;
	}

	// 异常处理方法
	@ResponseBody
	@ExceptionHandler
	public ServiceData exception(HttpServletRequest request, Exception e) {
		// 添加自己的异常处理逻辑，如日志记录
		log.error("ResourceController 捕获到异常：", e);

		ServiceData ret = new ServiceData();

		// 根据不同的异常类型进行不同处理
		// 包括效验异常\业务异常\服务器异常等
		if (e instanceof ValidationException) {
			ret.setCode(request, ServiceData.RetCode.ValidationError);
			// ret.setBo(e);
			// ret.setBo(((ValidationException) e).getResult().getAllErrors());
			ret.setBo(((ValidationException) e).getResultMap());
		} else if (e instanceof BusiException) {
			ret.setCode(request, ServiceData.RetCode.BusinessError);
			ret.setBo(e);
		} else {
			ret.setCode(request, ServiceData.RetCode.ServerError);
			// ret.setBo(ex);
			ret.setBo(e.getMessage());
		}

		// request.setAttribute("exceptionMessage", e.getMessage());

		return ret;
	}

}