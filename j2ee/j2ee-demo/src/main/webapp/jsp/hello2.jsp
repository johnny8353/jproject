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
	
	<% 
		Date date = new Date();
		out.print(date);
	%>
	
	<br><br>
	
	<!-- JSP 表达式 -->
	<%= date %>
	
	<% 
		String ageStr = request.getParameter("age");
		Integer age = Integer.parseInt(ageStr);
		
		if(age >= 18){
	%>
			成人...
	<%
		}else{
	%>
			未成人...
	<%
		}
	%>
	
	<%! 
		void test(){}
	%>
	
	<%-- JSP 注释 --%><!-- HTML 注释 -->
	
	<!-- 
	<% 
		System.out.println("打印信息...");
	%>
	-->
	
</body>
</html>








