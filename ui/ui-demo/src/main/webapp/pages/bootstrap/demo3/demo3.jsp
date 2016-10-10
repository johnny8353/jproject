<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 滚动监听（Scrollspy）插件</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
	<!-- 
	滚动监听（Scrollspy）插件，即自动更新导航插件，会根据滚动条的位置自动更新对应的导航目标。其基本的实现是随着您的滚动，基于滚动条的位置向导航栏添加 .active class。
	如果您想要单独引用该插件的功能，那么您需要引用 scrollspy.js。或者，正如 Bootstrap 插件概览 一章中所提到，您可以引用 bootstrap.js 或压缩版的 bootstrap.min.js。
	
	您可以向顶部导航添加滚动监听行为：
	通过 data 属性：向您想要监听的元素（通常是 body）添加 data-spy="scroll"。然后添加带有 Bootstrap .nav 组件的父元素的 ID 或 class 的属性 data-target。
	为了它能正常工作，您必须确保页面主体中有匹配您所要监听链接的 ID 的元素存在。
	<body data-spy="scroll" data-target=".navbar-example">
	  ...
	  <div class="navbar-example">
	    <ul class="nav nav-tabs">
	      ...
	    </ul>
	  </div>
	  ...
	</body>
	通过 JavaScript：您可以通过 JavaScript 调用滚动监听，选取要监听的元素，然后调用 .scrollspy() 函数：
	$('body').scrollspy({ target: '.navbar-example' })
	 -->
</head>
<body>
	<nav id="navbar-example" class="navbar navbar-default navbar-static"
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
			<li><a href="#ios">iOS</a></li>
			<li><a href="#svn">SVN</a></li>
			<li class="dropdown"><a href="#" id="navbarDrop1"
				class="dropdown-toggle" data-toggle="dropdown">Java <b
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
	<div data-spy="scroll" data-target="#navbar-example" data-offset="0"
		style="height: 200px; overflow: auto; position: relative;">
		<h4 id="ios">iOS</h4>
		<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和
			Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。
		</p>
		<h4 id="svn">SVN</h4>
		<p>Apache Subversion，通常缩写为 SVN，是一款开源的版本控制系统软件。Subversion 由
			CollabNet 公司在 2000 年创建。但是现在它已经发展为 Apache Software Foundation
			的一个项目，因此拥有丰富的开发人员和用户社区。</p>
		<h4 id="jmeter">jMeter</h4>
		<p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
		<h4 id="ejb">EJB</h4>
		<p>Enterprise Java
			Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic
			等）的 J2EE 上。</p>
		<h4 id="spring">Spring</h4>
		<p>Spring 框架是一个开源的 Java 平台，为快速开发功能强大的 Java 应用程序提供了完备的基础设施支持。</p>
		<p>Spring 框架最初是由 Rod Johnson 编写的，在 2003 年 6 月首次发布于 Apache 2.0
			许可证下。</p>
	</div>
</body>
</html>