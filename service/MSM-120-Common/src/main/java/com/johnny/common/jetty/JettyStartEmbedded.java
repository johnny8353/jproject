package com.johnny.common.jetty;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
/**
 * 使用jetty启动服务
 * @author 10209744 黄福强
 * 
 */
public class JettyStartEmbedded {
	private int port;
	private String webName = "/";
	private String resourceBase;

	private Server server;

	public JettyStartEmbedded(String resourceBase) {
		this(8080, resourceBase);
	}
	
	public JettyStartEmbedded(int port,String resourceBase) {
		this.resourceBase = resourceBase;
		this.port = port;
		init();
	}
	public JettyStartEmbedded(int port,String webName,String resourceBase) {
		this.resourceBase = resourceBase;
		this.webName = "/" + webName;
		this.port = port;
		init();
	}


	/**
	 * 注：这里是相对路径，web　src/test/resources路径，绝对路径没判断
	 */
	public void init() {
		server = new Server(port);
		WebAppContext context = new WebAppContext();
		context.setContextPath(webName);
		//			context.setResourceBase(this.getClass().getResource(resourceBase).toURI().toASCIIString());
		context.setResourceBase(resourceBase);
		server.setHandler(context);

	}

	public void start() throws Exception {
		if (server != null) {
			if (server.isStarting() || server.isStarted() || server.isRunning()) {
				return;
			}
		}
		TimeUnit.SECONDS.sleep(3);
		server.start();
	}

	public void stop() throws Exception {
		if (server != null) {
			if (server.isRunning()) {
				server.stop();
			}
		}
	}

	public void join() throws InterruptedException {
		if (server != null) {
			server.join();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new JettyStartEmbedded(8088, System.getProperty("user.dir")+"/src/main/webapp").start();
	}
}
