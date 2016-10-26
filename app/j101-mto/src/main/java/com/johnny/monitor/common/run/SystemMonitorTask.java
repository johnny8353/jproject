package com.johnny.monitor.common.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnny.common.util.ContextUtil;
import com.johnny.common.util.DateUtil;
import com.johnny.common.util.ReadFromFile;
import com.johnny.common.util.StringUtil;
import com.johnny.monitor.access.vo.SystemGroupVO;
import com.johnny.monitor.access.vo.SystemInfoVO;
import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;
import com.johnny.monitor.business.service.MonitorService;
import com.johnny.monitor.business.service.SystemGroupService;
import com.johnny.monitor.business.service.SystemMonitorInstanceService;
import com.johnny.monitor.common.data.SysDataDictionary;
import com.johnny.monitor.common.util.JasperExportUtils;
import com.johnny.monitor.common.util.WebUtil;
import com.johnny.monitor.common.util.ZMailUtil;
import com.johnny.monitor.model.SystemBO;
import com.johnny.monitor.model.SystemListBO;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.run.BaseTask;
import com.johnny.task.common.run.BaseTaskImpl;

/**
 * 类 编 号： 类 名 称：SystemMonitorThread.java 内容摘要：监控 系统 是否可用 完成日期：2016-3-25
 * 编码作者：JohnnyHuang 黄福强
 */
@Component("systemMonitorTask")
public class SystemMonitorTask  extends BaseTaskImpl implements BaseTask{
	@Autowired
	private SystemGroupService systemGroupService;
	@Autowired
	private SystemMonitorInstanceService systemMonitorInstanceService;

	MonitorService monitor = null;
	String className = null;
	String param = null;
	String envName = null;

	protected Log log = LogFactory.getLog(getClass());
	private SystemListBO monitorListBO;

