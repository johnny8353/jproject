<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bootstrap 实例 - 堆叠的水平</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

</head>
<body>
	<!-- 
	我们使用 2 个 div，并在视口宽度的中间对它们进行 50%/50% 分割：
	细节
		<div class="container">...</div> 元素被添加，确保居中和最大宽度。
		一旦添加了容器，接下来您需要考虑以行为单位。添加 <div class="row">...</div>，并在行内添加列 <div class="col-md-6"></div>。
		网格中的每一行是由 12 个单元组成的，您可以使用这些单元定义列的尺寸。在我们的实例中，有两个列，每个列由 6 个单元组成，即 6+6=12。
		
		您可以尝试其他更多的选项，比如 <div class="col-md-3"></div> 和 <div class="col-md-9"></div> 或 <div class="col-md-7"></div> 和 <div class="col-md-5"></div>。
		您可以尝试一下，但要确保总和总是 12。
	 -->
	<div class="container">
		<h1>Hello, world!</h1>

		<div class="row">

			<div class="col-md-6"
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

			<div class="col-md-6"
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