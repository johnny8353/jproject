package com.johnny.ireport.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.johnny.ireport.JRDataSource.PersonDataSource;

public class JRExportServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletConfig()
				.getServletContext();
		File reportFile = new File(this.getServletContext().getRealPath(
				"/jasper/preson.jasper"));

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "武汉XX科技有限公司");
		String type = request.getParameter("type");

		System.out.println(type);
		JasperPrint jasperPrint;
		try {

			InputStream is = new FileInputStream(reportFile);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
			JasperExportUtils.prepareReport(jasperReport, type);
			jasperPrint = JasperFillManager.fillReport(jasperReport,
					parameters, new PersonDataSource());

			JasperExportUtils.export(jasperPrint, type, request, response);

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
