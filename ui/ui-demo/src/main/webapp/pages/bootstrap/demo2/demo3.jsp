<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 按钮下拉菜单</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 如需向按钮添加下拉菜单，只需要简单地在在一个 .btn-group 中放置按钮和下拉菜单即可。您也可以使用 <span class="caret"></span> 来指示按钮作为下拉菜单。 -->
</head>
<body>
	<div class="btn-group">
		<button type="button" class="btn btn-default dropdown-toggle"
			data-toggle="dropdown">
			默认 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">
			原始 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	
	<br/><br/>
	<!-- 
	分割的按钮下拉菜单
	分割的按钮下拉菜单使用与下拉菜单按钮大致相同的样式，但是对下拉菜单添加了原始的功能。分割按钮的左边是原始的功能，右边是显示下拉菜单的切换。
	 -->
	<div class="btn-group">
		<button type="button" class="btn btn-default">默认</button>
		<button type="button" class="btn btn-default dropdown-toggle"
			data-toggle="dropdown">
			<span class="caret"></span> <span class="sr-only">切换下拉菜单</span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-primary">原始</button>
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">
			<span class="caret"></span> <span class="sr-only">切换下拉菜单</span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	<br/><br/>
	<!-- 
	按钮下拉菜单的大小
	您可以使用带有各种大小按钮的下拉菜单：.btn-large、.btn-sm 或 .btn-xs。
	 -->
	<div class="btn-group">
		<button type="button" class="btn btn-default dropdown-toggle btn-lg"
			data-toggle="dropdown">
			默认 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-primary dropdown-toggle btn-sm"
			data-toggle="dropdown">
			原始 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-success dropdown-toggle btn-xs"
			data-toggle="dropdown">
			成功 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">功能</a></li>
			<li><a href="#">另一个功能</a></li>
			<li><a href="#">其他</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
		</ul>
	</div>

	<br/><br/>
	<!-- 
	按钮上拉菜单
	菜单也可以往上拉伸的，只需要简单地向父 .btn-group 容器添加 .dropup 即可。
	 -->
	<div class="row" style="margin-left: 50px; margin-top: 200px">
		<div class="btn-group dropup">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				默认 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#">功能</a></li>
				<li><a href="#">另一个功能</a></li>
				<li><a href="#">其他</a></li>
				<li class="divider"></li>
				<li><a href="#">分离的链接</a></li>
			</ul>
		</div>
		<div class="btn-group dropup">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">
				原始 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#">功能</a></li>
				<li><a href="#">另一个功能</a></li>
				<li><a href="#">其他</a></li>
				<li class="divider"></li>
				<li><a href="#">分离的链接</a></li>
			</ul>
		</div>
	</div>

</body>
</html>