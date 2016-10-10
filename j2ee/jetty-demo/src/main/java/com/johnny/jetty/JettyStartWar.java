package com.johnny.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 类 编 号：
 * 类 名 称：JettyStart
 * 内容摘要：Jetty9内容位于http://www.eclipse.org/jetty/documentation。
 * 不要部署你的应用在Jetty上，部署Jetty在你的应用中
 * 完成日期：2016年9月6日
 * 编码作者：JohnnyHuang 黄福强
 */
public class JettyStartWar {
	public static void main(String[] args) throws Exception {
		//war包形式启动
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setContextPath("/cxf");
		context.setWar(System.getProperty("user.dir")+"/target/webservice-cxf-demo.war");
		server.setHandler(context);

		server.start();
		server.join();
	}
}
