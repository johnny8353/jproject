<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getContextPath() %>
	HelloWorld!!springmvc<br/>
	<a href="${pageContext.request.contextPath}/helloworld.jsp">HelloWorld</a><br/>
	<a href="${pageContext.request.contextPath}/requestmapping.jsp">使用 @RequestMapping 映射请求</a><br/>
	<a href="${pageContext.request.contextPath}/requestparam.jsp">映射请求参数 & 请求头</a><br/>
	<a href="${pageContext.request.contextPath}/modeldata.jsp">处理模型数据&视图解析</a><br/>
	<a href="${pageContext.request.contextPath}/crud/emps">REST CRUD</a><br/>
	<a href="${pageContext.request.contextPath}/json.jsp">testJson</a><br/>
	<a href="${pageContext.request.contextPath}/i18n">国际化</a><br/>
	<a href="${pageContext.request.contextPath}/test/fileList">上传下载</a><br/>
	<a href="${pageContext.request.contextPath}/exception.jsp">异常处理</a><br/>
</body>
</html>