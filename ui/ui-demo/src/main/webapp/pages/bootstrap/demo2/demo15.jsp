<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 进度条</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 
	本章将讲解 Bootstrap 进度条。在本教程中，您将看到如何使用 Bootstrap 创建加载、重定向或动作状态的进度条。
	Bootstrap 进度条使用 CSS3 过渡和动画来获得该效果。Internet Explorer 9 及之前的版本和旧版的 Firefox 不支持该特性，Opera 12 不支持动画。
	 -->
</head>
<body>
	<!-- 
	默认的进度条
	创建一个基本的进度条的步骤如下：
	添加一个带有 class .progress 的 <div>。
	接着，在上面的 <div> 内，添加一个带有 class .progress-bar 的空的 <div>。
	添加一个带有百分比表示的宽度的 style 属性，例如 style="60%"; 表示进度条在 60% 的位置。
	 -->

	<div class="progress">
		<div class="progress-bar" role="progressbar" aria-valuenow="60"
			aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
			<span class="sr-only">40% 完成</span>
		</div>
	</div>
	
	<!-- 
	交替的进度条
	创建不同样式的进度条的步骤如下：
	添加一个带有 class .progress 的 <div>。
	接着，在上面的 <div> 内，添加一个带有 class .progress-bar 和 class progress-bar-* 的空的 <div>。其中，* 可以是 success、info、warning、danger。
	添加一个带有百分比表示的宽度的 style 属性，例如 style="60%"; 表示进度条在 60% 的位置。
	 -->

	<div class="progress">
		<div class="progress-bar progress-bar-success" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 90%;">
			<span class="sr-only">90% 完成（成功）</span>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-info" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 30%;">
			<span class="sr-only">30% 完成（信息）</span>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-warning" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 20%;">
			<span class="sr-only">20% 完成（警告）</span>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-danger" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 10%;">
			<span class="sr-only">10% 完成（危险）</span>
		</div>
	</div>
	
	<!-- 
	条纹的进度条
	创建一个条纹的进度条的步骤如下：
	添加一个带有 class .progress 和 .progress-striped 的 <div>。
	接着，在上面的 <div> 内，添加一个带有 class .progress-bar 和 class progress-bar-* 的空的 <div>。其中，* 可以是 success、info、warning、danger。
	添加一个带有百分比表示的宽度的 style 属性，例如 style="60%"; 表示进度条在 60% 的位置。
	 -->
	<div class="progress progress-striped">
		<div class="progress-bar progress-bar-success" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 90%;">
			<span class="sr-only">90% 完成（成功）</span>
		</div>
	</div>
	<div class="progress progress-striped">
		<div class="progress-bar progress-bar-info" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 30%;">
			<span class="sr-only">30% 完成（信息）</span>
		</div>
	</div>
	<div class="progress progress-striped">
		<div class="progress-bar progress-bar-warning" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 20%;">
			<span class="sr-only">20% 完成（警告）</span>
		</div>
	</div>
	<div class="progress progress-striped">
		<div class="progress-bar progress-bar-danger" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 10%;">
			<span class="sr-only">10% 完成（危险）</span>
		</div>
	</div>
	
	<!-- 
	动画的进度条
	创建一个动画的进度条的步骤如下：
	添加一个带有 class .progress 和 .progress-striped 的 <div>。同时添加 class .active。
	接着，在上面的 <div> 内，添加一个带有 class .progress-bar 的空的 <div>。
	添加一个带有百分比表示的宽度的 style 属性，例如 style="60%"; 表示进度条在 60% 的位置。
	这将会使条纹具有从右向左的运动感。
	 -->
	<div class="progress progress-striped active">
		<div class="progress-bar progress-bar-success" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 40%;">
			<span class="sr-only">40% 完成</span>
		</div>
	</div>
	
	<!-- 
	堆叠的进度条
	您甚至可以堆叠多个进度条。把多个进度条放在相同的 .progress 中即可实现堆叠，如下面的实例所示：
	 -->
	<div class="progress">
		<div class="progress-bar progress-bar-success" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 40%;">
			<span class="sr-only">40% 完成</span>
		</div>
		<div class="progress-bar progress-bar-info" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 30%;">
			<span class="sr-only">30% 完成（信息）</span>
		</div>
		<div class="progress-bar progress-bar-warning" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 20%;">
			<span class="sr-only">20% 完成（警告）</span>
		</div>
	</div>
</body>
</html>