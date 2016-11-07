package com.johnny.monitor.business.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.common.data.SysDataDictionary;

public class MonitorWasServer extends MonitorService{
	protected Log log = LogFactory.getLog(getClass());
	/**
	 * @Description: 监控WAS服务器是否可用
	 * @param @param wsUrl
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-4-26
	 */
	@Override
	public void execute(Map<String,Object> params) {
		try {
			String url = (String) params.get("url");
			String result = HttpPost("http://"+url,"","gbk");
			if(result.indexOf("SRVE")!=-1){
				throw new Exception("404 Error");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			String error = ExceptionUtil.getExceptionMessage(e);
			log.debug("错误:"+error);
			sMessage = "错误:";
			if(error.indexOf(SysDataDictionary.MSG_SERVER_CONN_REFUSED)>-1){
				sMessage = "错误:"+"WAS服务器无法访问！";
			}
			if(error.indexOf(SysDataDictionary.MSG_SERVER_404)>-1){
				sMessage = "错误:"+"应用无法访问！";
			}
			if(error.indexOf("java.net.UnknownHostException")>-1){
				sMessage = "错误:"+"地址无法访问！";
			}
			sMessage += error;
		}
	}

}
