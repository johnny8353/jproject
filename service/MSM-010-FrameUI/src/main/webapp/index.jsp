<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.net.*"
import="java.util.Enumeration"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MSM-010-FrameUI</title>
</head>
<body>
	HelloWorld!! MSM-010-FrameUI <br/>
	<a href="http://localhost:8091/frame/index.jsp">Frame Service</a><br/>
	<a href="index.html">index</a><br/>
	<a href="http://localhost:8091/frame/crud/emps">REST CRUD</a><br/>
	<%
	 	String localip = null;// 本地IP，如果没有配置外网IP则返回它
	    String netip = null;// 外网IP
	    try {
	        Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
	        InetAddress ip = null;
	        boolean finded = false;// 是否找到外网IP
	        while (netInterfaces.hasMoreElements() && !finded) {
	            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
	            Enumeration address = ni.getInetAddresses();
	            while (address.hasMoreElements()) {
	                ip = (InetAddress) address.nextElement();
	                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
	                    netip = ip.getHostAddress();
	                    finded = true;
	                    break;
	                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
	                    localip = ip.getHostAddress();
	                }
	            }
	        }
	    } catch (SocketException e) {
	        e.printStackTrace();
	    }

		out.print(netip);
		System.out.println(localip);
		
	%>
	
	netip：<% out.print(netip); %>
	localip：<% out.print(localip); %>
</body>
</html>