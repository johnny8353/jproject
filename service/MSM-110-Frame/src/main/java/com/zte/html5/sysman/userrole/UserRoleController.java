package com.zte.html5.sysman.userrole;

import java.util.ArrayList;
import java.util.Date;
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
import com.zte.html5.sysman.resource.Resource;
import com.zte.html5.sysman.role.Role;
import com.zte.html5.sysman.user.User;


/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/sysman/UserRole")
public class UserRoleController{
	//日志对象
	private static final Logger log = Logger.getLogger(UserRoleController.class);
	
	//服务对象，SPRING自动装配
	@Autowired
	IUserRoleService userRoleService = null;

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/get.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody UserRole entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		UserRole userRole = userRoleService.get(entity.getId());
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(userRole);		    
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getList(HttpServletRequest request, @RequestBody FormData<UserRole>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", from.getBo().getId());
	    List<UserRole> list = userRoleService.getList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 删除指定记录
	 */
	@RequestMapping(value="/delete.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody UserRole entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		int count = userRoleService.delete(entity.getId());
		
        ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insert.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody UserRole entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = userRoleService.insert(entity);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insertUserList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody FormData<Role> form, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//获取登陆用户对象
		if(request.getAttribute("loginUser") != null){			
			User user = (User)request.getAttribute("loginUser");
			
			//业务操作可以不捕获异常,由统一的异常处理方法处理
			Role role = form.getBo();
			
			if(form.getOther().get("userList") != null){
				List userList = (List)form.getOther().get("userList");
				
				userRoleService.deleteByRole(role.getId());
				
				for(Object userId : userList){
					UserRole entity = new UserRole();
					entity.setUserId(Long.parseLong(userId.toString()));
					entity.setRoleId(role.getId());
					
					entity.setOrgId(user.getOrgId());
					entity.setEnableFlag("Y");
					entity.setCreatedBy(user.getId());
					entity.setCreatedDate(new Date());
					entity.setLastUpdatedBy(user.getId());
					entity.setLastUpdatedDate(new Date());
					//log.info("用户ID:" + userId +", 角色ID:" + role.getId());
					
					int count = userRoleService.insert(entity);
				}
			}
		}
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(0));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/saveEdit.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData saveEdit(HttpServletRequest request, @RequestBody FormData<UserRole> form, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<Object,Object> formOther = form.getOther();
		long roleId = Long.valueOf(formOther.get("roleId").toString());
		Object userIdsObject = formOther.get("userIds");
		@SuppressWarnings("unchecked")
		List<String> userIds = (ArrayList<String>)userIdsObject;
		List<UserRole> userRoles = new ArrayList<UserRole>();
		UserRole userRole = null;
		for(String o : userIds){
			userRole = new UserRole();
			userRole.setRoleId(roleId);
			userRole.setUserId(Long.valueOf(o));
			
			userRole.setCreatedBy(1L);
			userRole.setLastUpdatedBy(1L);
			userRole.setOrgId(0L);
			userRole.setCreatedDate(new Date());
			userRole.setLastUpdatedDate(new Date());
			userRole.setEnableFlag("Y");
			
			userRoles.add(userRole);
		}
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = userRoleService.saveEditByRole(roleId,userRoles);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改指定记录
	 */
	@RequestMapping(value="/update.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody UserRole entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = userRoleService.update(entity);
			
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 获取符合条件的分页记录，包括当页数据/记录总数,
	 * 先按指定属性排序,再分页
	 */
	@RequestMapping(value="/getPage.serv",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<UserRole>  form) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", form.getBo().getId());
	    long total = userRoleService.getCount(map,form.getSort(),form.getOrder());
	    List<UserRole> list = userRoleService.getPage(map,form.getSort(),form.getOrder(),form.getPage(),form.getRows());
	        
	    PageRows<UserRole> page = new PageRows<UserRole>();
	    page.setCurrent(form.getPage());
	    page.setTotal(total);
	    page.setRows(list);
	    
	    ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(page);
        
        return ret;	
	}
	
	//异常处理方法
	@ResponseBody
	@ExceptionHandler    
	public ServiceData exception(HttpServletRequest request,Exception e){  
		//添加自己的异常处理逻辑，如日志记录　
		log.error("UserRoleController 捕获到异常：", e);
	
		ServiceData ret = new ServiceData();
		
		//根据不同的异常类型进行不同处理
	    //包括效验异常\业务异常\服务器异常等
	    if(e instanceof ValidationException) {
	    	ret.setCode(request,ServiceData.RetCode.ValidationError);
	        //ret.setBo(e);
	    	//ret.setBo(((ValidationException) e).getResult().getAllErrors());
	    	ret.setBo(((ValidationException) e).getResultMap());
	    }
	    else if(e instanceof BusiException) {
	    	ret.setCode(request,ServiceData.RetCode.BusinessError);
	        ret.setBo(e);
	    }
	    else{
	        ret.setCode(request,ServiceData.RetCode.ServerError);
	        //ret.setBo(ex);
	        ret.setBo(e.getMessage());
	    }
  
	    //request.setAttribute("exceptionMessage", e.getMessage()); 
	    
	    return ret;
	}  
	
}