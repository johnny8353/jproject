<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	事件
	下表列出了滚动监听中要用到事件。这些事件可在函数中当钩子使用。
	事件	描述	实例
	activate.bs.scrollspy	每当一个新项目被滚动监听激活时，触发该事件。	
	$('#myScrollspy').on('activate.bs.scrollspy', function () {
	  // 执行一些动作...
	})
	 -->
	<nav id="myScrollspy" class="navbar navbar-default navbar-static"
		role="navigation">
	<div class="navbar-header">
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			data-target=".bs-js-navbar-scrollspy">
			<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">教程名称</a>
	</div>
	<div class="collapse navbar-collapse bs-js-navbar-scrollspy">
		<ul class="nav navbar-nav">
			<li class="active"><a href="#ios">iOS</a></li>
			<li><a href="#svn">SVN</a></li>
			<li class="dropdown"><a href="#" id="navbarDrop1"
				class="dropdown-toggle" data-toggle="dropdown"> Java <b
					class="caret"></b>
			</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="navbarDrop1">
					<li><a href="#jmeter" tabindex="-1">jmeter</a></li>
					<li><a href="#ejb" tabindex="-1">ejb</a></li>
					<li class="divider"></li>
					<li><a href="#spring" tabindex="-1">spring</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<div data-spy="scroll" data-target="#myScrollspy" data-offset="0"
		style="height: 200px; overflow: auto; position: relative;">
		<div class="section">
			<h4 id="ios">
				iOS<small><a href="#" onclick="removeSection(this);">
						&times; 删除该部分</a></small>
			</h4>
			<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和
				Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
		</div>
		<div class="section">
			<h4 id="svn">
				SVN<small></small>
			</h4>
			<p>Apache Subversion，通常缩写为 SVN，是一款开源的版本控制系统软件。Subversion 由
				CollabNet 公司在 2000 年创建。但是现在它已经发展为 Apache Software Foundation
				的一个项目，因此拥有丰富的开发人员和用户社区。</p>
		</div>
		<div class="section">
			<h4 id="jmeter">
				jMeter<small><a href="#" onclick="removeSection(this);">
						&times; 删除该部分</a></small>
			</h4>
			<p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
		</div>
		<div class="section">
			<h4 id="ejb">EJB</h4>
			<p>Enterprise Java
				Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic
				等）的 J2EE 上。</p>
		</div>
		<div class="section">
			<h4 id="spring">Spring</h4>
			<p>Spring 框架是一个开源的 Java 平台，为快速开发功能强大的 Java 应用程序提供了完备的基础设施支持。</p>
			<p>Spring 框架最初是由 Rod Johnson 编写的，在 2003 年 6 月首次发布于 Apache 2.0
				许可证下。</p>
		</div>
	</div>
	<span id="activeitem" style="color: red;"></span>
	
	<script type="text/javascript">
	   $(function(){
	      removeSection = function(e) {
	      $(e).parents(".section").remove();
	      $('[data-spy="scroll"]').each(function () {
	          var $spy = $(this).scrollspy('refresh')
	      });
	   }
	   $("#myScrollspy").scrollspy();
	   $('#myScrollspy').on('activate.bs.scrollspy', function () {
	      var currentItem = $(".nav li.active > a").text();
	      $("#activeitem").html("目前您正在查看 - " + currentItem);
	   })
	});
	</script>


	<!-- The navbar: used to jump to a section in the scrollable area -->
	<nav class="navbar navbar-inverse navbar-fixed-top"> ...
	<ul class="nav navbar-nav">
		<li><a href="#section1">Section 1</a></li> 
		<li><a href="#section2">Section 2</a></li> 
		<li><a href="#section3">Section 3</a></li> 
	</nav>

	<!-- The scrollable area -->
	<div data-spy="scroll" data-target=".navbar" data-offset="12">
		<!-- Section 1 -->
		<div id="section1">
			<h1>Section 1</h1>
			<p>Try to scroll this page and look at the navigation bar while
				scrolling!</p>
		</div>
		<div id="section2">
			<h1>Section 2</h1>
			<p>Try to scroll this page and look at the navigation bar while
				scrolling!</p>
		</div>
		<div id="section3">
			<h1>Section 3</h1>
			<p>Try to scroll this page and look at the navigation bar while
				scrolling!</p>
		</div>
	</div>
	
</body>
</html>