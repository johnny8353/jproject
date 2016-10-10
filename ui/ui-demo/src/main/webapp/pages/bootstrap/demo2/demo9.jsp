<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 分页</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	<!-- 
	分页（Pagination），是一种无序列表，Bootstrap 像处理其他界面元素一样处理分页。
	分页（Pagination）
	下表列出了 Bootstrap 提供的处理分页的 class。
	Class		描述	示例代码
	.pagination	添加该 class 来在页面上显示分页。	
		<ul class="pagination">
		  <li><a href="#">&laquo;</a></li>
		  <li><a href="#">1</a></li>
		  .......
		</ul>
	.disabled, .active	您可以自定义链接，通过使用 .disabled 来定义不可点击的链接，通过使用 .active 来指示当前的页面。	
		<ul class="pagination">
		  <li class="disabled"><a href="#">&laquo;</a></li>
		  <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
		  .......
		</ul>
	.pagination-lg, .pagination-sm	使用这些 class 来获取不同大小的项。	
		<ul class="pagination pagination-lg">...</ul>
		<ul class="pagination">...</ul>
		<ul class="pagination pagination-sm">...</ul>
	 -->
</head>
<body>
	<!-- 默认的分页 下面的实例演示了上表中所讨论的 class .pagination 的用法： -->
	<ul class="pagination">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	<br />
	<br />
	<!-- 分页的状态 下面的实例演示了上表中所讨论的 class .disabled、.active 的用法： -->
	<ul class="pagination">
		<li><a href="#">&laquo;</a></li>
		<li class="active"><a href="#">1</a></li>
		<li class="disabled"><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	<br />
	<br />
	<!-- 分页的大小  下面的实例演示了上表中所讨论的 class .pagination-* 的用法： -->

	<ul class="pagination pagination-lg">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	<br>
	<ul class="pagination">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	<br>
	<ul class="pagination pagination-sm">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	<br>

	<!-- 
	翻页（Pager）
		如果您想要创建一个简单的分页链接为用户提供导航，可通过翻页来实现。与分页链接一样，翻页也是无序列表。默认情况下，链接是居中显示。下表列出了 Bootstrap 处理翻页的 class。
		Class	描述	示例代码
		.pager	添加该 class 来获得翻页链接。	
		<ul class="pager">
		  <li><a href="#">Previous</a></li>
		  <li><a href="#">Next</a></li>
		</ul>
		.previous, .next	使用 class .previous 把链接向左对齐，使用 .next 把链接向右对齐。	
		<ul class="pager">
		  <li class="previous"><a href="#">&larr; Older</a></li>
		  <li class="next"><a href="#">Newer &rarr;</a></li>
		</ul>
		.disabled	添加该 class 来获得一个颜色变淡的外观。	
		<ul class="pager">
		  <li class="previous disabled"><a href="#">&larr; Older</a></li>
		  <li class="next"><a href="#">Newer &rarr;</a></li>
		</ul>
	 -->
	<!-- 默认的翻页 -->
	<ul class="pager">
		<li><a href="#">Previous</a></li>
		<li><a href="#">Next</a></li>
	</ul>
	<br>
	<!-- 对齐的链接 -->
	<ul class="pager">
		<li class="previous"><a href="#">&larr; Older</a></li>
		<li class="next"><a href="#">Newer &rarr;</a></li>
	</ul>
	<br>
	<!-- 翻页的状态 -->
	<ul class="pager">
		<li class="previous disabled"><a href="#">&larr; Older</a></li>
		<li class="next"><a href="#">Newer &rarr;</a></li>
	</ul>
	<br>
</body>
</html>