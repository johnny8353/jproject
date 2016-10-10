<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap Well</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	Well 是一种会引起内容凹陷显示或插图效果的容器 <div>。为了创建 Well，只需要简单地把内容放在带有 class .well 的 <div> 中即可。下面的实例演示了一个默认的 Well：
	 -->
	 <div class="well">您好，我在 Well 中！</div>
	 <!-- 
	 尺寸大小
	您可以使用可选类 well-lg 或 well-sm 来改变 Well 的尺寸大小。这两个类是与 .well 类结合使用的。这两个类会影响内边距（padding），根据使用的类，Well 会显示得更大或者更小。
	  -->
	<div class="well well-lg">您好，我在大的 Well 中！</div>
	<div class="well well-sm">您好，我在小的 Well 中！</div>
	  
</body>
</html>