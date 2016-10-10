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
	<!-- 
	Bootstrap 提供了一些辅助类，以便更快地实现对移动设备友好的开发。这些可以通过媒体查询结合大型、小型和中型设备，实现内容对设备的显示和隐藏。
	需要谨慎使用这些工具，避免在同一个站点创建完全不同的版本。响应式实用工具目前只适用于块和表切换。
	超小屏幕		小屏幕		中等屏幕		大屏幕
	手机 (<768px)	平板 (≥768px)	桌面 (≥992px) 桌面 (≥1200px)
	.visible-xs-*	可见	隐藏	隐藏	隐藏
	.visible-sm-*	隐藏	可见	隐藏	隐藏
	.visible-md-*	隐藏	隐藏	可见	隐藏
	.visible-lg-*	隐藏	隐藏	隐藏	可见
	.hidden-xs		隐藏	可见	可见	可见
	.hidden-sm		可见	隐藏	可见	可见
	.hidden-md		可见	可见	隐藏	可见
	.hidden-lg		可见	可见	可见	隐藏
	 -->
</head>
<body>
	<div class="container" style="padding: 40px;">
		<div class="row visible-on">
			<div class="col-xs-6 col-sm-3"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<span class="hidden-xs">特别小型</span> <span class="visible-xs">✔
					在特别小型设备上可见</span>
			</div>
			<div class="col-xs-6 col-sm-3"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<span class="hidden-sm">小型</span> <span class="visible-sm">✔
					在小型设备上可见</span>
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-xs-6 col-sm-3"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<span class="hidden-md">中型</span> <span class="visible-md">✔
					在中型设备上可见</span>
			</div>
			<div class="col-xs-6 col-sm-3"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<span class="hidden-lg">大型</span> <span class="visible-lg">✔
					在大型设备上可见</span>
			</div>
		</div>
</body>
</html>