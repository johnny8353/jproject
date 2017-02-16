package com.zte.html5.frame.upload.inf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.zte.html5.sysman.attachment.Attachment;

/**
 * FTP接口
 * 
 * @author Administrator
 *
 */
public interface IUploadService {
	/**
	 * 
	 * @param input
	 *            io流
	 * @param file
	 *            文件名称：如**_**_**_**.text
	 * @return
	 * @throws Exception
	 */
	public String uploadFTP(InputStream input, String file) throws Exception;

	/**
	 * 从ftp下载单个文件
	 * 
	 * @param filePath
	 *            相对路径：如/a/b/c
	 * @param file
	 *            文件名称：如**_**_**_**.text
	 * @param os
	 *            IO流
	 * @throws Exception
	 */
	public void downloadFTP(String filePath, String file, OutputStream os)
			throws Exception;

	/**
	 * 本地下载
	 * 
	 * @param filePath
	 * @param file
	 * @param os
	 * @throws Exception
	 */
	public void downloadLocal(String filePath, String file, OutputStream os)
			throws Exception;

	/**
	 * 从ftp批量打包下载
	 * 
	 * @param list
	 * @param zipOut
	 * @throws Exception
	 */
	public void downloadFtpZip(List<Attachment> list, ZipOutputStream zipOut)
			throws Exception;

	/**
	 * 本地批量打包下载
	 * 
	 * @param list
	 * @param zipOut
	 * @throws Exception
	 */
	public void downloadLocalZip(List<Attachment> list, ZipOutputStream zipOut)
			throws Exception;

	/**
	 * 上传附件到DME
	 * 
	 */
	public boolean uploadDME(InputStream input, String filePath, String file)
			throws Exception;

	/**
	 * 上传到本地
	 * 
	 * @param input
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String uploadLocal(InputStream input, String file) throws Exception;

}
