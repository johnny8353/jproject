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
	
	<form action="${pageContext.request.contextPath}/requestmapping/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	<br><br>
	
	<form action="${pageContext.request.contextPath}/requestmapping/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<br><br>
	
	<form action="${pageContext.request.contextPath}/requestmapping/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="${pageContext.request.contextPath}/requestmapping/testRest/1">Test Rest Get</a>
	<br><br>

	<a href="${pageContext.request.contextPath}/requestmapping/testPathVariable/1">Test PathVariable</a>
	<br><br>

	<a href="${pageContext.request.contextPath}/requestmapping/testAntPath/mnxyz/abc">Test AntPath</a>
	<br><br>

	<a href="${pageContext.request.contextPath}/requestmapping/testParamsAndHeaders?username=johnny&age=101">Test ParamsAndHeaders</a>
	<br><br>
	
	<form action="${pageContext.request.contextPath}/requestmapping/testMethod" method="POST">
		<input type="submit" value="submit"/>
	</form>

	<br><br>
	<a href="${pageContext.request.contextPath}/requestmapping/testMethod">Test Method</a>

	<br><br>
	<a href="${pageContext.request.contextPath}/requestmapping/testRequestMapping">Test RequestMapping</a>
	
	
</body>
</html>