	public void doTaskWakeUp(TaskVO taskvo)  {
		log.info("===========SystemMonitorThread begin===========");
		try {
			// 初始化数据
			initData();
			monitorSystem("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("===========SystemMonitorThread end===========");
	}

	public void initData() {
		// 读取数据
		monitorListBO = systemGroupService.findSystemListBO();
	}

	/**
	 * 控制执行时间
	 */
	public void ExecuteControl() {
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable<String> call = new Callable<String>() {
			public String call() throws Exception {
				// 开始执行耗时操作
				@SuppressWarnings("rawtypes")
				Class monitClass = Class.forName(className);
				monitor = (MonitorService) monitClass.newInstance();
				monitor.execute(param);
				return envName + DateUtil.getNowDateTimeMMM() + "_线程执行完成.";
			}
		};

		try {
			Future<String> future = exec.submit(call);
			String obj = future.get(30000 * 1, TimeUnit.MILLISECONDS); // 任务处理超时时间设为
																		// 1 秒
			System.out.println("任务成功返回:" + obj);
		} catch (TimeoutException ex) {
			monitor.setsMessage("错误：请求超时");
			System.out.println("处理超时啦....");
			ex.printStackTrace();
		} catch (Exception e) {
			monitor.setsMessage("错误：处理失败");
			System.out.println("处理失败.");
			e.printStackTrace();
		}
		// 关闭线程池
		exec.shutdown();
	}

	public synchronized void monitorSystem(String frequency) {
		String batchNum = DateUtil.getNowDateTimeStr();
		try {
			if (monitorListBO == null) {
				initData();
			}
			for (SystemBO systemBO : monitorListBO.getSystemBOList()) {
				for (SystemInfoVO systemInfoVO : systemBO.getSystemInfoVOList()) {
					String result = SysDataDictionary.MONITOR_RESULT_SUCCESS_NAME;
					StringBuffer resultMessageBuffer = new StringBuffer();
					// 处理不监控数据
					if (systemInfoVO.getEnableFlag().equals("Y")) {
						SystemGroupVO groupVO = systemBO.getGroupVO();
						if (groupVO.getSysType().equals(
								SysDataDictionary.MONITOR_SYS_TYPE_DB)) {
							param = systemInfoVO.getIpAddr() + ";"
									+ systemInfoVO.getUserName() + ";"
									+ systemInfoVO.getPassWord();
						} else if (groupVO.getSysType().equals(
								SysDataDictionary.MONITOR_SYS_TYPE_APP)) {
							param = systemInfoVO.getIpAddr()
									+ StringUtil.retBlankIfNull(groupVO
											.getUrlParam());
						}

						className = groupVO.getClassName();
						envName = groupVO.getSysName() + "_"
								+ systemInfoVO.getEnviromentName() + "_"
								+ systemInfoVO.getIpAddr();
						
						ExecuteControl();
						String messageString = StringUtil
								.retBlankIfNull(monitor.getsMessage());

						if (!messageString.equals("")) {
							result = SysDataDictionary.MONITOR_RESULT_FAIL_NAME;
							resultMessageBuffer.append(result)
									.append(messageString).append("\n");
						}
					} else {
						result = SysDataDictionary.MONITOR_RESULT_SKIP_NAME;
					}

					// 保存实例
					SystemMonitorInstanceVO entity = new SystemMonitorInstanceVO();
					entity.setGroupId(systemBO.getGroupVO().getRowId());
					entity.setCreateDate(new Date());
					entity.setSystemId(systemInfoVO.getRowId());
					entity.setResult(result);
					int messageLength = resultMessageBuffer.toString().length();
					entity.setResultMessage(resultMessageBuffer.toString().substring(0, messageLength>10000?10000:messageLength));
					entity.setBatchNum(batchNum);
					systemMonitorInstanceService.save(entity);
				}
			}
			
			//报表生产
			generateReport(batchNum);
			//发送邮件
			emailNotify(batchNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateReport(String batchNum) throws IOException{
		String destHtmlFile = WebUtil.getWebRootAbsolutePath()+"/html/"+"monitorReport_"+batchNum+".html";
		String destHtmlUrl = "http://localhost:8077/johnny/html/"+"monitorReport_"+batchNum+".html";
//		Connection conn = null;
//		// 创建数据库连接Connection对象
//		String url = "jdbc:mysql:///mto?useUnicode=true&characterEncoding=UTF-8";
//		String user = "root";
//		String password = "1230";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			Connection conn = ContextUtil.getConnectionFromSpring("dataSource");
			//生产头报表 
			File reportFile = new File(WebUtil.getWebRootAbsolutePath()+("/jasper/monitorReport.jasper"));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_BATCH_NUM", batchNum);
			parameters.put("P_URL", destHtmlUrl);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new FileInputStream(reportFile));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
					parameters, conn);
			JasperExportUtils.exportHtml(jasperPrint,destHtmlFile);
			
			
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(SystemMonitorTask.class.getResource("/").getPath());
	}
	
	public void emailNotify(String batchNum){
		String destHtmlFile = WebUtil.getWebRootAbsolutePath()+"/html/"+"monitorReport_"+batchNum+".html";
		String fNameStr = ReadFromFile.readFileByLines(destHtmlFile);
		
		String result = ZMailUtil.invokeDPGSendTestMail("6092002318@zte.com.cn","服务器监控结果",fNameStr);
		log.info("sendmail finished-----result:"+result);
	}

	/**
	 * @Description: 监控siebel各个环境的服务器
	 * @param @return
	 * @return String
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-4-26
	 */
	public synchronized String MonitorSystem2(String frequency) {
		return "";

		// StringBuffer sbErrorResult = new StringBuffer();
		// try {
		// String
		// fNamePath=Thread.currentThread().getContextClassLoader().getResource("sytemMonitor.html").getFile();
		// String fNameStr=ReadFromFile.readFileByLines(fNamePath);
		// fNameStr=fNameStr.replace("#TEST_T16#",Env.getInstance().getProperty("SYSTEM_MONITOR_MAIL_TITLE"));
		// fNameStr=fNameStr.replace("#TEST_T9#","系统编码");
		// fNameStr=fNameStr.replace("#TEST_T10#","环境信息");
		// fNameStr=fNameStr.replace("#TEST_T11#","IP地址");
		// fNameStr=fNameStr.replace("#TEST_T12#","监控结果");
		// StringBuffer sDetail = new StringBuffer();
		// sDetail.append("<tr bgcolor='#eff'><td colspan='4'></td></tr>");
		// if(monitorListBO==null) return "";
		//
		// //获取监控结果 的html内容
		// for (int p = 0; p < monitorListBO.getMonitorBOs().size(); p++) {
		// SystemBO bo = monitorListBO.getMonitorBOs().get(p);
		// for (int i = 0; i < bo.getMonitorList().size(); i++) {
		// MonitorVO vo = bo.getMonitorList().get(i);
		// Class monitClass = Class.forName(bo.getGroupVO().getClassName());
		// IMonitor monitor = (IMonitor)monitClass.newInstance();
		// monitor.execute(vo.getIpAddr()+bo.getGroupVO().getUrlParam());
		// String messageString =
		// StringUtil.retBlankIfNull(monitor.getsMessage());
		// if(!messageString.equals("")){
		// //记录每次的故障信息
		// try{
		// LogVO logVO = new LogVO();
		// logVO.setNAME("系统监控");
		// logVO.setINV_USER(bo.getGroupVO().getGroup());
		// logVO.setMETHOD(vo.getEnviroment());
		// logVO.setDESCS(vo.getIpAddr()+monitor.getsMessage());
		// logService.insert(logVO);
		// }
		// catch(Exception e){
		// log.error(e.getMessage());
		// }
		// bo.getGroupVO().setErrorEnv(bo.getGroupVO().getErrorEnv()+vo.getEnviroment()+",");
		// sbErrorResult.append(vo.getIpAddr()+"-"+bo.getGroupVO().getGroup()+vo.getEnviroment()+"-"+monitor.getsMessage()+";");
		// }
		// String body =
		// GetMailBody(i,bo.getMonitorList().size(),bo.getGroupVO().getGroup(),vo.getEnviroment(),vo.getIpAddr(),messageString);
		// sDetail.append(body) ;
		// }
		// sDetail.append("<tr bgcolor='#eff'><td colspan='4'></td></tr>");
		// }
		// fNameStr=fNameStr.replace("#testDetail#",""+sDetail.toString());
		//
		// String title =
		// "【"+frequency+Env.getInstance().getProperty("SYSTEM_MONITOR_MAIL_TITLE")+"】"+DateUtil.getNowDateTime()+" 本次服务器监控正常！";
		// String errorEnv = new String();
		// String toMail = "";
		// //邮件接收人逻辑控制 1发送给对应接收人
		// for (int i = 0; i < monitorListBO.getMonitorBOs().size(); i++) {
		// SystemBO bo = monitorListBO.getMonitorBOs().get(i);
		// GroupVO group = bo.getGroupVO();
		// String errString = "";
		// if(!StringUtil.retBlankIfNull(bo.getGroupVO().getErrorEnv()).equals("")){
		// errString = group.getGroup()+ENV_TEST_NAME+" ";
		// toMail+=group.getTestMailto()+";";
		// if(group.getErrorEnv().indexOf(ENV_PROD_NAME)!=-1){
		// errString = group.getGroup()+ENV_PROD_NAME+" ";
		// toMail+=group.getProdMailto()+";";
		// }
		// }
		// //如果是每日监控，修改邮件接收人
		// if(frequency.equals("每日")){//发给
		// toMail += group.getTestMailto()+";"+group.getProdMailto();
		// }
		//
		// errorEnv+=(errString);
		// }
		// //去掉最后的空格
		// if(errorEnv.toString().length()>0){
		// errorEnv = errorEnv.toString().substring(0,
		// errorEnv.toString().length()-1);
		// }
		// if(!StringUtil.retBlankIfNull(errorEnv.toString()).equals("")){
		// title =
		// "【"+frequency+Env.getInstance().getProperty("SYSTEM_MONITOR_MAIL_TITLE")+"】"+DateUtil.getNowDateTime()+" 【"+errorEnv.toString()+"】服务器告警，请尽快查看原因！";
		// }
		//
		// String bodyDetail = fNameStr;
		// if(!toMail.equals("")){
		// ZMailUtil.invokeDPGSendTestMail(toMail,title,bodyDetail);
		// System.out.println(toMail);
		// }
		// sDetail = null;
		// toMail = null;
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// sbErrorResult.append(e.toString());
		// } finally {
		// }
		// return sbErrorResult.toString();

	}

	@SuppressWarnings("unused")
	private String GetMailBody(int i, int size, String group,
			String enviroment, String ipAddr, String getsMessage) {
		String result = getsMessage;
		StringBuffer sb = new StringBuffer();
		String cls = "style=\"border-bottom:1px solid #000;";
		if (i % 2 == 0) {
			cls += "background-color:#dfffdf;";
		} else {
			cls += "background-color:#ecffff;";
		}
		if (!getsMessage.equals("")) {
			cls += "color: red;";
		} else {
			cls += " color: blue;";
			result = "正常";
		}
		cls += "\"";
		sb.append("<tr  align=\"left\"  valign=\"top\"" + cls + ">");
		if (i == 0) {
			sb.append(
					"<td align=\"left\" style=\"font-size:16px;font-weight:bold;\" valign=\"middle\" rowspan="
							+ size + ">").append("" + group + "")
					.append("</td>");
		}
		sb.append("<td align=\"left\">").append("" + enviroment + "")
				.append("</td>").append("<td align=\"left\">")
				.append("" + ipAddr).append("</td>")
				.append("<td>" + result + "</td>").append("</tr>");
		cls = null;

		return sb.toString();
	}

}
