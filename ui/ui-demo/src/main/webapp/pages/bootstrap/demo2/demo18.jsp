<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 面板（Panels）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	本章将讲解 Bootstrap 面板（Panels）。面板组件用于把 DOM 组件插入到一个盒子中。
	创建一个基本的面板，只需要向 <div> 元素添加 class .panel 和 class .panel-default 即可，如下面的实例所示：
	 -->
	<div class="panel panel-default">
		<div class="panel-body">这是一个基本的面板</div>
	</div>

	<!-- 
	面板标题
		我们可以通过以下两种方式来添加面板标题：
		使用 .panel-heading class 可以很简单地向面板添加标题容器。to easily add a heading container to your panel.
		使用带有 .panel-title class 的 <h1>-<h6> 来添加预定义样式的标题。
	 -->
	<div class="panel panel-default">
		<div class="panel-heading">不带 title 的面板标题</div>
		<div class="panel-body">面板内容</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">带有 title 的面板标题</h3>
		</div>
		<div class="panel-body">面板内容</div>
	</div>
	
	
	<!-- 
	面板脚注
	我们可以在面板中添加脚注，只需要把按钮或者副文本放在带有 class .panel-footer 的 <div> 中即可。下面的实例演示了这点：
	面版脚注不会从带语境色彩的面板中继承颜色和边框，因为它不是前景中的内容。
	 -->
	<div class="panel panel-default">
		<div class="panel-body">这是一个基本的面板</div>
		<div class="panel-footer">面板脚注</div>
	</div>
	
	<!-- 
	带语境色彩的面板
	使用语境状态类 panel-primary、panel-success、panel-info、panel-warning、panel-danger，来设置带语境色彩的面板，实例如下：
	 -->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
	</div>
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
	</div>
	<div class="panel panel-warning">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
	</div>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
	</div>
	
	<!-- 
	带表格的面板
	为了在面板中创建一个无边框的表格，我们可以在面板中使用 class .table。假设有个 <div> 包含 .panel-body，我们可以向表格的顶部添加额外的边框用来分隔。
	如果没有包含 .panel-body 的 <div>，则组件会无中断地从面板头部移动到表格。
	 -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">面板标题</h3>
		</div>
		<div class="panel-body">这是一个基本的面板</div>
		<table class="table">
			<th>产品</th>
			<th>价格</th>
			<tr>
				<td>产品 A</td>
				<td>200</td>
			</tr>
			<tr>
				<td>产品 B</td>
				<td>400</td>
			</tr>
		</table>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">面板标题</div>
		<table class="table">
			<th>产品</th>
			<th>价格</th>
			<tr>
				<td>产品 A</td>
				<td>200</td>
			</tr>
			<tr>
				<td>产品 B</td>
				<td>400</td>
			</tr>
		</table>
	</div>
	
	<!-- 
	带列表组的面板
	我们可以在任何面板中包含列表组，通过在 <div> 元素中添加 .panel 和 .panel-default 类来创建面板，并在面板中添加列表组。您可以从 列表组 一章中学习如何创建列表组。
	 -->
	<div class="panel panel-default">
		<div class="panel-heading">面板标题</div>
		<div class="panel-body">
			<p>这是一个基本的面板内容。这是一个基本的面板内容。 这是一个基本的面板内容。这是一个基本的面板内容。
				这是一个基本的面板内容。这是一个基本的面板内容。 这是一个基本的面板内容。这是一个基本的面板内容。</p>
		</div>
		<ul class="list-group">
			<li class="list-group-item">免费域名注册</li>
			<li class="list-group-item">免费 Window 空间托管</li>
			<li class="list-group-item">图像的数量</li>
			<li class="list-group-item">24*7 支持</li>
			<li class="list-group-item">每年更新成本</li>
		</ul>
	</div>
</body>
</html>