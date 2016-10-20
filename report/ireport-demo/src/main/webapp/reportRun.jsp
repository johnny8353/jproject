<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%
	String ctxpath = request.getContextPath();

	// 创建数据库连接Connection对象
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql:///activiti";
	String user = "root";
	String password = "1230";
	Connection conn = DriverManager.getConnection(url, user, password);
	// 报表编译之后生成的.jasper文件的存放位置
	File reportFile = new File(this.getServletContext().getRealPath(
			"/report1.jasper"));
	// 设置参数
	Map parameters = new HashMap();
	try {
		// 执行报表程序
		JasperRunManager.runReportToHtmlFile(reportFile.getPath(),
				parameters, conn);
		response.sendRedirect(ctxpath + "/myreport.html"); // 此处的myreport是报表的名称
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
%>