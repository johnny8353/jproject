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
	
	<a href="${pageContext.request.contextPath}/requestparam/testServletAPI">Test ServletAPI</a>
	<br><br>

	<form action="${pageContext.request.contextPath}/requestparam/testPojo" method="post">
		username: <input type="text" name="username"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		email: <input type="text" name="email"/>
		<br>
		age: <input type="text" name="age"/>
		<br>
		city: <input type="text" name="address.city"/>
		<br>
		province: <input type="text" name="address.province"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>

	<a href="${pageContext.request.contextPath}/requestparam/testCookieValue">Test CookieValue</a>
	<br><br>

	<a href="${pageContext.request.contextPath}/requestparam/testRequestHeader">Test RequestHeader</a>
	<br><br>
	
	<a href="${pageContext.request.contextPath}/requestparam/testRequestParam?username=johnny&age=11">Test RequestParam</a>
	<br><br>
	
</body>
</html>