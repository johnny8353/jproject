<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CH7 - Core_forEach3.jsp</title>
	</head>
	<body>
		<h2>
			<c:out value="<c:forEach> varStatus 的四种属性" />
		</h2>
		<%
			String atts[] = new String[5];
			atts[0] = "hello";
			atts[1] = "this";
			atts[2] = "is";
			atts[3] = "a";
			atts[4] = "pen";
			request.setAttribute("atts", atts);
		%>
		<c:forEach items="${atts}" var="item" varStatus="s">
			<h2>
				<c:out value="${item}" />
				的四种属性：
			</h2>
			index：${s.index}</br>
			count：${s.count}</br>
			first：${s.first}</br>
			last：${s.last}</br>
		</c:forEach>
	</body>
</html>