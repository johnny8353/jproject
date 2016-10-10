<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CH7 - Core_import.jsp</title>
	</head>
	<body>
		<h2>
			<c:out value="<c:import> 的用法" />
		</h2>
		<c:set var="input1" value="使用属性范围传到 Core_imported.jsp 中"
			scope="request" />
		包含 core_imported.jsp 中
		<hr />
		<c:import url="Core_imported.jsp" charEncoding="GB2312">
			<c:param name="input2" value="使用<c:param>传到 Core_imported.jsp 中" />
		</c:import>
		<hr />
		${output1}
	</body>
</html>