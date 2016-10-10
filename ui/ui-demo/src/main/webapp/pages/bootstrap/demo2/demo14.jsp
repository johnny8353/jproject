<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 警告（Alerts）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	本章将讲解警告（Alerts）以及 Bootstrap 所提供的用于警告的 class。警告（Alerts）向用户提供了一种定义消息样式的方式。它们为典型的用户操作提供了上下文信息反馈。
	您可以为警告框添加一个可选的关闭按钮。为了创建一个内联的可取消的警告框，请使用 警告（Alerts） jQuery 插件。
	您可以通过创建一个 <div>，并向其添加一个 .alert class 和四个上下文 class（即 .alert-success、.alert-info、.alert-warning、.alert-danger）之一，
	来添加一个基本的警告框。下面的实例演示了这点：
	 -->
	<div class="alert alert-success">成功！很好地完成了提交。</div>
	<div class="alert alert-info">信息！请注意这个信息。</div>
	<div class="alert alert-warning">警告！请不要提交。</div>
	<div class="alert alert-danger">错误！请进行一些更改。</div>

	
	<!-- 
	可取消的警告（Dismissal Alerts）
		创建一个可取消的警告（Dismissal Alert）步骤如下：
		通过创建一个 <div>，并向其添加一个 .alert class 和四个上下文 class（即 .alert-success、.alert-info、.alert-warning、.alert-danger）之一，来添加一个基本的警告框。
		同时向上面的 <div> class 添加可选的 .alert-dismissable。
		添加一个关闭按钮。
		*请确保使用带有 data-dismiss="alert" data 属性的 <button> 元素
	 -->

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		成功！很好地完成了提交。
	</div>
	<div class="alert alert-info alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		信息！请注意这个信息。
	</div>
	<div class="alert alert-warning alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		警告！请不要提交。
	</div>
	<div class="alert alert-danger alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		错误！请进行一些更改。
	</div>

	<!-- 
	警告（Alerts）中的链接
	在警告（Alerts）中创建链接的步骤如下：
	通过创建一个 <div>，并向其添加一个 .alert class 和四个上下文 class（即 .alert-success、.alert-info、.alert-warning、.alert-danger）之一，
	来添加一个基本的警告框。
	使用 .alert-link 实体类来快速提供带有匹配颜色的链接。
	 -->
	<div class="alert alert-success">
		<a href="#" class="alert-link">成功！很好地完成了提交。</a>
	</div>
	<div class="alert alert-info">
		<a href="#" class="alert-link">信息！请注意这个信息。</a>
	</div>
	<div class="alert alert-warning">
		<a href="#" class="alert-link">警告！请不要提交。</a>
	</div>
	<div class="alert alert-danger">
		<a href="#" class="alert-link">错误！请进行一些更改。</a>
	</div>

</body>
</html>