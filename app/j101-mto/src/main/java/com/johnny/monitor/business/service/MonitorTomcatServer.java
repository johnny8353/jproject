package com.johnny.monitor.business.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.common.data.SysDataDictionary;

public class MonitorTomcatServer extends MonitorService{
	protected Log log = LogFactory.getLog(getClass());
	/**
	 * @Description: 监控SmartSales Tomcat服务器是否可用
	 * @param @param wsUrl
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-4-26
	 */
	@Override
	public void execute(String url) {
		// TODO Auto-generated method stub
		try {
			HttpPost("http://"+url,"","utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			String error = ExceptionUtil.getExceptionMessage(e);
			log.debug("ERROR:"+error);
			sMessage = "ERROR:";
			if(error.indexOf(SysDataDictionary.MSG_SERVER_CONN_REFUSED)>-1){
				sMessage = "ERROR:"+"Tomcat服务器无法访问！";
			}
			if(error.indexOf(SysDataDictionary.MSG_SERVER_404)>-1){
				sMessage = "ERROR:"+"应用无法访问！";
			}
			if(error.indexOf("java.net.UnknownHostException")>-1){
				sMessage = "ERROR:"+"地址无法访问！";
			}
			sMessage += error;
		}
	}

}
