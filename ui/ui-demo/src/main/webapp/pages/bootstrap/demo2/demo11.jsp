<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 徽章（Badges）</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
</head>
<body>
	<!-- 
	本章将讲解 Bootstrap 徽章（Badges）。徽章与标签相似，主要的区别在于徽章的边角更加圆滑。
	徽章（Badges）主要用于突出显示新的或未读的项。如需使用徽章，只需要把 <span class="badge"> 添加到链接、Bootstrap 导航等这些元素上即可。
	 -->
	 <!-- 当没有新的或未读的项时，通过 CSS 的 :empty 选择器，徽章会折叠起来，表示里边没有内容 -->
	 <a href="#">Mailbox <span class="badge">50</span></a>
	 <br>
	 <a href="#">Mailbox <span class="badge"></span></a>
	 <br>
	 <!-- 激活导航状态
	您可以在激活状态的胶囊式导航和列表导航中放置徽章。通过使用 <span class="badge"> 来激活链接，如下面的实例所示： -->
	<h4>胶囊式导航中的激活状态</h4>
	<ul class="nav nav-pills">
	   <li class="active"><a href="#">首页 <span class="badge">42</span></a></li>
	   <li><a href="#">简介</a></li>
	   <li><a href="#">消息 <span class="badge">3</span></a></li>
	</ul>
	<br>
	<h4>列表导航中的激活状态</h4>
	<ul class="nav nav-pills nav-stacked" style="max-width: 260px;">
	   <li class="active">
	      <a href="#">
	         <span class="badge pull-right">42</span>
	         首页
	      </a>
	   </li>
	   <li><a href="#">简介</a></li>
	   <li>
	      <a href="#">
	         <span class="badge pull-right">3</span>
	         消息
	      </a>
	   </li>
	</ul>
		
	
</body>
</html>