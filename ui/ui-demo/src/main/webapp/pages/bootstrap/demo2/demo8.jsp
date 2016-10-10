<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 面包屑导航（Breadcrumbs）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 
	面包屑导航（Breadcrumbs）是一种基于网站层次信息的显示方式。以博客为例，面包屑导航可以显示发布日期、类别或标签。它们表示当前页面在导航层次结构内的位置。
	Bootstrap 中的面包屑导航（Breadcrumbs）是一个简单的带有 .breadcrumb class 的无序列表。分隔符会通过 CSS（bootstrap.min.css）中下面所示的 class 自动被添加：
	.breadcrumb > li + li:before {
	    color: #CCCCCC;
	    content: "/ ";
	    padding: 0 5px;
	}
	 -->
</head>
<body>
		
	<ol class="breadcrumb">
	  <li><a href="#">Home</a></li>
	  <li><a href="#">2013</a></li>
	  <li class="active">十一月</li>
	</ol>
	
</body>
</html>