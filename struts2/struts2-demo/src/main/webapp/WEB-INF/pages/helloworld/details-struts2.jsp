<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>details-struts2.jsp</title>
</head>
<body>
	
	ProductId: ${productId }
	<br><br>
	<!--  -->
	ProductName: ${productName }
	<br><br>
	
	ProductDesc: ${productDesc }
	<br><br>
	
	ProductPrice: ${productPrice }
	<br><br>
	Product: ${product}
	
	<%=request.getAttribute("productName") %>
	<%= request %>
</body>
</html>