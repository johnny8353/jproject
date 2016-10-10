<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CH7 - Core_set_remove.jsp</title>
	</head>
	<body>
		<h2>
			<c:out value="<c:set>和<c:remove> 的用法" />
		</h2>
		<c:set scope="page" var="number">
			<c:out value="${1+1}" />
		</c:set>
		<c:set scope="request" var="number">
			<%=3%>
		</c:set>
		<c:set scope="session" var="number">
		4
		</c:set>
		初始设置
		<table border="1" width="30%">
			<tr>
				<th>
					pageScope.number
				</th>
				<td>
					<c:out value="${pageScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					requestScope.number
				</th>
				<td>
					<c:out value="${requestScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					sessionScope.number
				</th>
				<td>
					<c:out value="${sessionScope.number}" default="No Data" />
				</td>
			</tr>
		</table>
		</br>
		<c:out value='<c:remove var="number" scope="page" />之后' />
		<c:remove var="number" scope="page" />
		<table border="1" width="30%">
			<tr>
				<th>
					pageScope.number
				</th>
				<td>
					<c:out value="${pageScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					requestScope.number
				</th>
				<td>
					<c:out value="${requestScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					sessionScope.number
				</th>
				<td>
					<c:out value="${sessionScope.number}" default="No Data" />
				</td>
			</tr>
		</table>
		</br>
		<c:out value='<c:remove var="number" />之后' />
		<c:remove var="number" />
		<table border="1" width="30%">
			<tr>
				<th>
					pageScope.number
				</th>
				<td>
					<c:out value="${pageScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					requestScope.number
				</th>
				<td>
					<c:out value="${requestScope.number}" default="No Data" />
				</td>
			</tr>
			<tr>
				<th>
					sessionScope.number
				</th>
				<td>
					<c:out value="${sessionScope.number}" default="No Data" />
				</td>
			</tr>
		</table>
	</body>
</html>