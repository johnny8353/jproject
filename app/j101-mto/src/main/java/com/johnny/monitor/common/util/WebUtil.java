package com.johnny.monitor.common.util;

public class WebUtil {
	/**
	 * 得到WebRoot文件夹下的根路径，及web项目的根路径
	 * ！maven 开发  必须放在 Web所在的package下
	 * @return
	 */
	public static String getWebRootAbsolutePath() {
		String path = "";
		String folderPath = WebUtil.class.getResource("/").getPath();
		///D:/GIT/johnnymaven/app/j001-common/target/classes/
		if (folderPath.indexOf("WEB-INF") > 0) {
			path = folderPath.substring(0, folderPath.indexOf("WEB-INF"));
		}
		if (folderPath.indexOf("target/classes") > 0) {
			path = folderPath.substring(0, folderPath.indexOf("target/classes"))+"src/main/webapp";
		}
		if (folderPath.indexOf("target/test-classes") > 0) {
			path = folderPath.substring(0, folderPath.indexOf("target/test-classes"))+"src/main/webapp";
		}
		return path;
	}
	
	public static void main(String[] args) {
		System.out.println(WebUtil.getWebRootAbsolutePath());;
	}
}
