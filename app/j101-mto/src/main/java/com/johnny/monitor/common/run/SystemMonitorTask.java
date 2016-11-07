package com.johnny.monitor.common.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.johnny.common.util.CommonUtil;
import com.johnny.common.util.DateUtil;
import com.johnny.common.util.FutureUtil;
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
import com.mchange.v2.collection.MapEntry;

/**
 * 类 编 号： 类 名 称：SystemMonitorThread.java 内容摘要：监控 系统 是否可用 完成日期：2016-3-25
 * 编码作者：JohnnyHuang 黄福强
 */
@Component("systemMonitorTask")
@Scope(value="prototype")
public class SystemMonitorTask  extends BaseTaskImpl implements BaseTask{
	@Autowired
	private SystemGroupService systemGroupService;
	@Autowired
	private SystemMonitorInstanceService systemMonitorInstanceService;

	MonitorService monitor = null;
	String className = null;
	Map<String,Object> params = new HashMap<>();
	String envName = null;
	private SystemListBO monitorListBO;

	public SystemMonitorTask() {
		log.info("--SystemMonitorTask construct--");
	}

	public void doTaskWakeUp(TaskVO taskvo)  {
		log.info("===========SystemMonitorThread begin===========");
		try {
			monitorSystem(taskvo.getMethod());
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
	public void executeControl() {
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable<String> call = new Callable<String>() {
			public String call() throws Exception {
				// 开始执行耗时操作
				@SuppressWarnings("rawtypes")
				Class monitClass = Class.forName(className);
				monitor = (MonitorService) monitClass.newInstance();
				monitor.execute(params);
				return envName + DateUtil.getNowDateTimeMMM() + "_线程执行完成.";
			}
		};

		try {
			Future<String> future = exec.submit(call);
			String obj = future.get(30000 * 1, TimeUnit.MILLISECONDS); // 任务处理超时时间设为
																		// 1 秒
			log.info("任务成功返回:" + obj);
		} catch (TimeoutException ex) {
			monitor.setsMessage("错误：请求超时");
			log.info("处理超时啦....");
			ex.printStackTrace();
		} catch (Exception e) {
			monitor.setsMessage("错误：处理失败");
			log.info("处理失败.");
			e.printStackTrace();
		}finally{
			// 关闭线程池
			exec.shutdown();
		}
	}

	public synchronized void monitorSystem(String frequency) {
		String batchNum = DateUtil.getNowDateTimeStr();
		try {
			if (monitorListBO == null) {//存在不读取，修改配置需要 重启
				initData();
			}
			//监控
			for (SystemBO systemBO : monitorListBO.getSystemBOList()) {
				for (SystemInfoVO systemInfoVO : systemBO.getSystemInfoVOList()) {
					String result = SysDataDictionary.MONITOR_RESULT_SUCCESS_NAME;
					StringBuffer resultMessageBuffer = new StringBuffer();
					String url = "";
					// 处理不监控数据
					if (systemInfoVO.getEnableFlag().equals("Y")) {
						SystemGroupVO groupVO = systemBO.getGroupVO();
						if (groupVO.getSysType().equals(
								SysDataDictionary.MONITOR_SYS_TYPE_DB)) {
							url = systemInfoVO.getIpAddr() + ";"
									+ systemInfoVO.getUserName() + ";"
									+ systemInfoVO.getPassWord();
						} else if (groupVO.getSysType().equals(
								SysDataDictionary.MONITOR_SYS_TYPE_APP)) {
							url = systemInfoVO.getIpAddr()
									+ StringUtil.retBlankIfNull(groupVO
											.getUrlParam());
						}
						params.put("url", url);
						className = groupVO.getClassName();
						envName = groupVO.getSysName() + "_"
								+ systemInfoVO.getEnviromentName() + "_"
								+ systemInfoVO.getIpAddr();
						
						executeControl();
						
						
						String messageString = StringUtil
								.retBlankIfNull(monitor.getsMessage());

						if (!messageString.equals("")) {
							result = SysDataDictionary.MONITOR_RESULT_FAIL_NAME;
							resultMessageBuffer.append(messageString).append("\n");
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
			log.info("--generateReport--begin");
			generateReport(batchNum);
			log.info("--generateReport--end");
			//发送邮件
			log.info("--emailNotify--begin");
			emailNotify(batchNum,frequency);
			log.info("--emailNotify--end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateReport(String batchNum) throws IOException, SQLException{
		String serverUrl= com.johnny.data.common.data.SysDataDictionary.getSysPref("JT_FILE_URL");
		String destPath = com.johnny.data.common.data.SysDataDictionary.getSysPref("JT_FILE_PATH");
		Connection conn = null;
		String htmlSufix = "/html/"+"monitorReport_"+batchNum+".html";
		try {
			conn = CommonUtil.getConnectionFromSpring("dataSource");
			//生产头报表 
			File reportFile = new File(WebUtil.getWebRootAbsolutePath()+("/jasper/monitorReport.jasper"));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_BATCH_NUM", batchNum);
			parameters.put("P_URL", serverUrl+htmlSufix);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new FileInputStream(reportFile));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
					parameters, conn);
			JasperExportUtils.exportHtml(jasperPrint,destPath+htmlSufix);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(!conn.isClosed()){
				conn.close();
			}
		}
	}
	
	public static void main(String[] args) {
//		log.info(SystemMonitorTask.class.getResource("/").getPath());
		Map<String,Object> resultMap  = new HashMap<>();
		resultMap.put("仿真", new BigInteger("1"));
		resultMap.put("生产", 1);
//		log.info(new SystemMonitorTask().getCount(resultMap,"仿真"));
	}
	
	public int getCount(Map<String,Object> resultMap,String name){
		int count = 0;
		try {
			for (Entry<String, Object> entry : resultMap.entrySet()) {
				if(entry.getKey().equals(name)){
					Object obj = entry.getValue();
					if(obj instanceof BigInteger){
						BigInteger a = (BigInteger) obj;
						count = a.intValue();
					}else{
						count = (int) obj;
					}
				}
			}
		} catch (Exception e) {
		}
		return count;
	}
	
	public void emailNotify(String batchNum,String frequency) throws IOException{
		log.info("---emailNotify---1");
		String serverUrl= com.johnny.data.common.data.SysDataDictionary.getSysPref("JT_FILE_URL");
		String destPath = com.johnny.data.common.data.SysDataDictionary.getSysPref("JT_FILE_PATH");
		String htmlSufix = "/html/"+"monitorReport_"+batchNum+".html";
		String destHtmlFile = destPath+htmlSufix;
		String clickLook = "若邮件图表显示不正常，请点击该链接查看监控结果";
		String fNameStr = "";//发送内容
		log.info("---emailNotify---2");
		//获取所有报错实例
		List<SystemGroupVO> groups = systemGroupService.findGroupList();
		String toMail = "";
		String title = "";
		StringBuffer errorEnv = new StringBuffer();
		for (SystemGroupVO systemGroupVO : groups) {
			String errString = "";
			Map<String,Object> params = new HashMap<String, Object>();
			Map<String,Object> resultMap = new HashMap<String, Object>();
			params.put("batchNum", batchNum);
			params.put("sysCode", systemGroupVO.getSysCode());
			resultMap = systemMonitorInstanceService.findErrorCountGroupByType(params);
			int devErrorCount = getCount(resultMap,SysDataDictionary.ENV_DEV_NAME) ;
			int testErrorCount = getCount(resultMap,SysDataDictionary.ENV_TEST_NAME) ;
			int recErrorCount = getCount(resultMap,SysDataDictionary.ENV_REC_NAME) ;
			int prodErrorCount = getCount(resultMap,SysDataDictionary.ENV_PROD_NAME) ;
			int totalErrorCount = devErrorCount+testErrorCount+recErrorCount+prodErrorCount;
			//每日监控
			if(frequency.equals(SysDataDictionary.MONITOR_SYS_FREQUENCE_DAY)){
				toMail += systemGroupVO.getDevMailto()+systemGroupVO.getTestMailto()+systemGroupVO.getRecMailto()+systemGroupVO.getProdMailto();
				//开发
				if (devErrorCount > 0) {
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_DEV_NAME+" ";
				}
				// 测试
				if (testErrorCount > 0) {
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_TEST_NAME+" ";
				}
				// 仿真
				if (recErrorCount > 0) {
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_REC_NAME+" ";
				}
				// 生产
				if (prodErrorCount > 0) {
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_PROD_NAME+" ";
				}
				errorEnv.append(errString);
			}else{
				if(totalErrorCount == 0) continue;
				//开发
				if (devErrorCount > 0) {
					toMail += systemGroupVO.getDevMailto();
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_DEV_NAME+" ";
				}
				// 测试
				if (testErrorCount > 0) {
					toMail += systemGroupVO.getDevMailto()+systemGroupVO.getTestMailto();
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_TEST_NAME+" ";
				}
				// 仿真
				if (recErrorCount > 0) {
					toMail += systemGroupVO.getDevMailto()+systemGroupVO.getTestMailto()+systemGroupVO.getRecMailto();
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_REC_NAME+" ";
				}
				// 生产
				if (prodErrorCount > 0) {
					toMail += systemGroupVO.getDevMailto()+systemGroupVO.getTestMailto()+systemGroupVO.getRecMailto()+systemGroupVO.getProdMailto();
					errString += systemGroupVO.getSysCode()+SysDataDictionary.ENV_PROD_NAME+" ";
				}
				errorEnv.append(errString);
			}
		}
		if(!toMail.equals("")){
			//去掉最后的空格
			if(errorEnv.toString().length()>0){
				errorEnv = new StringBuffer(errorEnv.toString().substring(0, errorEnv.toString().length()-1)) ;
			}
			fNameStr = ReadFromFile.readFileByLines(destHtmlFile);
			if(frequency.equals(SysDataDictionary.MONITOR_SYS_FREQUENCE_DAY)){
				title = "【每日服务器监控结果】 " + DateUtil.getNowDateTime();
			}else{
				title = "【服务器监控结果】 " + DateUtil.getNowDateTime();
			}
			if(!StringUtil.retBlankIfNull(errorEnv.toString()).equals("")){
				title = title+ "【"+errorEnv.toString()+"】 服务器告警，请尽快查看原因！";
			}else{
				title = title+ " 本次服务器监控正常！";
			}
			String result = ZMailUtil.invokeDPGSendTestMail(
					toMail.toString(), title, fNameStr, clickLook, serverUrl + htmlSufix);
			log.info("邮件发送结果"+result+toMail+title);
		}
	}

}
