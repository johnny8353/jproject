<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CH7 - Core_import.jsp</title>
	</head>
	<body>
		<h2>
			<c:out value="<c:import> ���÷�" />
		</h2>
		<c:set var="input1" value="ʹ�����Է�Χ���� Core_imported.jsp ��"
			scope="request" />
		���� core_imported.jsp ��
		<hr />
		<c:import url="Core_imported.jsp" charEncoding="GB2312">
			<c:param name="input2" value="ʹ��<c:param>���� Core_imported.jsp ��" />
		</c:import>
		<hr />
		${output1}
	</body>
</html>