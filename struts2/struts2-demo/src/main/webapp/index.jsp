<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}">index</a><br/>
	
	使用 Filter 作为控制器的 MVC 应用 <a href="product-input.do">Product Input</a><br/>
	Struts2的HelloWord <a href="product-input.action">Product Input</a><br/>
	使用 ActionContext访问Web资源 <a href="TestActionContext.action?name=johnny">Test ActionContext</a><br/>
	实现 XxxAware 接口访问Web资源 <a href="TestAware.action?name=johnny">Test Aware</a><br/>
	在线人数例子 <a href="dologin.action">Login</a><br/>
	<a href="testResult.action?number=4">Test Result</a><br/>
	动态方法调用<a href="testDynamicMethodInvocation!update.action">testDynamicMethodInvocation</a><br/>
	CRUD例子<a href="emp-list.action">List All Employees</a><br/>
	<a href="${pageContext.request.contextPath}/hello">hello</a><br/>
	
	<a href="${pageContext.request.contextPath}/example/HelloWorld.do">HelloWorld</a><br/>
	<a href="${pageContext.request.contextPath}/example/Login.jsp">Login</a><br/>
	
	<p>Loading ...</p>
	
	<% 
		if(application.getAttribute("date") == null)
			application.setAttribute("date", new Date());
	
		request.setAttribute("req", "reqvalue");
	%>
	
</body>
</html>