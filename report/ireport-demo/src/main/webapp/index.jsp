<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	HelloWorld!!ireport
	<br />

	<a href="${pageContext.request.contextPath}/reportRun.jsp">hello</a>
	<br />
	<a href="${pageContext.request.contextPath}/exportPDF.jsp">exportPDF</a>

	<br />
	<h3>
		<a href="JRExportServlet?type=pdfview&fileName=UserReport.pdf">PDF文件查看</a>
	</h3>
	<h3>
		<a href="JRExportServlet?type=pdf&fileName=UserReport.pdf">导出PDF文件</a>
	</h3>
	<h3>
		<a href="JRExportServlet?type=excel&fileName=UserReport.xls">导出EXL文件</a>
	</h3>
	<h3>
		<a href="JRExportServlet?type=word&fileName=UserReport.doc">导出word文件</a>
	</h3>
	<h3>
		<a href="JRExportServlet?type=html&fileName=UserReport.html">html文件</a>
	</h3>
	<br>
	<h3>
		<a href="JRHTMLServlet">Servlet中生成HTML</a>&nbsp;&nbsp;&nbsp; <a
			href="jsp/htmlView.jsp">JSP中生成HTML</a>&nbsp;&nbsp;&nbsp; <a
			href="jsp/viewer.jsp">JSP中生成报表显示</a>
	</h3>
	<br>
</body>
</html>