<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 多媒体对象（Media Object）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- 
	本章我们将讲解 Bootstrap 中的多媒体对象（Media Object）。这些抽象的对象样式用于创建各种类型的组件（比如：博客评论），我们可以在组件中使用图文混排，图像可以左对齐或者右对齐。
	媒体对象可以用更少的代码来实现媒体对象与文字的混排。
		媒体对象轻量标记、易于扩展的特性是通过向简单的标记应用 class 来实现的。你可以在 HTML 标签中添加以下两种形式来设置媒体对象：
		.media：该 class 允许将媒体对象里的多媒体（图像、视频、音频）浮动到内容区块的左边或者右边。
		.media-list：如果你需要一个列表，各项内容是无序列表的一部分，可以使用该 class。可用于评论列表与文章列表。
	 -->
</head>
<body>
	<div class="media">
		<a class="pull-left" href="#"> <img class="media-object"
			src="${pageContext.request.contextPath}/images/a.jpg" alt="媒体对象">
		</a>
		<div class="media-body">
			<h4 class="media-heading">媒体标题</h4>
			这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
			这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
		</div>
	</div>
	<div class="media">
		<a class="pull-left" href="#"> <img class="media-object"
			src="${pageContext.request.contextPath}/images/a.jpg" alt="媒体对象">
		</a>
		<div class="media-body">
			<h4 class="media-heading">媒体标题</h4>
			这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
			这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
			<div class="media">
				<a class="pull-left" href="#"> <img class="media-object"
					src="${pageContext.request.contextPath}/images/a.jpg" alt="媒体对象">
				</a>
				<div class="media-body">
					<h4 class="media-heading">媒体标题</h4>
					这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
					这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
				</div>
			</div>
		</div>
	</div>


	<ul class="media-list">
		<li class="media"><a class="pull-left" href="#"> <img
				class="media-object" src="${pageContext.request.contextPath}/images/a.jpg"
				alt="通用的占位符图像">
		</a>
			<div class="media-body">
				<h4 class="media-heading">媒体标题</h4>
				<p>这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
					这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。</p>
				<!-- 嵌套的媒体对象 -->
				<div class="media">
					<a class="pull-left" href="#"> <img class="media-object"
						src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符图像">
					</a>
					<div class="media-body">
						<h4 class="media-heading">嵌套的媒体标题</h4>
						这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
						这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
						<!-- 嵌套的媒体对象 -->
						<div class="media">
							<a class="pull-left" href="#"> <img class="media-object"
								src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符图像">
							</a>
							<div class="media-body">
								<h4 class="media-heading">嵌套的媒体标题</h4>
								这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
								这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
							</div>
						</div>
					</div>
				</div>
				<!-- 嵌套的媒体对象 -->
				<div class="media">
					<a class="pull-left" href="#"> <img class="media-object"
						src="${pageContext.request.contextPath}/images/a.jpg" alt="通用的占位符图像">
					</a>
					<div class="media-body">
						<h4 class="media-heading">嵌套的媒体标题</h4>
						这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
						这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
					</div>
				</div>
			</div></li>
		<li class="media"><a class="pull-right" href="#"> <img
				class="media-object" src="${pageContext.request.contextPath}/images/a.jpg"
				alt="通用的占位符图像">
		</a>
			<div class="media-body">
				<h4 class="media-heading">媒体标题</h4>
				这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
				这是一些示例文本。这是一些示例文本。 这是一些示例文本。这是一些示例文本。
			</div></li>
	</ul>


</body>
</html>