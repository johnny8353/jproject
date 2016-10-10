<%@ page contentType="text/html;charset=GB2312" %>
<html>
<head>
<title>CH6 - Param.jsp</title>
</head>
<body>
<h2>EL 隐含对象 param、paramValues</h2>
姓名： ${requestScope.username}</br>
姓名： ${username}</br>
姓名： ${param.username}</br>
密码： ${param.password}</br>
性别： ${param.sex}</br>
年龄： ${param.old}</br>
兴趣： ${paramValues.habit[0]} ${paramValues.habit[1]}
</body>
</html>