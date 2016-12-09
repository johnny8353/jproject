package com.johnny.monitor.business.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceLocator;
import com.johnny.monitor.business.webservice.siebel.AccountWSLocator;
import com.johnny.monitor.common.data.SysDataDictionary;

public class MonitorCMSWeb extends MonitorService{
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
		CMS_APP_SyncContractInfoServiceLocator locator = new CMS_APP_SyncContractInfoServiceLocator();
		try {
			String address = "http://"+url+"/ztebts/services/CMS_APP_SyncContractInfoService";
//			String address = "http://10.5.4.11:7780/ztebts/services/CMS_APP_SyncContractInfoService";
			locator.setCMS_APP_SyncContractInfoServiceHttpPortEndpointAddress(address );
			locator.getCMS_APP_SyncContractInfoServiceHttpPort().getContractOutline(new com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest());
			
		} catch (Exception e) {
//			e.printStackTrace();
			String error = ExceptionUtil.getExceptionMessage(e);
			log.debug("错误:"+error);
			sMessage = "错误:";
			if(error.indexOf("java.net.UnknownHostException")>-1){
				sMessage = "错误:"+"地址无法访问！";
			}
			if(error.indexOf(SysDataDictionary.MSG_SERVER_404)>-1){
				sMessage = "错误:"+"应用无法访问！";
			}
			sMessage += error;
		}finally{
			locator = null;
		}
	}

	
	public static void main(String[] args) {
		 new MonitorCMSWeb().execute(null);
	}

	
	
}
