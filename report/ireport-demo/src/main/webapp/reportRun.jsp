<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%
	String ctxpath = request.getContextPath();

	// �������ݿ�����Connection����
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql:///activiti";
	String user = "root";
	String password = "1230";
	Connection conn = DriverManager.getConnection(url, user, password);
	// �������֮�����ɵ�.jasper�ļ��Ĵ��λ��
	File reportFile = new File(this.getServletContext().getRealPath(
			"/report1.jasper"));
	// ���ò���
	Map parameters = new HashMap();
	try {
		// ִ�б������
		JasperRunManager.runReportToHtmlFile(reportFile.getPath(),
				parameters, conn);
		response.sendRedirect(ctxpath + "/myreport.html"); // �˴���myreport�Ǳ��������
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