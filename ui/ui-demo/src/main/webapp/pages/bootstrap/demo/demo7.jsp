<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 实例 - 偏移列</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	偏移是一个用于更专业的布局的有用功能。它们可用来给列腾出更多的空间。例如，.col-xs=* 类不支持偏移，但是它们可以简单地通过使用一个空的单元格来实现该效果。
	为了在大屏幕显示器上使用偏移，请使用 .col-md-offset-* 类。这些类会把一个列的左外边距（margin）增加 * 列，其中 * 范围是从 1 到 11。
	在下面的实例中，我们有 <div class="col-md-6">..</div>，我们将使用 .col-md-offset-3 class 来居中这个 div。
	 -->
	<div class="container">

		<h1>Hello, world!</h1>

		<div class="row">
			<div class="col-xs-6 col-md-offset-3"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
			</div>

		</div>
	</div>
</body>
</html>