package com.zte.html5.frame.upload.service;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zte.html5.frame.upload.inf.IUploadService;
import com.zte.html5.sysman.attachment.Attachment;
import com.zte.html5.sysman.attachment.IAttachmentService;
import com.zte.html5.sysman.attachmentpath.AttachmentPath;
import com.zte.html5.sysman.attachmentpath.IAttachmentPathService;
import com.zte.html5.sysman.dictionary.Dictionary;
import com.zte.html5.sysman.dictionary.IDictionaryService;
import com.zte.util.string.StringHelper;

/**
 * 上传附件实现方法
 * 
 * @author Administrator
 *
 */
@Service
public class AttachmentUploadService implements IAttachmentUploadService {
	@Autowired
	IDictionaryService dictionaryService;
	@Autowired
	IAttachmentPathService attachmentPathService;
	@Autowired
	IAttachmentService attachmentService;
	@Autowired
	IUploadService uploadService;
	// 附件上传类型
	private final static String LOCAL_TYPE = "ATTACHMENT_UPLOAD_TYPE";

	/**
	 * 上传
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, Object> upload(MultipartHttpServletRequest req,
			Attachment attachment) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("flag", false);
		result.put("value", "上传失败");
		Dictionary dictionary = this.getDictionary(LOCAL_TYPE);
		// // 获取上传路径
		AttachmentPath attachmentPath = this.getAttachmentPath(dictionary
				.getId());
		attachment.setAttachPathId(attachmentPath.getId());
		// 校验uuid是否符合规则，否则重新生成
		String uuid = attachment.getAttachGroupId();
		if (!validUUID(uuid)) {
			uuid = StringHelper.GetGUID();
			attachment.setAttachGroupId(uuid);
		}
		Iterator<String> itor = req.getFileNames();
		MultipartFile mulFile = null;
		String fileName = null;
		// Attachment attachment = null;
		// 如果是FTP上传
		if ("FTP".equals(dictionary.getDictValue())) {
			while (itor.hasNext()) {
				// 获取文件
				mulFile = req.getFile(itor.next());
				if (mulFile != null && !mulFile.isEmpty()) {
					// 获取上传附件名称
					fileName = mulFile.getOriginalFilename();
					// 上传到FTP
					String rtValue = uploadService.uploadFTP(
							mulFile.getInputStream(), fileName);
					if (rtValue != null) {
						// 封装保存数据
						attachment = this.getNewAttachment(mulFile, rtValue,
								attachment);
						if (attachmentService.insert(attachment) > 0) {
							result.put("flag", true);
							result.put("value", attachment.getAttachGroupId());
						}
					}
				}
			}

		} else if ("DME".equals(dictionary.getDictValue())) {
			// 省略，未提供DME上传组件

		} else {
			// 本地上传
			while (itor.hasNext()) {
				String rtValue = null;
				// 获取文件
				mulFile = req.getFile(itor.next());
				if (mulFile != null && !mulFile.isEmpty()) {
					// 获取上传附件名称
					fileName = mulFile.getOriginalFilename();
					rtValue = uploadService.uploadLocal(
							mulFile.getInputStream(), fileName);
				}
				if (rtValue != null) {
					// 封装保存数据
					attachment = this.getNewAttachment(mulFile, rtValue,
							attachment);
					if (attachmentService.insert(attachment) > 0) {
						result.put("flag", true);
						result.put("value", attachment.getAttachGroupId());
					}
				}
			}
		}
		return result;
	}

	/**
	 * 获取上传附件
	 */
	@Override
	public List<Attachment> getUploadFile(Map<String, Object> map,
			String orderField, String order) throws Exception {
		List<Attachment> attachment = attachmentService.getList(map,
				orderField, order);
		return attachment;
	}

