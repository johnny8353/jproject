package com.zte.html5.frame.upload.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zte.html5.frame.common.BusiException;
import com.zte.html5.frame.common.FormData;
import com.zte.html5.frame.common.ServiceData;
import com.zte.html5.frame.common.ValidationException;
import com.zte.html5.frame.upload.service.IAttachmentUploadService;
import com.zte.html5.sysman.attachment.Attachment;
import com.zte.html5.sysman.user.User;
import com.zte.util.string.StringHelper;

/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	// 日志对象
	private static final Logger log = Logger.getLogger(UploadController.class);

	// 服务对象，SPRING自动装配
	@Autowired
	IAttachmentUploadService attachmentUploadService;

	/**
	 * 上传
	 * 
	 * @param attachment
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadFile.do", method = RequestMethod.POST)
	@ResponseBody
	public ServiceData upLoadFile(Attachment attachment,
			MultipartHttpServletRequest req) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		User user = (User) req.getAttribute("loginUser");
		Long orgId =  Long.parseLong((String)req.getAttribute("orgId")) ;
		attachment.setOrgId(orgId);
		attachment.setCreatedBy(user.getId());
		attachment.setLastUpdatedBy(user.getId());
		Map<String, Object> result = attachmentUploadService.upload(req,
				attachment);
		boolean flag = (Boolean) result.get("flag");
		ret.setCode(req, ServiceData.RetCode.Success);
		if (!flag) {
			ret.setCode(req, ServiceData.RetCode.BusinessError);
		} else {
			ret.setCode(req, ServiceData.RetCode.Success);
			ret.setBo(result.get("value").toString());
		}
		return ret;
	}

	/**
	 * 获取指定上传文件
	 * 
	 * @param request
	 * @param from
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFile.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData showFile(HttpServletRequest request,
			@RequestBody FormData<Attachment> from) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		Long orgId =  Long.parseLong((String)request.getAttribute("orgId")) ;
		Map<String, Object> map = new HashMap<String, Object>();
		// 设置查询条件
		map.put("attachGroupId", from.getBo().getAttachGroupId());
		map.put("orgId", orgId);
		map.put("relationId", from.getBo().getRelationId());
		map.put("attachType", from.getBo().getAttachType());
		map.put("enableFlag", "N".equals(from.getBo().getEnableFlag()) ? "N"
				: "Y");
		List<Attachment> list = null;
		// 获取附件两种条件过滤
		if ((StringHelper.isNotEmpty(from.getBo().getAttachGroupId()) && StringHelper
				.isNotEmpty(orgId))
				|| (StringHelper.isNotEmpty(from.getBo().getRelationId())
						&& StringHelper
								.isNotEmpty(from.getBo().getAttachType()) && StringHelper
							.isNotEmpty(orgId))) {
			list = attachmentUploadService.getUploadFile(map, from.getSort(),
					from.getOrder());
		}

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(list);
		return ret;
	}

	/**
	 * 下载
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/download.do", method = RequestMethod.POST)
	@ResponseBody
	public void downloadFile(Attachment attachment, HttpServletResponse response)
			throws Exception {
		// String id=request.getParameter("id");
		attachmentUploadService.download(response, attachment);

	}

	/**
	 * 批量下载
	 * 
	 * @param attachment
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadBatch.do", method = RequestMethod.POST)
	@ResponseBody
	public void downloadBatchFile(@RequestParam("id") String[] attachmentId,
			HttpServletResponse response) throws Exception {
		attachmentUploadService.downloadBatch(response, attachmentId);

	}

	// 异常处理方法
	@ResponseBody
	@ExceptionHandler
	public ServiceData exception(HttpServletRequest request, Exception e) {
		// 添加自己的异常处理逻辑，如日志记录　
		log.error("UploadController 捕获到异常：", e);

		ServiceData ret = new ServiceData();

		// 根据不同的异常类型进行不同处理
		// 包括效验异常\业务异常\服务器异常等
		if (e instanceof ValidationException) {
			ret.setCode(request, ServiceData.RetCode.ValidationError);
			ret.setBo(((ValidationException) e).getResultMap());
		} else if (e instanceof BusiException) {
			ret.setCode(request, ServiceData.RetCode.BusinessError);
			ret.setBo(e);
		} else {
			ret.setCode(request, ServiceData.RetCode.ServerError);
			ret.setBo(e.getMessage());
		}
		return ret;
	}

	/**
	 * 获取附件名称串
	 * 
	 * @param request
	 * @param from
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAttachmentNameStr.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ServiceData getAttachmentNameStr(HttpServletRequest request,
			@RequestBody FormData<Attachment> from) throws Exception {
		// 返回统一的服务端数据
		ServiceData ret = new ServiceData();
		Long orgId =  Long.parseLong((String)request.getAttribute("orgId")) ;
		Map<String, Object> map = new HashMap<String, Object>();
		// 设置查询条件
		map.put("attachGroupId", from.getBo().getAttachGroupId());
		map.put("orgId", orgId);
		map.put("relationId", from.getBo().getRelationId());
		map.put("attachType", from.getBo().getAttachType());
		map.put("enableFlag", "N".equals(from.getBo().getEnableFlag()) ? "N"
				: "Y");
		List<Attachment> list = null;
		StringBuffer sb = new StringBuffer();
		// 获取附件两种条件过滤
		if ((StringHelper.isNotEmpty(from.getBo().getAttachGroupId()) && StringHelper
				.isNotEmpty(orgId))
				|| (StringHelper.isNotEmpty(from.getBo().getRelationId())
						&& StringHelper
								.isNotEmpty(from.getBo().getAttachType()) && StringHelper
							.isNotEmpty(orgId))) {
			list = attachmentUploadService.getUploadFile(map, from.getSort(),
					from.getOrder());
			for (Attachment attachment : list) {
				sb.append(attachment.getOldFileName()).append(attachment.getExtendedName()).append(",");
			}
		}
		String attachmentNameStr = sb.toString();
		if(StringHelper.isNotEmpty(attachmentNameStr)){
			attachmentNameStr = attachmentNameStr.substring(0, attachmentNameStr.length()-1);
		}

		ret.setCode(request, ServiceData.RetCode.Success);
		ret.setBo(attachmentNameStr);
		return ret;
	}
}
