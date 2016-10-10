<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 超大屏幕（Jumbotron）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 
	超大屏幕（Jumbotron）。顾名思义该组件可以增加标题的大小，并为登陆页面内容添加更多的外边距（margin）。使用超大屏幕（Jumbotron）的步骤如下：
		创建一个带有 class .jumbotron. 的容器 <div>。
		除了更大的 <h1>，字体粗细 font-weight 被减为 200px。
	 -->
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>欢迎登陆页面！</h1>
			<p>这是一个超大屏幕（Jumbotron）的实例。</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button"> 学习更多</a>
			</p>
		</div>
	</div>

	<!-- 为了获得占用全部宽度且不带圆角的超大屏幕，请在所有的 .container class 外使用 .jumbotron class，如下面的实例所示： -->
	<div class="jumbotron">
		<div class="container">
			<h1>欢迎登陆页面！</h1>
			<p>这是一个超大屏幕（Jumbotron）的实例。</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button"> 学习更多</a>
			</p>
		</div>
	</div>

	<!-- Bootstrap 页面标题（Page Header） -->
	<div class="page-header">
		<h1>
			页面标题实例 <small>子标题</small>
		</h1>
	</div>
	<p>这是一个示例文本。这是一个示例文本。这是一个示例文本。这是一个示例文本。这是一个示例文本。</p>


</body>
</html>