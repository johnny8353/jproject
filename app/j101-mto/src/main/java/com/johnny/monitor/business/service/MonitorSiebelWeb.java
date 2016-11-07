package com.johnny.monitor.business.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.business.webservice.siebel.AccountWSLocator;
import com.johnny.monitor.common.data.SysDataDictionary;

public class MonitorSiebelWeb extends MonitorService{
	protected Log log = LogFactory.getLog(getClass());
	/**
	 * @Description: 调用siebel webservice判断siebel服务器是否可用
	 * @param @param wsUrl
	 * @param @return
	 * @param @throws Exception   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-4-26
	 */
	@Override
	public void execute(Map<String,Object> params) {
		String url = (String) params.get("url");
		AccountWSLocator accountWS = new AccountWSLocator();
		try {
			accountWS.setAccountWSPortEndpointAddress("http://"+url+":7780/eai_anon_chs/start.swe?SWEExtSource=AnonWebService&SweExtCmd=Execute");
			accountWS.getAccountWSPort().accountQueryPageMSO(null);
		} catch (Exception e) {
//			e.printStackTrace();
			String error = ExceptionUtil.getExceptionMessage(e);
			log.debug("错误:"+error);
			sMessage = "错误:";
			if(error.indexOf(SysDataDictionary.MSG_SERVER_500)>-1){
				sMessage = "错误:"+"Siebel 应用服务器无法访问！";
			}
			if(error.indexOf(SysDataDictionary.MSG_SERVER_CONN_REFUSED)>-1){
				sMessage = "错误:"+"Siebel Web服务器无法访问！";
			}
			if(error.indexOf("java.net.UnknownHostException")>-1){
				sMessage = "错误:"+"地址无法访问！";
			}
			if(error.indexOf(SysDataDictionary.MSG_SERVER_404)>-1){
				sMessage = "错误:"+"应用无法访问！";
			}
			sMessage += error;
			if(error.indexOf("SBL-DAT-")>-1){
				sMessage = "";
			}
			
		}finally{
			accountWS = null;
		}
	}

	
	

	
	
}
