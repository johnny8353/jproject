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
		pageContext.setAttribute("pageContextAttr", "pageContextValue");
		request.setAttribute("requestAttr", "requestValue");
		session.setAttribute("sessionAttr", "sessionValue");
		application.setAttribute("applicationAttr", "applicationValue");
	%>
	
	<h2>Attr 111 Page: <%= new Date() %></h2>
	
	<br><br>
	pageContextAttr: <%= pageContext.getAttribute("pageContextAttr") %>
	
	<br><br>
	requestAttr: <%= request.getAttribute("requestAttr") %>

	<br><br>
	sessionAttr: <%= session.getAttribute("sessionAttr") %>	
	
	<br><br>
	applicationAttr: <%= application.getAttribute("applicationAttr") %>
	
	<br><br>
	<a href="attr_2.jsp">To Attr2 Page</a>

	<br><br>
	<a href="testAttr">To Attr Servlet</a>
	
	<% 
		request.getRequestDispatcher("/JSP/attr_2.jsp").forward(request, response);
	%>
		
	
</body>
</html>