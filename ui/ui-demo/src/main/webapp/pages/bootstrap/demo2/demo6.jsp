<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 导航栏</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/bootstrap/js/collapse.js"></script>
	<!-- 
	导航栏是一个很好的功能，是 Bootstrap 网站的一个突出特点。导航栏在您的应用或网站中作为导航页头的响应式基础组件。导航栏在移动设备的视图中是折叠的，随着可用视口宽度的增加，导航栏也会水平展开。
	在 Bootstrap 导航栏的核心中，导航栏包括了站点名称和基本的导航定义样式。
	 -->
</head>
<body style="margin: 50px;">
	<!-- 
	默认的导航栏
	创建一个默认的导航栏的步骤如下：
		向 <nav> 标签添加 class .navbar、.navbar-default。
		向上面的元素添加 role="navigation"，有助于增加可访问性。
		向 <div> 元素添加一个标题 class .navbar-header，内部包含了带有 class navbar-brand 的 <a> 元素。这会让文本看起来更大一号。
		为了向导航栏添加链接，只需要简单地添加带有 class .nav、.navbar-nav 的无序列表即可。
	 -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>


	<!-- 
	响应式的导航栏
	为了给导航栏添加响应式特性，您要折叠的内容必须包裹在带有 classes .collapse、.navbar-collapse 的 <div> 中。
	折叠起来的导航栏实际上是一个带有 class .navbar-toggle 及两个 data- 元素的按钮。第一个是 data-toggle，用于告诉 JavaScript 需要对按钮做什么，
	第二个是 data-target，指示要切换到哪一个元素。三个带有 class .icon-bar 的 <span> 创建所谓的汉堡按钮。这些会切换为 .nav-collapse <div> 中的元素。
	为了实现以上这些功能，您必须包含 Bootstrap 折叠（Collapse）插件。
	 -->
	<nav class="navbar navbar-default" role="navigation">
	   <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" 
	         data-target="#example-navbar-collapse">
	         <span class="sr-only">切换导航</span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">W3Cschool</a>
	   </div>
	   <div class="collapse navbar-collapse" id="example-navbar-collapse">
	      <ul class="nav navbar-nav">
	         <li class="active"><a href="#">iOS</a></li>
	         <li><a href="#">SVN</a></li>
	         <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	               Java <b class="caret"></b>
	            </a>
	            <ul class="dropdown-menu">
	               <li><a href="#">jmeter</a></li>
	               <li><a href="#">EJB</a></li>
	               <li><a href="#">Jasper Report</a></li>
	               <li class="divider"></li>
	               <li><a href="#">分离的链接</a></li>
	               <li class="divider"></li>
	               <li><a href="#">另一个分离的链接</a></li>
	            </ul>
	         </li>
	      </ul>
	   </div>
	</nav>
	
	<!-- 
	导航栏中的表单
	导航栏中的表单不是使用 Bootstrap 表单 章节中所讲到的默认的 class，它是使用 .navbar-form class。
	这确保了表单适当的垂直对齐和在较窄的视口中折叠的行为。使用对齐方式选项（这将在组件对齐方式部分进行详细讲解）来决定导航栏中的内容放置在哪里。
	 -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
	</nav>


	<!-- 
	导航栏中的按钮
	您可以使用 class .navbar-btn 向不在 <form> 中的 <button> 元素添加按钮，按钮在导航栏上垂直居中。.navbar-btn 可被使用在 <a> 和 <input> 元素上。
	不要在 .navbar-nav 内的 <a> 元素上使用 .navbar-btn，因为它不是标准的 button class。
	 -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<p class="navbar-text">Signed in as Thomas</p>
	</div>
	</nav>


	<!-- 
	非导航链接
	如果您不想在常规的导航栏导航组件内使用标准的链接，那么请使用 class navbar-link 来为默认的和倒转的导航栏选项添加适当的颜色
	 -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<p class="navbar-text navbar-right">
			Signed in as <a href="#" class="navbar-link">Thomas</a>
		</p>
	</div>
	</nav>
	
	<!-- 
	组件对齐方式
	您可以使用实用工具 class .navbar-left 或 .navbar-right 向左或向右对齐导航栏中的 导航链接、表单、按钮或文本 这些组件。这两个 class 都会在指定的方向上添加 CSS 浮动。
	 -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<!--向左对齐-->
		<ul class="nav navbar-nav navbar-left">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<button type="submit" class="btn btn-default">向左对齐-提交按钮</button>
		</form>
		<p class="navbar-text navbar-left">向左对齐-文本</p>
		<!--向右对齐-->
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
		<form class="navbar-form navbar-right" role="search">
			<button type="submit" class="btn btn-default">向右对齐-提交按钮</button>
		</form>
		<p class="navbar-text navbar-right">向右对齐-文本</p>
	</div>
	</nav>
	
	<!-- 
	固定到顶部
		Bootstrap 导航栏可以动态定位。默认情况下，它是块级元素，它是基于在 HTML 中放置的位置定位的。通过一些帮助器类，您可以把它放置在页面的顶部或者底部，
		或者您可以让它成为随着页面一起滚动的静态导航栏。
		如果您想要让导航栏固定在页面的顶部，请向 .navbar class 添加 class .navbar-fixed-top。下面的实例演示了这点：
		为了防止导航栏与页面主体中的其他内容的顶部相交错，请向 <body> 标签添加至少 50 像素的内边距（padding），内边距的值可以根据您的需要进行设置。
	 -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>


	<!-- 
	固定到底部
	如果您想要让导航栏固定在页面的底部，请向 .navbar class 添加 class .navbar-fixed-bottom。下面的实例演示了这点：
	 -->
	<nav class="navbar navbar-default navbar-fixed-bottom"
		role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>

	
</body>
</html>