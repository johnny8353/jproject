package com.johnny.frameui.jetty;

import com.johnny.common.jetty.JettyStartEmbedded;

public class StartFrameUI {
	public static void main(String[] args) throws Exception {
		new JettyStartEmbedded(8090, "frameui",System.getProperty("user.dir")+"/src/main/webapp").start();
	}
}
