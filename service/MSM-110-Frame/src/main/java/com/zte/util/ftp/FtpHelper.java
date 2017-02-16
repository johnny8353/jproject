package com.zte.util.ftp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpHelper {
	private static Logger logger = Logger.getLogger(FtpHelper.class);

	private FTPClient ftpClient = new FTPClient();
	private String ftpIP = "10.88.144.122";
	private Integer ftpPort = 88;
	private String ftpUser = "eshare";
	private String ftpPassword = "zte@123456";

	public FtpHelper() {
		// Properties properties = new Properties();
		// try {
		// FileInputStream fileInputStream = new
		// FileInputStream(this.getClass().getResource("/ftp.properties").getPath());
		// properties.load(fileInputStream);
		// ftpIP = properties.getProperty("ftpIP");
		// ftpPort = Integer.parseInt(properties.getProperty("ftpPort"));
		// ftpUser = properties.getProperty("ftpUser");
		// ftpPassword = properties.getProperty("ftpPassword");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	public FtpHelper(String ftpIP, Integer ftpPort, String ftpUser,
			String ftpPassword) {
		this.ftpIP = ftpIP;
		this.ftpPort = ftpPort;
		this.ftpUser = ftpUser;
		this.ftpPassword = ftpPassword;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	/*
	 * 登录FTP
	 */
	public boolean loginFtp() throws IOException {
		ftpClient.connect(ftpIP, ftpPort);

		// 获取响应码用于验证是否连接成功
		int replyCode = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			ftpClient.disconnect();
			logger.error("FTP: " + ftpIP + ":" + ftpPort + " 连接失败");
			return false;
		}

		// 登录服务器
		boolean login = ftpClient.login(ftpUser, ftpPassword);

		if (!login) {
			logger.error("FTP: " + ftpIP + ":" + ftpPort + "用户名/密码: " + ftpUser
					+ "/" + ftpPassword + " 登录失败!");
			return false;
		}

		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("UTF-8");

		return true;
	}

	/*
	 * 注销FTP
	 */
	public void logoutFtp() throws IOException {
		boolean logout = ftpClient.logout();
		if (!logout) {
			logger.error("FTP: " + ftpIP + ":" + ftpPort + " 注销失败");
		}
	}

	/*
	 * 关闭FTP
	 */
	public void disconnectFtp() {
		// 关闭链接需要放在finally语句块中
		if (ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}

	/*
	 * 进入指定目录,相对路径如：a/b/c
	 */
	public boolean changeFtpWorkingDirectory(String strDir) throws IOException {
		String[] dirsString = strDir.split("/");
		String pathString = "/";

		ftpClient.changeWorkingDirectory("/"); // 切换到根目录

		for (String dir : dirsString) {
			pathString += dir;
			if (!ftpClient.changeWorkingDirectory(dir)) {
				if (ftpClient.makeDirectory(dir)) {
					if (!ftpClient.changeWorkingDirectory(dir)) {
						logger.error("进入目录: " + pathString + " 失败！");
						return false;
					}
				} else {
					logger.error("创建目录: " + pathString + " 失败！");
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * 判断当前目录的文件是否存在,文件名如：**.text
	 */
	public boolean checkFileExistsInFtp(String fileName) throws IOException {
		FTPFile[] files = ftpClient.listFiles();
		boolean checkFileExists = false;
		String ftpfileString = null;
		for (FTPFile file : files) {
			ftpfileString = file.getName();
			if (ftpfileString.equals(fileName)) {
				checkFileExists = true;
				break;
			}
		}
		return checkFileExists;
	}

	/*
	 * 上传文件,文件名如：**.text
	 */
	public boolean uploadFtp(String fileName, InputStream is)
			throws IOException {
		boolean result = false;
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 上传文件
		if (ftpClient.storeFile(fileName, is)) {
			result = true;
		}
		return result;
	}

	/*
	 * 得到文件流,文件名如：**.text
	 */
	public InputStream getFileStream(String fileName) throws IOException {
		FTPFile[] fs = ftpClient.listFiles();
		InputStream is = null;
		for (FTPFile ff : fs) {
			if (ff.getName().equals(fileName)) {
				is = ftpClient.retrieveFileStream(ff.getName());
			}

		}
		return is;
	}
	/*
	 * ftp多文件处理时需要调用,使用在关闭io流之后
	 */
	public boolean completePendingCommand()
			throws IOException {
		return ftpClient.completePendingCommand();
	}

}
