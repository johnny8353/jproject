<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>CH7 - Core_imported.jsp</title>
	</head>
	<body>
		<fmt:requestEncoding value="GB2312" />
		<c:set var="output1" value="使用属性范围传到 Core_import.jsp 中"
			scope="request" />
		${input1}
		</br>
		<c:out value="${param.input2}" escapeXml="true" />
	</body>
</html>