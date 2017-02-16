package com.zte.html5.frame.upload.inf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.html5.sysman.attachment.Attachment;
import com.zte.html5.sysman.attachmentpath.AttachmentPath;
import com.zte.html5.sysman.attachmentpath.IAttachmentPathService;
import com.zte.html5.sysman.dictionary.Dictionary;
import com.zte.html5.sysman.dictionary.IDictionaryService;
import com.zte.util.date.DateHelper;
import com.zte.util.ftp.FtpHelper;
import com.zte.util.string.StringHelper;

@Service
public class UploadService implements IUploadService {
	@Autowired
	IDictionaryService dictionaryService;
	@Autowired
	IAttachmentPathService attachmentPathService;
	// 附件上传类型
	private final static String LOCAL_TYPE = "ATTACHMENT_UPLOAD_TYPE";

	/**
	 * 上传到FTP服务器
	 */
	@Override
	public String uploadFTP(InputStream input, String file) throws Exception {
		String result = null;
		FtpHelper ftpHelper = null;
		try {
			// 获取上传路径
			AttachmentPath attachmentPath = this.getAttachmentPath();
			if (attachmentPath != null) {

				// 物理路径即IP
				String ftpIP = attachmentPath.getActualPath();
				// 端口号
				Integer ftpPort = Integer.parseInt(attachmentPath.getPort());
				// 用户名
				String ftpUser = attachmentPath.getUserName();
				// 密码
				String ftpPassword = attachmentPath.getPassword();
				// 获取FTP内容
				ftpHelper = new FtpHelper(ftpIP, ftpPort, ftpUser, ftpPassword);
				// 创建相对路径
				String relativPath = this.getRelativPath();
				// 获取上传附件新名称、新附件带后缀
				file = this.getNewFileName(file);

				// 登陆FTP
				if (ftpHelper.loginFtp()) {
					// 进入指定目录
					ftpHelper.changeFtpWorkingDirectory(relativPath);
					// 判断当前目录的文件是否存在
					if (!ftpHelper.checkFileExistsInFtp(relativPath)) {
						// 上传文件
						if (ftpHelper.uploadFtp(file, input)) {
							result = relativPath + file;
						}
						;
					}
					// 注销FTP
					ftpHelper.logoutFtp();
				}

			}
		} finally {
			try {
				if (ftpHelper != null) {
					// 关闭FTP
					ftpHelper.disconnectFtp();
				}
			} finally {
				// 关闭io
				if (input != null) {
					input.close();
				}
			}

		}
		return result;
	}

