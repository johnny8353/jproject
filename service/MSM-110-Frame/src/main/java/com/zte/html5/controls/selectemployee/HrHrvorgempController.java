package com.zte.html5.controls.selectemployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/selectemployee")
public class HrHrvorgempController {
	// 日志对象
	private static final Logger log = Logger
			.getLogger(HrHrvorgempController.class);

	// 服务对象，SPRING自动装配
	@Autowired
	IHrHrvorgempService hrHrvorgempService = null;

	public void setHrHrvorgempService(IHrHrvorgempService hrHrvorgempService) {
		this.hrHrvorgempService = hrHrvorgempService;
	}

	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 * 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value = "/getList.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getList(HttpServletRequest request,
			@RequestBody FormData<KeyValueSearchEmpRequest> from)
			throws Exception {

		from.setSort("activeDate");
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		List<KeyValueSearchEmpResponse> list = hrHrvorgempService.getList(from
				.getBo().getSeekInfo(), from.getSort(), from.getOrder());

		List<KeyValueSearchEmpResponse> resultList = getEmpMsgBZ(list);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(resultList);

		return ret;
	}

	private List<KeyValueSearchEmpResponse> getEmpMsgBZ(
			List<KeyValueSearchEmpResponse> list) {
		List<KeyValueSearchEmpResponse> resultList = new ArrayList<KeyValueSearchEmpResponse>();
		for (KeyValueSearchEmpResponse temp : list) {
			KeyValueSearchEmpResponse resultTemp = hrHrvorgempService
					.getEmpMsg(temp);
			resultList.add(resultTemp);
		}
		return resultList;
	}

	/**
	 * 获取符合条件的分页记录，包括当页数据/记录总数, 先按指定属性排序,再分页
	 */
	@RequestMapping(value = "/getPage.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getPage(HttpServletRequest request,
			@RequestBody FormData<KeyValueSearchEmpRequest> form)
			throws Exception {

		form.setSort("activeDate");

		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();

		long total = hrHrvorgempService.getCount(form.getBo().getSeekInfo(),
				form.getSort(), form.getOrder());
		List<KeyValueSearchEmpResponse> list = hrHrvorgempService.getPage(form
				.getBo().getSeekInfo(), form.getSort(), form.getOrder(), form
				.getPage(), form.getRows());

		List<KeyValueSearchEmpResponse> resultList = getEmpMsgBZ(list);

		PageRows<KeyValueSearchEmpResponse> page = new PageRows<KeyValueSearchEmpResponse>();
		page.setCurrent(form.getPage());
		page.setTotal(total);
		page.setRows(resultList);

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(page);

		return ret;
	}

	// 异常处理方法
	@ResponseBody
	@ExceptionHandler
	public ServiceData exception(HttpServletRequest request, Exception e) {
		// 添加自己的异常处理逻辑，如日志记录　
		log.error("HrHrvorgempController 捕获到异常：", e);

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