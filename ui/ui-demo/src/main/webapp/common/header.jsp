<%@ page language="java" import="com.johnny.ui.baisc.util.AppConstants"%>

<meta http-equiv="X-UA-Compatible" content="IE=edge"/>

<meta charset="utf-8"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var app ={
		appName: "johnny",
		appVersion:"<%=AppConstants.APP_VERSION%>",
		appPath: "<%=request.getContextPath()%>"
	};
</script>
	