package com.johnny.springmvc;

import com.johnny.common.jetty.JettyStartEmbedded;

public class Start {
	public static void main(String[] args) throws Exception {
		//
		new JettyStartEmbedded(8090, "springmvc",System.getProperty("user.dir")+"/src/main/webapp").start();
	}
}