	/**
	 * 下载
	 */
	@Override
	public void download(HttpServletResponse response, Attachment attachment)
			throws Exception {

		Dictionary dictionary = this.getDictionary(LOCAL_TYPE);
		if (attachment != null) {

			if (attachment.getId() != null) {
				attachment = attachmentService.get(attachment.getId());
			}
			// 单个下载
			if (attachment != null) {
				OutputStream os = null;
				try {
					// 相对路径
					String path = attachment.getPath();
					// 文件名
					String fileName = attachment.getFileName() + "."
							+ attachment.getExtendedName();
					// 原文件名
					String oldFileName = attachment.getOldFileName() + "."
							+ attachment.getExtendedName();
					response.setCharacterEncoding("UTF-8");
					response.addHeader(
							"Content-Disposition",
							"attachment;filename="
									+ new String(oldFileName.getBytes("UTF-8"),
											"ISO8859-1"));
					os = response.getOutputStream();
					// 如果是FTP
					if ("FTP".equals(dictionary.getDictValue())) {
						uploadService.downloadFTP(path, fileName, os);

					} else if ("DME".equals(dictionary.getDictValue())) {
						// 从DME下载
					} else {
						// 本地下载
						uploadService.downloadLocal(path, fileName, os);
					}
				} finally {
					if (os != null) {
						os.close();
					}
				}

			}
		}
	}

	/**
	 * 批量下载
	 */
	@Override
	public void downloadBatch(HttpServletResponse response,
			String[] attachmentId) throws Exception {
		Dictionary dictionary = this.getDictionary(LOCAL_TYPE);

		Attachment attachment = null;
		ZipOutputStream zipOut = null;
		List<Attachment> list = new ArrayList<Attachment>();
		// 本地保存设置
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Content-Disposition",
				"attachment; filename=batchFile.zip");
		// 获取对象列表
		for (String id : attachmentId) {
			if (id != null && !"".equals(id)) {
				attachment = attachmentService.get(Long.parseLong(id));
				if (attachment != null) {
					list.add(attachment);
				}
			}
		}
		try {
			// 向本地写文件
			ServletOutputStream sos = response.getOutputStream();
			zipOut = new ZipOutputStream(new BufferedOutputStream(sos));
			if ("FTP".equals(dictionary.getDictValue())) {
				// // 获取路径
				AttachmentPath attachmentPath = this
						.getAttachmentPath(dictionary.getId());
				if (attachmentPath != null) {
					// 打包批量下载
					uploadService.downloadFtpZip(list, zipOut);
				}
			} else if ("DME".equals(dictionary.getDictValue())) {

			} else {
				uploadService.downloadLocalZip(list, zipOut);
			}

		} finally {
			if (zipOut != null) {
				zipOut.close();
			}

		}
	}

	/**
	 * 获取上传类型值
	 * 
	 * @param type
	 * @return
	 */
	private Dictionary getDictionary(String value) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dictCode", value);
		List<Dictionary> list = dictionaryService.getList(map, null, null);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 获取唯一一条配置路径
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private AttachmentPath getAttachmentPath(Long id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", id);
		List<Dictionary> list = dictionaryService.getList(map, null, null);
		if (list.size() > 0) {
			String value = list.get(0).getDictValue();
			if (value != null && !"".equals(value)) {
				AttachmentPath attachmentPath = attachmentPathService.get(Long
						.parseLong(value));
				return attachmentPath;
			}

		}
		return null;
	}

	/**
	 * 封装附件内容
	 * 
	 */
	public Attachment getNewAttachment(MultipartFile mulFile,
			String pathAndName, Attachment attachment) throws Exception {
		String oldFileName[] = mulFile.getOriginalFilename().split("\\.");
		String pathAndNames[] = pathAndName.split("\\/");
		String newFileName[] = pathAndNames[pathAndNames.length - 1]
				.split("\\.");
		String filePath = "";
		for (int i = 0; i < pathAndNames.length - 1; i++) {
			filePath = filePath + pathAndNames[i] + "/";
		}
		Attachment newAttachment = attachment;
		newAttachment.setPath(filePath);
		newAttachment.setFileName(newFileName[0]);
		newAttachment.setExtendedName(newFileName[1].toLowerCase());
		newAttachment.setSize(mulFile.getSize());
		newAttachment.setOldFileName(oldFileName[0]);
		newAttachment.setEnableFlag("Y");
		newAttachment.setCreatedDate(new Date());
		newAttachment.setLastUpdatedDate(new Date());
		return attachment;
	}

	/**
	 * 校验uuid
	 * 
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	private boolean validUUID(String uuid) {
		boolean result = true;
		try {
			UUID.fromString(uuid);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
