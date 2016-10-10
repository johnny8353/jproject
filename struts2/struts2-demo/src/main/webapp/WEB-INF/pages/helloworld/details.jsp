<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>details.jsp</title>
</head>
<body>
	
	ProductId: ${requestScope.product.productId }
	<br><br>

	ProductName: ${requestScope.product.productName }
	<br><br>
	
	ProductDesc: ${requestScope.product.productDesc }
	<br><br>
	
	ProductPrice: ${requestScope.product.productPrice }
	<br><br>
	Product: ${requestScope.product }
	
</body>
</html>