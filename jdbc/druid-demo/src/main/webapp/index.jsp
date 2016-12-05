<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	function showTime() {
		var myDate = new Date();
		var timeStr = '';
		timeStr += myDate.getFullYear() + '-'; //获取完整的年份(4位,1970-????)
		timeStr += myDate.getMonth() + '-'; //获取当前月份(0-11,0代表1月)
		timeStr += myDate.getDate() + ' '; //获取当前日(1-31)
		timeStr += myDate.getHours() + ':'; //获取当前小时数(0-23)
		timeStr += myDate.getMinutes() + ':'; //获取当前分钟数(0-59)
		timeStr += myDate.getSeconds(); //获取当前秒数(0-59)
		return timeStr
	}
	$(document).ready(function() {
		function loadDBTestMessage() {
			$.get('servlet/MysqlTestServlet', function(data) {
				if (typeof (data) != 'object') {
					data = eval('(' + data + ')');
				}
				var html = '[' + showTime() + ']';
				html += '创建：' + data['createResult'];
				html += '插入：' + data['insertResult'];
				html += '销毁:' + data['dropResult'];
				html += $('#message').html(html);
			});
		}

		setInterval(function() {
			loadDBTestMessage();
		}, 10000);
	});
</script>
</head>
<body>
	HelloWorld!!Druid
	<a href="${pageContext.request.contextPath}/hello">hello</a>
	<br />
	<div id="message"></div>
</body>
</html>