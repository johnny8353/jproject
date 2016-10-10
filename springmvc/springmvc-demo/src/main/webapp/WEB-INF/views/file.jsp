<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
	})
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/index.jsp">Index</a><br/>
	<c:forEach var="me" items="${fileNameMap}">
        <c:url value="test/testFileDown" var="downurl">
            <c:param name="filename" value="${me.key}"></c:param>
        </c:url>
        ${me.value}<a href="${pageContext.request.contextPath}/${downurl}">下载</a>
        <br/>
    </c:forEach>
    
	<form action="${pageContext.request.contextPath}/test/testFileUpload" method="POST" enctype="multipart/form-data">
	File: <input type="file" name="file"/>
	Desc: <input type="text" name="desc"/>
	<input type="submit" value="Submit"/>
	</form>
	
	

</body>
</html>