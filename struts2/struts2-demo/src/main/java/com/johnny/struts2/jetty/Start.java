package com.johnny.struts2.jetty;

import com.johnny.jetty.JettyStartDirectory;

public class Start {
	//ddd
	public static void main(String[] args) throws Exception {
		String webroot = System.getProperty("user.dir");
		String path = "";
		JettyStartDirectory.start(webroot, path);
	}
}
