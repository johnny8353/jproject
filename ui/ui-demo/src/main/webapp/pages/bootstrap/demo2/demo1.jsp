<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 下拉菜单（Dropdowns）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	本章将重点介绍 Bootstrap 下拉菜单。下拉菜单是可切换的，是以列表格式显示链接的上下文菜单。这可以通过与 下拉菜单（Dropdown） JavaScript 插件 的互动来实现。
	如需使用下列菜单，只需要在 class .dropdown 内加上下拉菜单即可。下面的实例演示了基本的下拉菜单：
	 -->

	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
			data-toggle="dropdown">
			主题 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">Java</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">数据挖掘</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#"> 数据通信/网络 </a></li>
			<li role="presentation" class="divider"></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">分离的链接</a></li>
		</ul>
	</div>
	
	<!-- 
	选项
		对齐
		通过向 .dropdown-menu 添加 class .pull-right 来向右对齐下拉菜单。下面的实例演示了这点：
	 -->

	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
			data-toggle="dropdown">
			主题 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu pull-right" role="menu"
			aria-labelledby="dropdownMenu1">
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">Java</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">数据挖掘</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#"> 数据通信/网络 </a></li>
			<li role="presentation" class="divider"></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">分离的链接</a></li>
		</ul>
	</div>
	
	<!-- 
	标题
	您可以使用 class dropdown-header 向下拉菜单的标签区域添加标题。下面的实例演示了这点：
	 -->
	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
			data-toggle="dropdown">
			主题 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			<li role="presentation" class="dropdown-header">下拉菜单标题</li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">Java</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">数据挖掘</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#"> 数据通信/网络 </a></li>
			<li role="presentation" class="divider"></li>
			<li role="presentation" class="dropdown-header">下拉菜单标题</li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="#">分离的链接</a></li>
		</ul>
	</div>
</body>
</html>