	/**
	 * 从ftp下载文件
	 */
	@Override
	public void downloadFTP(String filePath, String file, OutputStream os)
			throws Exception {
		InputStream is = null;
		FtpHelper ftpHelper = null;
		try {
			// 获取FTP路径
			AttachmentPath attachmentPath = this.getAttachmentPath();
			if (attachmentPath != null) {

				// 物理路径即IP
				String ftpIP = attachmentPath.getActualPath();
				// 端口号
				Integer ftpPort = Integer.parseInt(attachmentPath.getPort());
				// 用户名
				String ftpUser = attachmentPath.getUserName();
				// 密码
				String ftpPassword = attachmentPath.getPassword();

				// 获取FTP内容
				ftpHelper = new FtpHelper(ftpIP, ftpPort, ftpUser, ftpPassword);

				// 登陆FTP
				if (ftpHelper.loginFtp()) {
					// 进入指定目录
					ftpHelper.changeFtpWorkingDirectory(filePath);
					// 判断当前目录的文件是否存在
					if (ftpHelper.checkFileExistsInFtp(file)) {
						is = ftpHelper.getFileStream(file);
						int readNum = 0;
						while ((readNum = is.read()) != -1) {
							os.write(readNum);
						}
					}
					// 注销FTP
					ftpHelper.logoutFtp();
				}
			}
		} finally {
			try {
				if (ftpHelper != null) {
					// 关闭FTP
					ftpHelper.disconnectFtp();
				}
			} finally {
				try {
					if (is != null) {
						is.close();
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
	 * ftp批量打包下载
	 */
	@Override
	public void downloadFtpZip(List<Attachment> list, ZipOutputStream zipOut)
			throws Exception {
		String filePath = null;
		String file = null;
		String oldFile = null;
		InputStream is = null;
		Attachment attachment = null;
		int fileNum = 0;
		FtpHelper ftpHelper = null;
		try {
			// 获取FTP路径
			AttachmentPath attachmentPath = this.getAttachmentPath();
			if (attachmentPath != null) {
				// 物理路径即IP
				String ftpIP = attachmentPath.getActualPath();
				// 端口号
				Integer ftpPort = Integer.parseInt(attachmentPath.getPort());
				// 用户名
				String ftpUser = attachmentPath.getUserName();
				// 密码
				String ftpPassword = attachmentPath.getPassword();
				// 获取FTP内容
				ftpHelper = new FtpHelper(ftpIP, ftpPort, ftpUser, ftpPassword);

				// 文件名称重复
				Map<String, Object> validMap = new HashMap<String, Object>();

				// 登陆FTP
				if (ftpHelper.loginFtp()) {
					for (int i = 0; i < list.size(); i++) {
						attachment = list.get(i);
						filePath = attachment.getPath();
						file = this.monFileName(attachment.getFileName(),
								attachment.getExtendedName());
						oldFile = this.monFileName(attachment.getOldFileName(),
								attachment.getExtendedName());
						validMap.put(oldFile, null);
						if (validMap.containsKey(oldFile)) {
							++fileNum;
							oldFile = this.reFileName(oldFile, fileNum);
						}
						validMap.put(oldFile, null);
						// 进入指定目录
						ftpHelper.changeFtpWorkingDirectory(filePath);
						// 判断当前目录的文件是否存在
						if (ftpHelper.checkFileExistsInFtp(file)) {
							is = ftpHelper.getFileStream(file);

							ZipEntry entry = new ZipEntry(oldFile);
							zipOut.putNextEntry(entry);
							if (is != null) {
								int readLen = 0;
								byte[] buffer = new byte[is.available()];
								while ((readLen = is.read(buffer)) > 0) {
									zipOut.write(buffer, 0, readLen);
								}
							}
							is.close();
							// 多文件处理必须调用该方法
							ftpHelper.completePendingCommand();
						}

					}
					// 注销FTP
					ftpHelper.logoutFtp();
				}
			}
		} finally {
			try {
				if (ftpHelper != null) {
					// 关闭FTP
					ftpHelper.disconnectFtp();
				}
			} finally {
				try {
					if (is != null) {
						is.close();
					}
				} finally {
					if (zipOut != null) {
						zipOut.close();
					}
				}
			}
		}
	}

	@Override
	public boolean uploadDME(InputStream input, String filePath, String file)
			throws Exception {
		// TODO 自动生成的方法存根
		return false;
	}

	/**
	 * 上传到本地
	 */
	public String uploadLocal(InputStream input, String file) throws Exception {
		String result = null;
		OutputStream os = null;
		try {
			// 获取上传路径
			AttachmentPath attachmentPath = this.getAttachmentPath();
			// 获取物理路径
			String actualPath = attachmentPath.getActualPath();
			// 创建相对路径
			String relativPath = this.getRelativPath();
			// 获取上传附件新名称、新附件带后缀
			file = this.getNewFileName(file);
			StringBuffer sf = new StringBuffer();
			sf.append(actualPath).append(relativPath).append(file);
			if (attachmentPath != null) {
				// 写入文件
				File newFile = new File(sf.toString());
				// 文件目录不存在则创建
				if (!newFile.getParentFile().exists()) {
					newFile.getParentFile().mkdirs();
				}
				newFile.createNewFile();
				os = new FileOutputStream(sf.toString());
				int readNum = 0;
				while ((readNum = input.read()) != -1) {
					os.write(readNum);
				}
				os.close();
				result = relativPath + file;
			}
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} finally {
				if (input != null) {
					input.close();
				}
			}

		}
		return result;
	}

	/**
	 * 本地下载
	 */
	@Override
	public void downloadLocal(String filePath, String file, OutputStream os)
			throws Exception {
		// 获取路径
		AttachmentPath attachmentPath = this.getAttachmentPath();
		InputStream is = null;
		StringBuffer sf = new StringBuffer();
		if (attachmentPath != null) {
			try {
				// 物理路径
				String actualPath = attachmentPath.getActualPath();
				// 文件真实全路径
				sf.append(actualPath).append(filePath).append(file);
				// 获取文件对象
				File newFile = new File(sf.toString());
				is = new FileInputStream(newFile);
				int readNum = 0;
				while ((readNum = is.read()) != -1) {
					os.write(readNum);
				}
			} finally {
				try {
					if (is != null) {
						is.close();
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
	 * 本地批量打包
	 */
	@Override
	public void downloadLocalZip(List<Attachment> list, ZipOutputStream zipOut)
			throws Exception {
		// 文件名称重复
		Map<String, Object> validMap = new HashMap<String, Object>();
		String filePath = null;
		String file = null;
		String oldFile = null;
		InputStream is = null;
		Attachment attachment = null;
		int fileNum = 0;
		try {
			// 获取FTP路径
			AttachmentPath attachmentPath = this.getAttachmentPath();
			// 物理路径
			String actualPath = attachmentPath.getActualPath();
			for (int i = 0; i < list.size(); i++) {
				attachment = list.get(i);
				attachment = list.get(i);
				filePath = attachment.getPath();
				file = this.monFileName(attachment.getFileName(),
						attachment.getExtendedName());
				oldFile = this.monFileName(attachment.getOldFileName(),
						attachment.getExtendedName());				
				StringBuffer sf = new StringBuffer();
				// 文件真实全路径
				sf.append(actualPath).append(filePath).append(file);
				// 获取文件对象
				File newFile = new File(sf.toString());
				// 判断文件存在
				if (newFile.exists()) {
					//validMap.put(oldFile, null);
					// 有相同原文件名则重命名
					if (validMap.containsKey(oldFile)) {
						++fileNum;
						oldFile = this.reFileName(oldFile, fileNum);
					}
					validMap.put(oldFile, null);
					is = new FileInputStream(newFile);
					ZipEntry entry = new ZipEntry(oldFile);
					zipOut.putNextEntry(entry);
					if (is != null) {
						int readLen = 0;
						byte[] buffer = new byte[is.available()];
						while ((readLen = is.read(buffer)) > 0) {
							zipOut.write(buffer, 0, readLen);
						}
					}
					is.close();
				}
			}

		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} finally {
				if (zipOut != null) {
					zipOut.close();
				}
			}
		}
	}

	/**
	 * 获取唯一一条配置路径
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private AttachmentPath getAttachmentPath() throws Exception {
		Dictionary dictionary = this.getDictionary(LOCAL_TYPE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", dictionary.getId());
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
	 * 上传时重新定义唯一附件名称+类型
	 * 
	 * @param oldName
	 * @return
	 * @throws Exception
	 */
	private String getNewFileName(String oldName) throws Exception {
		StringBuffer sf = new StringBuffer();
		String fileName[] = oldName.split("\\.");
		sf.append(StringHelper.GenerateCodeValue("fn")).append(".")
				.append(fileName[1]);
		return sf.toString();
	}

	/**
	 * 批量下载时原文件名称重复重命名
	 * 
	 * @param oldFileName
	 * @param fileNum
	 * @return
	 */
	private String reFileName(String oldFile, int fileNum) {
		StringBuffer sf = new StringBuffer();
		String file[] = oldFile.split("\\.");
		sf.append(file[0]).append("(").append(fileNum).append(")").append(".")
				.append(file[1]);
		return sf.toString();
	}

	/**
	 * 依据日期规则取得新相对路径
	 * 
	 * @return
	 */
	private String getRelativPath() throws Exception {
		StringBuffer sf = new StringBuffer();
		String date = DateHelper.ConvertDateToString(new Date(), "yyyy-MM-dd");
		String[] dates = date.split("-");
		sf.append("/").append(dates[0]).append("/").append(dates[1])
				.append("/").append(dates[2]).append("/");
		return sf.toString();
	}

	/**
	 * 拼接文件名与类型
	 */
	private String monFileName(String fileName, String fileType) {
		StringBuffer sf = new StringBuffer();
		sf.append(fileName).append(".").append(fileType);
		return sf.toString();
	}

}
