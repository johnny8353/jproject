<%@ page contentType="text/html;charset=GB2312" %>
<html>
<head>
<title>CH6 - Param.jsp</title>
</head>
<body>
<h2>EL �������� param��paramValues</h2>
������ ${requestScope.username}</br>
������ ${username}</br>
������ ${param.username}</br>
���룺 ${param.password}</br>
�Ա� ${param.sex}</br>
���䣺 ${param.old}</br>
��Ȥ�� ${paramValues.habit[0]} ${paramValues.habit[1]}
</body>
</html>