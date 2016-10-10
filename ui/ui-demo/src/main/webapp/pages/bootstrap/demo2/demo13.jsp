<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 缩略图</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
	<!-- 
	大多数站点都需要在网格中布局图像、视频、文本等。Bootstrap 通过缩略图为此提供了一种简便的方式。使用 Bootstrap 创建缩略图的步骤如下：
		在图像周围添加带有 class .thumbnail 的 <a> 标签。
		这会添加四个像素的内边距（padding）和一个灰色的边框。
		当鼠标悬停在图像上时，会动画显示出图像的轮廓。
	 -->
</head>
<body>
	<div class="row">
		<div class="col-sm-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</a>
		</div>
		<div class="col-sm-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</a>
		</div>
		<div class="col-sm-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</a>
		</div>
		<div class="col-sm-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</a>
		</div>
	</div>
	
	<!-- 
	添加自定义的内容
	现在我们有了一个基本的缩略图，我们可以向缩略图添加各种 HTML 内容，比如标题、段落或按钮。具体步骤如下：
		把带有 class .thumbnail 的 <a> 标签改为 <div>。
		在该 <div> 内，您可以添加任何您想要添加的东西。由于这是一个 <div>，我们可以使用默认的基于 span 的命名规则来调整大小。
		如果您想要给多个图像进行分组，请把它们放置在一个无序列表中，且每个列表项向左浮动。
	 -->
	<div class="row">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</div>
			<div class="caption">
				<h3>缩略图标签</h3>
				<p>一些示例文本。一些示例文本。</p>
				<p>
					<a href="#" class="btn btn-primary" role="button"> 按钮 </a> <a
						href="#" class="btn btn-default" role="button"> 按钮 </a>
				</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</div>
			<div class="caption">
				<h3>缩略图标签</h3>
				<p>一些示例文本。一些示例文本。</p>
				<p>
					<a href="#" class="btn btn-primary" role="button"> 按钮 </a> <a
						href="#" class="btn btn-default" role="button"> 按钮 </a>
				</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</div>
			<div class="caption">
				<h3>缩略图标签</h3>
				<p>一些示例文本。一些示例文本。</p>
				<p>
					<a href="#" class="btn btn-primary" role="button"> 按钮 </a> <a
						href="#" class="btn btn-default" role="button"> 按钮 </a>
				</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符缩略图">
			</div>
			<div class="caption">
				<h3>缩略图标签</h3>
				<p>一些示例文本。一些示例文本。</p>
				<p>
					<a href="#" class="btn btn-primary" role="button"> 按钮 </a> <a
						href="#" class="btn btn-default" role="button"> 按钮 </a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>