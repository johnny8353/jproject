<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 下拉菜单（Dropdown）插件</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
	<!-- 
	Bootstrap 下拉菜单 这一章讲解了下拉菜单，但是没有涉及到交互部分，本章将具体讲解下拉菜单的交互。使用下拉菜单（Dropdown）插件，您可以向任何组件
	（比如导航栏、标签页、胶囊式导航菜单、按钮等）添加下拉菜单。
	
	通过 data 属性：向链接或按钮添加 data-toggle="dropdown" 来切换下拉菜单，如下所示：
	<div class="dropdown">
	  <a data-toggle="dropdown" href="#">下拉菜单（Dropdown）触发器</a>
	  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
	    ...
	  </ul>
	</div>
	如果您需要保持链接完整（在浏览器不启用 JavaScript 时有用），请使用 data-target 属性代替 href="#"：
	<a id="dLabel" role="button" data-toggle="dropdown" data-target="#">下拉菜单（Dropdown） <span class="caret"></span></a>
	通过 JavaScript：通过 JavaScript 调用下拉菜单切换，请使用下面的方法：
		$('.dropdown-toggle').dropdown()
	 -->


</head>
<body>
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


	<p>带有下拉菜单的标签页</p>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">Home</a></li>
		<li><a href="#">SVN</a></li>
		<li><a href="#">iOS</a></li>
		<li><a href="#">VB.Net</a></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> Java <span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="#">Swing</a></li>
				<li><a href="#">jMeter</a></li>
				<li><a href="#">EJB</a></li>
				<li class="divider"></li>
				<li><a href="#">分离的链接</a></li>
			</ul></li>
		<li><a href="#">PHP</a></li>
	</ul>

	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>

	<div id="myexample">
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle" id="dropdown-toggle3">Java
					<b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a id="action-1" href="#"> jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</div>
	<script>
	   $(function(){
	      $("#dropdown-toggle3").dropdown('toggle');
	   }); 
	</script>


</body>
</html>