package com.zte.html5.frame.upload.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zte.html5.sysman.attachment.Attachment;

/**
 * 附件上传接口
 * 
 * @author Administrator
 *
 */
public interface IAttachmentUploadService {
	/**
	 * 上传
	 * @param req
	 * @param attachment
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> upload(MultipartHttpServletRequest req,
			Attachment attachment) throws Exception;

	/**
	 * 获取上传附件
	 * 
	 * @param map
	 * @param orderField
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public List<Attachment> getUploadFile(Map<String, Object> map,
			String orderField, String order) throws Exception;

	/**单个下载
	 * 
	 * @param response
	 * @param attachmentId
	 * @throws Exception
	 */
	public void download(HttpServletResponse response, Attachment attachment)
			throws Exception;
	/**
	 * 批量下载
	 * @param response
	 * @param attachmentId
	 * @throws Exception
	 */
	public void downloadBatch(HttpServletResponse response, String[] attachmentId)
			throws Exception;

}
