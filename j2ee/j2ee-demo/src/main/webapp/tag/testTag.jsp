<%@ page language="java" import="java.util.*"
	import="com.johnny.javaweb.tag.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="johnny" uri="http://www.johnny.com/tab/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'testTag.jsp' starting page</title>
</head>

<body>
	This is my JSP page.
	<br>

	<johnny:testJspFragment>hello: ${param.name }</johnny:testJspFragment>
	<br>
	<br> hello:
	<%=request.getParameter("name")%>

	<br>
	<br>
	<johnny:printUpper time="2">
		abcdefh
	</johnny:printUpper>
	<br>
	<!-- 父标签打印name到控制台.  -->
	<johnny:parentTag>
		父标签体<br />
		<!-- 子标签以父标签的标签体存在,  子标签把父标签的name属性打印到 JSP 页面上.  -->
		<johnny:sonTag />
	</johnny:parentTag>
	<br>

	<johnny:choose>
		<johnny:when test="${param.age > 24}">^大学毕业</johnny:when>
		<johnny:when test="${param.age > 20}">^高中毕业</johnny:when>
		<johnny:otherwise>^高中以下...</johnny:otherwise>
	</johnny:choose>

	<br>
	<br>

	<%
		//list集合
		List<String> listData = new ArrayList<String>();
		listData.add("孤傲苍狼");
		listData.add("xdp");

		//对象数组
		Integer intObjArr[] = new Integer[] { 1, 2, 3 };

		//基本数据类型数组
		int intArr[] = new int[] { 4, 5, 6 };

		//map集合
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("a", "aaaaaa");
		mapData.put("b", "bbbbbb");

		//将集合存储到pageContext对象中
		pageContext.setAttribute("listData", listData);
		pageContext.setAttribute("intObjArr", intObjArr);
		pageContext.setAttribute("intArr", intArr);
		pageContext.setAttribute("mapData", mapData);
	%>
	<%--迭代存储在pageContext对象中的list集合 --%>
	<johnny:foreach items="${listData}" var="str">
        ${str}<br />
	</johnny:foreach>
	<hr />
	<%--迭代存储在pageContext对象中的数组 --%>
	<johnny:foreach items="${intObjArr}" var="num">
        ${num}<br />
	</johnny:foreach>
	<hr />
	<%--迭代存储在pageContext对象中的数组 --%>
	<johnny:foreach items="${intArr}" var="num">
        ${num}<br />
	</johnny:foreach>
	<hr />
	<%--迭代存储在pageContext对象中的map集合 --%>
	<johnny:foreach items="${mapData}" var="me">
        ${me}:${me.key}=${me.value}<br />
	</johnny:foreach>

	<br>
	<br>
	<!-- 使用一个 EL 的自定义函数 -->
	${fn:length(param.name) }
	<br>
	<br> ${fn:toUpperCase(param.name) }
	
	<a href="http://www.cnblogs.com">访问博客园</a>
	
	${fn:escapeXml("fff<'>") }
	
	fff<'>
</body>
</html>
