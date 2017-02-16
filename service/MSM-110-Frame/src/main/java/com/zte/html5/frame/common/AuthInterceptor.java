package com.zte.html5.frame.common;

import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zte.html5.sysman.resource.IResourceService;
import com.zte.html5.sysman.resource.ResourceService;
import com.zte.html5.sysman.user.User;
import com.zte.html5.sysman.user.IUserService;

import org.apache.log4j.Logger;

/**
 * 身份认证处理监听器,根据HTTP头中的标志和身份令牌,自动处理身份识别.
 * 
 * @author Administrator
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	// @Resource(name = "systemLoggerService")
	// private SystemLoggerService systemLoggerService;

	// 日志对象
	private static final Logger log = Logger.getLogger(AuthInterceptor.class);

	// 服务对象，SPRING自动装配
	@Autowired
	IUserService userService;

	@Autowired
	IResourceService resourceService;
	
	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			// 验证身份令牌,成功则将用户信息邦定到REQUEST继续,失败直接返回
			boolean validateuser = false;

			// 取出身份令牌
			String token = request.getHeader("X-Auth-Value");
			User user = userService.getByToken(token);
			// 取出当前组织ID
			String orgId = request.getHeader("X-Org-Id");
			// 获取服务请求调用相对地址
			String serverUrl = request.getRequestURI().replace(request.getContextPath(), "");

			try {
				if (user != null && "Y".equalsIgnoreCase(user.getEnableFlag())) {
					request.setAttribute("loginUser", user);					
				}
				if (orgId != null && !orgId.equals("")){
					request.setAttribute("orgId", orgId);
				}
				
				//validateuser = true;
				validateuser = resourceService.validationServiceRequest(serverUrl, user, orgId);
			} catch (Exception ex) {
				validateuser = false;
				ex.printStackTrace();
			}

			if (validateuser) {
				// 验证成功
				return true;
			} else {
				// 认证失败,直接返回认证失败信息
				log.info("身份令牌验证失败,token=" + token);

				ServiceData serviceData = new ServiceData();
				serviceData.setCode(request, ServiceData.RetCode.AuthFailed);

				String msg = "{\"code\":{\"code\":\""
						+ serviceData.getCode().getCode() + "\",\"msgId\":\""
						+ serviceData.getCode().getMsgId() + "\",\"msg\":\""
						+ serviceData.getCode().getMsg()
						+ "\"},\"bo\":null,\"other\":null}";

				// 重新设置返回的消息类型和消息头,SPRING mvc设置为JSON类型,
				// 内容修改为加密字符串后,类型也要修改为text/html,防止angularjs自动根据类型转换数据
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=UTF-8");

				// 将加密数据写到原始的response对象中,返回客户端
				OutputStream outputStream = response.getOutputStream();
				StreamUtils.copy(msg, Charset.forName("utf-8"), outputStream);
				// StreamUtils.copy(resdata, Charset.forName("US-ASCII"),
				// outputStream);
				outputStream.close();

				return false;
			}
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
