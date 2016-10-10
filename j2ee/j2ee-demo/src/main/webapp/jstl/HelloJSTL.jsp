<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>测试你的第一个使用到 JSTL 的网页</title>
	</head>
	<body>
		<c:out value="欢迎测试你的第一个使用到 JSTL 的网页" />
		</br>
		你使用的浏览器是：
		</br>
		<c:out value="${header['User-Agent']}" />
		<c:set var="a" value="David O'Davies" />
		<c:out value="David O'Davies" escapeXml="true" />

		<c:out value="Hello JSP 2.0 !! " />
		<c:out value="${ 3 + 5 }" />
		<c:out value="${ param.data }" default="No Data" />
		<c:out value="<p>有特殊字符</p>''" />
		<c:out value="<p>有特殊字符</p>'" escapeXml="false" />
	</body>
</html>
