package com.johnny.ireport.jetty;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperRunManager;

import com.johnny.jetty.JettyStartDirectory;

public class Start {
	public static void main(String[] args) throws Exception {
		String webroot = System.getProperty("user.dir");
		String path = "";
		JettyStartDirectory.start(webroot, path);
	}
}
