package com.johnny.ireport.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRHtmlReportConfiguration;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.save.JRHtmlSaveContributor;

public class JasperExportUtils {
	public static final String PRINT_TYPE = "print";
	public static final String PDF_TYPE = "pdf";
	public static final String PDF_VIEW_TYPE = "pdfview";
	public static final String EXCEL_TYPE = "excel";
	public static final String HTML_TYPE = "html";
	public static final String WORD_TYPE = "word";
	public static final String JASPER_EXPORT_ENCODE = "UTF-8";
	
	public static void prepareReport(JasperReport jasperReport, String type) {
		/*
		 * 如果导出的是excel，则需要去掉周围的margin
		 */
		if ("excel".equals(type))
			try {
				Field margin = JRBaseReport.class
						.getDeclaredField("leftMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				margin = JRBaseReport.class.getDeclaredField("topMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				margin = JRBaseReport.class.getDeclaredField("bottomMargin");
				margin.setAccessible(true);
				margin.setInt(jasperReport, 0);
				Field pageHeight = JRBaseReport.class
						.getDeclaredField("pageHeight");
				pageHeight.setAccessible(true);
				pageHeight.setInt(jasperReport, 2147483647);
			} catch (Exception exception) {
			}
	}

	/**
	 * 导出excel
	 */
	public static void exportExcel(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {
		/*
		 * 设置头信息
		 */
		response.setContentType("application/vnd.ms-excel");
		String fileName = request.getParameter("fileName");
		if (fileName.equals("") || fileName == null) {
			fileName = new String("未命名.xls".getBytes(JASPER_EXPORT_ENCODE), JASPER_EXPORT_ENCODE);
		}
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		ServletOutputStream ouputStream = response.getOutputStream();
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.FALSE);
		exporter.exportReport();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 导出pdf，注意此处中文问题， 1）在ireport的classpath中加入iTextAsian.jar
	 * 2）在ireport画jrxml时，pdf font name ：STSong-Light ，pdf encoding ：
	 * UniGB-UCS2-H
	 */
	public static void exportPdf(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {
		response.setContentType("application/pdf");
		String fileName = request.getParameter("fileName");
		if (fileName.equals("") || fileName == null) {
			fileName = new String("未命名.pdf".getBytes(JASPER_EXPORT_ENCODE), JASPER_EXPORT_ENCODE);
		}
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		ServletOutputStream ouputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}
	
	/**
	 * 导出pdf，注意此处中文问题， 1）在ireport的classpath中加入iTextAsian.jar
	 * 2）在ireport画jrxml时，pdf font name ：STSong-Light ，pdf encoding ：
	 * UniGB-UCS2-H
	 */
	public static void exportPdfView(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 导出html
	 */
	public static void exportHtml(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {
		response.setContentType("text/html");
		ServletOutputStream ouputStream = response.getOutputStream();
		JRHtmlExporter exporter = new JRHtmlExporter();
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
				Boolean.FALSE);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, JASPER_EXPORT_ENCODE);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.exportReport();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 导出word
	 */
	public static void exportWord(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException {
		response.setContentType("application/msword;charset=utf-8");
		String fileName = request.getParameter("fileName");
		if (fileName.equals("") || fileName == null) {
			fileName = new String("未命名.doc".getBytes(JASPER_EXPORT_ENCODE), JASPER_EXPORT_ENCODE);
		}
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		JRExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				response.getOutputStream());
		exporter.exportReport();
	}

	/**
	 * 打印
	 */
	public static void exportPrint(JasperPrint jasperPrint,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		response.setContentType("application/octet-stream");
		ServletOutputStream ouputStream = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		oos.writeObject(jasperPrint);
		oos.flush();
		oos.close();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 按照类型导出不同格式文件
	 * 
	 * @param datas
	 *            数据
	 * @param type
	 *            文件类型
	 * @param is
	 *            jasper文件的来源
	 * @param request
	 * @param response
	 */
	public static void export(Collection collection, String type,
			InputStream is, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
			prepareReport(jasperReport, type);
			JRDataSource ds = new JRBeanCollectionDataSource(collection, false);
			Map parameters = new HashMap();
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, ds);
			if (EXCEL_TYPE.equals(type)) {
				exportExcel(jasperPrint, request, response);
			} else if (PDF_TYPE.equals(type)) {
				exportPdf(jasperPrint, request, response);
			} else if (HTML_TYPE.equals(type)) {
				exportHtml(jasperPrint, request, response);
			} else if (WORD_TYPE.equals(type)) {
				exportWord(jasperPrint, request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按照类型导出不同格式文件
	 * 
	 * @param jasperPrint
	 *            数据
	 * @param type
	 *            文件类型
	 * @param request
	 * @param response
	 */
	public static void export(JasperPrint jasperPrint, String type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (EXCEL_TYPE.equals(type)) {
				exportExcel(jasperPrint, request, response);
			} else if (PDF_TYPE.equals(type)) {
				exportPdf(jasperPrint, request, response);
			}else if (PDF_VIEW_TYPE.equals(type)) {
				exportPdfView(jasperPrint, request, response);
			} else if (HTML_TYPE.equals(type)) {
				exportHtml(jasperPrint, request, response);
			} else if (WORD_TYPE.equals(type)) {
				exportWord(jasperPrint, request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
