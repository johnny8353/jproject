package com.johnny.frame.jetty;

import com.johnny.common.jetty.JettyStartEmbedded;

public class StartFrame {
	public static void main(String[] args) throws Exception {
		new JettyStartEmbedded(8091, "frame",System.getProperty("user.dir")+"/src/main/webapp").start();
	}
}
