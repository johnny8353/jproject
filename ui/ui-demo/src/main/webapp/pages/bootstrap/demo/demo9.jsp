<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 排版</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	Bootstrap 使用 Helvetica Neue、 Helvetica、 Arial 和 sans-serif 作为其默认的字体栈。
	使用 Bootstrap 的排版特性，您可以创建标题、段落、列表及其他内联元素。
	 -->

	<h1>我是标题1 h1</h1>
	<h2>我是标题2 h2</h2>
	<h3>我是标题3 h3</h3>
	<h4>我是标题4 h4</h4>
	<h5>我是标题5 h5</h5>
	<h6>我是标题6 h6</h6>

	<!-- 
	内联子标题
	如果需要向任何标题添加一个内联子标题，只需要简单地在元素两旁添加 <small>，或者添加 .small class，这样子您就能得到一个字号更小的颜色更浅的文本
	 -->
	<h1>
		我是标题1 h1. <small>我是副标题1 h1</small>
	</h1>
	<h2>
		我是标题2 h2. <small>我是副标题2 h2</small>
	</h2>
	<h3>
		我是标题3 h3. <small>我是副标题3 h3</small>
	</h3>
	<h4>
		我是标题4 h4. <small>我是副标题4 h4</small>
	</h4>
	<h5>
		我是标题5 h5. <small>我是副标题5 h5</small>
	</h5>
	<h6>
		我是标题6 h6. <small>我是副标题6 h6</small>
	</h6>
	
	<!-- 
	引导主体副本
	为了给段落添加强调文本，则可以添加 class="lead"，这将得到更大更粗、行高更高的文本，如下面实例所示：
	 -->
	 
	 <h2>引导主体副本</h2>
	<p class="lead">这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。</p>
	 
	 
	 <!-- 
	 强调
	HTML 的默认强调标签 <small>（设置文本为父文本大小的 85%）、<strong>（设置文本为更粗的文本）、<em>（设置文本为斜体）。
	  -->
	<small>本行内容是在标签内</small>
	<br>
	<strong>本行内容是在标签内</strong>
	<br>
	<em>本行内容是在标签内，并呈现为斜体</em>
	<br>
	<p class="text-left">向左对齐文本</p>
	<p class="text-center">居中对齐文本</p>
	<p class="text-right">向右对齐文本</p>
	<p class="text-muted">本行内容是减弱的</p>
	<p class="text-primary">本行内容带有一个 primary class</p>
	<p class="text-success">本行内容带有一个 success class</p>
	<p class="text-info">本行内容带有一个 info class</p>
	<p class="text-warning">本行内容带有一个 warning class</p>
	<p class="text-danger">本行内容带有一个 danger class</p>
	
	<!-- 
	缩写
	HTML 元素提供了用于缩写的标记，比如 WWW 或 HTTP。Bootstrap 定义 <abbr> 元素的样式为显示在文本底部的一条虚线边框，当鼠标悬停在上面时会显示完整的文本
	（只要您为 <abbr> title 属性添加了文本）。为了得到一个更小字体的文本，请添加 .initialism 到 <abbr>。
	 -->
	<abbr title="World Wide Web">WWW</abbr><br>
	<abbr title="Real Simple Syndication" class="initialism">RSS</abbr><br>
	 
	 
	<!-- 
	地址（Address）
	使用 <address> 标签，您可以在网页上显示联系信息。由于 <address> 默认为 display:block;，您需要使用 
	标签来为封闭的地址文本添加换行。
	 -->
	<address>
	  <strong>Some Company, Inc.</strong><br>
	  007 street<br>
	  Some City, State XXXXX<br>
	  <abbr title="Phone">P:</abbr> (123) 456-7890
	</address>
	
	<address>
	  <strong>Full Name</strong><br>
	  <a href="mailto:#">mailto@somedomain.com</a>
	</address>
		
	<!-- 
	引用（Blockquote）
	您可以在任意的 HTML 文本旁使用默认的 <blockquote>。其他选项包括，添加一个 <small> 标签来标识引用的来源，使用 class .pull-right 向右对齐引用。下面的实例演示了这些特性：
	 -->
	<blockquote><p>
	这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。这是一个默认的引用实例。</p></blockquote>
	<blockquote>这是一个带有源标题的引用。<small>Someone famous in <cite title="Source Title">Source Title</cite></small></blockquote>
	<blockquote class="pull-right">这是一个向右对齐的引用。<small>Someone famous in <cite title="Source Title">Source Title</cite></small></blockquote>
		 
	 <!-- 
	 列表
		Bootstrap 支持有序列表、无序列表和定义列表。
		有序列表：有序列表是指以数字或其他有序字符开头的列表。
		无序列表：无序列表是指没有特定顺序的列表，是以传统风格的着重号开头的列表。如果您不想显示这些着重号，您可以使用 class .list-unstyled 来移除样式。
		您也可以通过使用 class .list-inline 把所有的列表项放在同一行中。
		定义列表：在这种类型的列表中，每个列表项可以包含 <dt> 和 <dd> 元素。<dt> 代表 定义术语，就像字典，这是被定义的属于（或短语）。
		接着，<dd> 是 <dt> 的描述。您可以使用 class dl-horizontal 把 <dl> 行中的属于与描述并排显示。
	  -->
	<h4>有序列表</h4>
	<ol>
		<li>Item 1</li>
		<li>Item 2</li>
		<li>Item 3</li>
		<li>Item 4</li>
	</ol>
	<h4>无序列表</h4>
	<ul>
		<li>Item 1</li>
		<li>Item 2</li>
		<li>Item 3</li>
		<li>Item 4</li>
	</ul>
	<h4>未定义样式列表</h4>
	<ul class="list-unstyled">
		<li>Item 1</li>
		<li>Item 2</li>
		<li>Item 3</li>
		<li>Item 4</li>
	</ul>
	<h4>内联列表</h4>
	<ul class="list-inline">
		<li>Item 1</li>
		<li>Item 2</li>
		<li>Item 3</li>
		<li>Item 4</li>
	</ul>
	<h4>定义列表</h4>
	<dl>
		<dt>Description 1</dt>
		<dd>Item 1</dd>
		<dt>Description 2</dt>
		<dd>Item 2</dd>
	</dl>
	<h4>水平的定义列表</h4>
	<dl class="dl-horizontal">
		<dt>Description 1</dt>
		<dd>Item 1</dd>
		<dt>Description 2</dt>
		<dd>Item 2</dd>
	</dl>
	
	
</body>
</html>