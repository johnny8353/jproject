<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="emp-save.action" theme="xhtml">
		
		<s:textfield name="firstName" label="FirstName"></s:textfield>
		<s:textfield name="lastName" label="LastName"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		
		<s:submit></s:submit>		
	</s:form>

	<br>
	<hr>
	<br>
	
	<table cellpadding="10" cellspacing="0" border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>
		
		<tbody>
			<s:iterator value="#request.emps">
				<tr>
					<td>${employeeId }</td>
					<td>${firstName }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td><a href="emp-edit.action?employeeId=${employeeId }">Edit</a></td>
					<td><a href="emp-delete.action?employeeId=${employeeId }">Delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
		
	</table>

</body>
</html>

<%
	System.out.println("now: " + new java.util.Date());
%>