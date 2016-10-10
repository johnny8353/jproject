<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/index.jsp">Index</a><br/>
	<br><br>
	<a href="${pageContext.request.contextPath}/exception/testExceptionHandlerExceptionResolver?i=0">Test ExceptionHandlerExceptionResolver</a>
	
	<br><br>
	<a href="${pageContext.request.contextPath}/exception/testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
	
	<br><br>
	<a href="${pageContext.request.contextPath}/exception/testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
	
	<br><br>
	<a href="${pageContext.request.contextPath}/exception/testSimpleMappingExceptionResolver?i=21">Test SimpleMappingExceptionResolver</a>
	
</body>
</html>