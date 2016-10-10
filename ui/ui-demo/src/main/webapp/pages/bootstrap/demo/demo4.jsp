<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 实例 - 中型和大型设备</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
		在大型设备上，您最后设计成 33%/66%。所以我们要做的是准备好在断点处更改列的宽度：
		<div class="col-md-6 col-lg-4">....</div>
		<div class="col-md-6 col-lg-8">....</div>
		现在 Bootstrap 在中型设备中，会查找带有 md 的类，并使用它们。在大型设备中，会查找带有 lg 的类，并使用它们。
		在本实例中，我们的 2 个 div 将从 50%/50% 分割转变为 33%/66%。
	 -->
	<div class="container">
		<h1>Hello, world!</h1>

		<div class="row">

			<div class="col-md-6 col-lg-4"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat.</p>

				<p>Sed ut perspiciatis unde omnis iste natus error sit
					voluptatem accusantium doloremque laudantium, totam rem aperiam,
					eaque ipsa quae ab illo inventore veritatis et quasi architecto
					beatae vitae dicta sunt explicabo.</p>
			</div>

			<div class="col-md-6 col-lg-8"
				style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				<p>Sed ut perspiciatis unde omnis iste natus error sit
					voluptatem accusantium doloremque laudantium.</p>

				<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit
					amet, consectetur, adipisci velit, sed quia non numquam eius modi
					tempora incidunt ut labore et dolore magnam aliquam quaerat
					voluptatem.</p>
			</div>
		</div>
	</div>
</body>
</html>