<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 辅助类</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
	<!-- 
	
	本章将讨论 Bootstrap 中的一些可能会派上用场的辅助类。
	文本
		以下不同的类展示了不同的文本颜色。如果文本是个链接鼠标移动到文本上会变暗：
		类			描述	实例
		.text-muted	"text-muted" 类的文本样式	
		.text-primary	"text-primary" 类的文本样式	
		.text-success	"text-success" 类的文本样式	
		.text-info	"text-info" 类的文本样式	
		.text-warning	"text-warning" 类的文本样式	
		.text-danger	"text-danger" 类的文本样式	
	背景
	以下不同的类展示了不同的背景颜色。 如果文本是个链接鼠标移动到文本上会变暗：
		类	描述	实例
		.bg-primary	表格单元格使用了 "bg-primary" 类	
		.bg-success	表格单元格使用了 "bg-success" 类	
		.bg-info	表格单元格使用了 "bg-info" 类	
		.bg-warning	表格单元格使用了 "bg-warning" 类	
		.bg-danger	表格单元格使用了 "bg-danger" 类	
	其他
		类	描述	实例
		.pull-left	元素浮动到左边	
		.pull-right	元素浮动到右边	
		.center-block	设置元素为 display:block 并居中显示	
		.clearfix	清除浮动	
		.show	强制元素显示	
		.hidden	强制元素隐藏	
		.sr-only	除了屏幕阅读器外，其他设备上隐藏元素	
		.sr-only-focusable	与 .sr-only 类结合使用，在元素获取焦点时显示(如：键盘操作的用户)	
		.text-hide	将页面元素所包含的文本内容替换为背景图	
		.close	显示关闭按钮	
		.caret	显示下拉式功能
	 -->
<body>
	<!-- 使用通用的关闭图标来关闭模态框和警告框。使用 class close 得到关闭图标。 -->
	<p>
		关闭图标实例
		<button type="button" class="close" aria-hidden="true">
			&times;</button>
	</p>
	
	<!-- 使用插入符表示下拉功能和方向。使用带有 class caret 的 <span> 元素得到该功能。 -->
	<p>
		插入符实例 <span class="caret"></span>
	</p>

	<!-- 
	快速浮动
	您可以分别使用 class pull-left 或 pull-right 来把元素向左或向右浮动。下面的实例演示了这点。
	 -->
	<div class="pull-left">向左快速浮动</div>
	<div class="pull-right">向右快速浮动</div>

	<!-- 
	内容居中
	使用 class center-block 来居中元素。
	 -->
	<div class="row">
		<div class="center-block"
			style="width: 200px; background-color: #ccc;">这是 center-block
			实例</div>
	</div>
	
	<!-- 
	清除浮动
	如需清除元素的浮动，请使用 .clearfix class。
	 -->

	<div class="clearfix"
		style="background: #D8D8D8; border: 1px solid #000; padding: 10px;">
		<div class="pull-left" style="background: #58D3F7;">向左快速浮动</div>
		<div class="pull-right" style="background: #DA81F5;">向右快速浮动</div>
	</div>
	
	<!-- 
	显示和隐藏内容
	您可以通过使用 class .show 和 .hidden 来强行设置元素显示或隐藏（包括屏幕阅读器）。
	 -->
	<div class="row" style="padding: 91px 100px 19px 50px;">
		<div class="show"
			style="left-margin: 10px; width: 300px; background-color: #ccc;">
			这是 show class 的实例</div>
		<div class="hidden" style="width: 200px; background-color: #ccc;">
			这是 hide class 的实例</div>
	</div>

	<!-- 
	屏幕阅读器
	您可以通过使用 class .sr-only 来把元素对所有设备隐藏，除了屏幕阅读器。
	 -->
	<div class="row" style="padding: 91px 100px 19px 50px;">
		<form class="form-inline" role="form">
			<div class="form-group">
				<label class="sr-only" for="email">Email 地址</label> <input
					type="email" class="form-control" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label class="sr-only" for="pass">密码</label> <input type="password"
					class="form-control" placeholder="Password">
			</div>
		</form>
	</div>
</body>
</html>