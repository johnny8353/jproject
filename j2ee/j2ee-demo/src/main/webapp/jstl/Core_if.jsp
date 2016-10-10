<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CH7 - Core_if.jsp</title>
</head>
<body>
<h2><c:out value="<c:if> 的用法" /></h2>
<c:if test="${param.username == 'Admin'}" var="condition" scope="page">
您好 Admin 先生
</c:if></br>
执行结果为: ${condition}
</body>
</html>