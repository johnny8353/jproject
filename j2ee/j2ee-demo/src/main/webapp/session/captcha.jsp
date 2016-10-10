<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="${pageContext.request.contextPath}/getcaptcha.sl" alt="验证码" name="checkImg" id="checkImg"
		style="position: relative; top: 5px; left: 20px;"
		onClick="document.getElementById('checkImg').src='${pageContext.request.contextPath}/getcaptcha.sl?temp='+ (new Date().getTime().toString(36)); return false" />
</body>
</html>