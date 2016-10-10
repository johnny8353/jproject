<%@page import="com.johnny.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="customer" class="com.johnny.javaweb.Customer" 
		scope="request"></jsp:useBean>
	
	<jsp:useBean id="customer2" beanName="com.johnny.javaweb.Customer"
		type="java.lang.Object" scope="request"></jsp:useBean>
		
	<%--jsp:useBean id="customer2" 处理
		if(request.getAttribute("customer2")==null){
			request.setAttribute("customer2", Class.forName("com.johnny.javaweb.Customer").newInstance());
		}
	--%>	
		
	<!-- 若 property 的值为 *, 省略 value 属性值, 则将自动为所有属性赋值为对应的请求参数的值.  -->	
	<jsp:setProperty property="*" name="customer"/>
	
	<%-- 
	<jsp:setProperty property="name" value="johnny2" name="customer"/>
	--%>
	

	  
	<form name="form1" action="" method="post">
    	在这里输入传给JavaBean的内容：<br>
    	<input type="text" name="age"/>
    	<input type="text" name="name"/>
    	<input type="text" name="id"/>
    	<input type="submit" name="T1" value="提交"/>
    	<br>
    </form>
	下面显示的是从JavaBean返回的内容：<br>
    age: <jsp:getProperty property="age" name="customer"/> 
    age: ${customer.age }
	<br>
	name: <jsp:getProperty property="name" name="customer"/>
	<br>
	id: <jsp:getProperty property="id" name="customer"/>
	
	<%-- 
	<%= customer.getAge() %>
	--%>
		
	<%-- 
		customer.setAge(10);
	--%>	
	
	<%-- 
		//1. 从 scope(session) 中获取 id(customer) 属性值, 赋给 class(com.johnny.javaweb.Customer) 
		//类型的 id(customer) 变量
		Customer customer = (Customer)session.getAttribute("customer");
		
		//2. 若属性值为 null, 则利用反射创建一个新的对象, 把该对象赋给 id(customer), 并以 id(customer) 
		//为属性名让如到 scope(session) 中.
		if(customer == null){
			customer = (Customer)Class.forName("com.johnny.javaweb.Customer").newInstance();
			session.setAttribute("customer", customer);
		}
	--%>
	
</body>
</html>