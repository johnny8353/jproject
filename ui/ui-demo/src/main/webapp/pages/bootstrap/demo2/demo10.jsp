<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 标签</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>

	<!-- 标签可用于计数、提示或页面上其他的标记显示。使用 class .label 来显示标签， -->
	<h1>Example Heading <span class="label label-default">Label</span></h1>
	<h2>Example Heading <span class="label label-default">Label</span></h2>
	<h3>Example Heading <span class="label label-default">Label</span></h3>
	<h4>Example Heading <span class="label label-default">Label</span></h4>
	<span class="label label-default">默认标签</span>
	<span class="label label-primary">主要标签</span>
	<span class="label label-success">成功标签</span>
	<span class="label label-info">信息标签</span>
	<span class="label label-warning">警告标签</span>
	<span class="label label-danger">危险标签</span>
</body>
</html>