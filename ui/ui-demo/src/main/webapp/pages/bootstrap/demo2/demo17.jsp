<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 列表组</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 
	本章我们将讲解列表组。列表组件用于以列表形式呈现复杂的和自定义的内容。创建一个基本的列表组的步骤如下：
		向元素 <ul> 添加 class .list-group。
		向 <li> 添加 class .list-group-item。
	 -->
</head>
<body>

	<ul class="list-group">
		<li class="list-group-item">免费域名注册</li>
		<li class="list-group-item">免费 Window 空间托管</li>
		<li class="list-group-item">图像的数量</li>
		<li class="list-group-item">24*7 支持</li>
		<li class="list-group-item">每年更新成本</li>
	</ul>


	<!-- 
	向列表组添加徽章
	我们可以向任意的列表项添加徽章组件，它会自动定位到右边。只需要在 <li> 元素中添加 <span class="badge"> 即可。下面的实例演示了这点：
	 -->
	<ul class="list-group">
		<li class="list-group-item">免费域名注册</li>
		<li class="list-group-item">免费 Window 空间托管</li>
		<li class="list-group-item">图像的数量</li>
		<li class="list-group-item"><span class="badge">新</span> 24*7 支持
		</li>
		<li class="list-group-item">每年更新成本</li>
		<li class="list-group-item"><span class="badge">新</span> 折扣优惠</li>
	</ul>
	
	<!-- 
	向列表组添加链接
	通过使用锚标签代替列表项，我们可以向列表组添加链接。我们需要使用 <div> 代替 <ul> 元素。下面的实例演示了这点：
	 -->
	<a href="#" class="list-group-item active"> 免费域名注册 </a>
	<a href="#" class="list-group-item">24*7 支持</a>
	<a href="#" class="list-group-item">免费 Window 空间托管</a>
	<a href="#" class="list-group-item">图像的数量</a>
	<a href="#" class="list-group-item">每年更新成本</a>
	<!-- 
	向列表组添加自定义内容
	我们可以向上面已添加链接的列表组添加任意的 HTML 内容。下面的实例演示了这点：
	 -->
	<div class="list-group">
		<a href="#" class="list-group-item active">
			<h4 class="list-group-item-heading">入门网站包</h4>
		</a> <a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">免费域名注册</h4>
			<p class="list-group-item-text">您将通过网页进行免费域名注册。</p>
		</a> <a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">24*7 支持</h4>
			<p class="list-group-item-text">我们提供 24*7 支持。</p>
		</a>
	</div>
	<div class="list-group">
		<a href="#" class="list-group-item active">
			<h4 class="list-group-item-heading">商务网站包</h4>
		</a> <a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">免费域名注册</h4>
			<p class="list-group-item-text">您将通过网页进行免费域名注册。</p>
		</a> <a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">24*7 支持</h4>
			<p class="list-group-item-text">我们提供 24*7 支持。</p>
		</a>
	</div>

</body>
</html>