package com.johnny.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 类 编 号：
 * 类 名 称：JettyStart
 * 内容摘要：Jetty9内容位于http://www.eclipse.org/jetty/documentation。
 * 不要部署你的应用在Jetty上，部署Jetty在你的应用中
 * 完成日期：2016年9月6日
 * 编码作者：JohnnyHuang 黄福强
 */
public class JettyStartDirectory {
	private static String logDir = "c:\\";

	public static void start(String webroot,String path) throws Exception {
		Server server = new Server(8077);
		// 目录的方式启动，不需要重新打包
		WebAppContext context = new WebAppContext();
//		String webroot = System.getProperty("user.dir");
//		String webroot = "E:\\share\\JAVA\\010未分类-分类在笔记本汇总\\johnnyp\\JohnnyMaven\\";
//		String webroot = "F:\\本地同步盘总\\JAVA\\010未分类-分类在笔记本汇总\\code总结\\johnnyp\\JohnnyMaven\\";
//		webroot += "webservice\\webservice-axis2-demo";
//		webroot += "webservice\\webservice-cxf-demo";
//		webroot += "webservice\\webservice-jdk-demo";
		
//		webroot += "j2ee\\j2ee-demo";
//		webroot += "spring\\spring-demo";
//		webroot += "springmvc\\springmvc-demo";
		// E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client\src\main\webapp
		webroot = webroot + "/src/main/webapp";
		path = path.equals("")?"/johnny":path;
		context.setContextPath(path);
		context.setDescriptor(webroot + "/WEB-INF/web.xml");
		context.setResourceBase(webroot);
		context.setParentLoaderPriority(true);
		RequestLogHandler logHandler = new RequestLogHandler();
		logHandler.setRequestLog(createRequestLog());
		HandlerCollection handlerCollection = new HandlerCollection();
		handlerCollection.setHandlers(new Handler[] { context, logHandler });
		server.setHandler(handlerCollection);
		server.start();
		server.join();
	}

	private static RequestLog createRequestLog() {
		// 记录访问日志的处理
		NCSARequestLog requestLog = new NCSARequestLog();
		requestLog.setFilename(logDir + "/jetty-access-yyyy-mm-dd.log");
		requestLog.setFilenameDateFormat("yyyy-mm-dd");
		requestLog.setRetainDays(90);
		requestLog.setExtended(false);
		requestLog.setAppend(true);
		// requestLog.setLogTimeZone("GMT");
		requestLog.setLogTimeZone("Asia/Shanghai");
		requestLog.setLogDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		requestLog.setLogLatency(true);
		return requestLog;
	}
}
