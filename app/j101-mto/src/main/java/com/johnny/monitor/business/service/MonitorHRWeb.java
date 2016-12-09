package com.johnny.monitor.business.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvRequest;
import com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator;
import com.johnny.monitor.common.data.SysDataDictionary;
import com.zte.eai.Input.Input;
import com.zte.eai.MsgHeader.MsgHeader;

public class MonitorHRWeb extends MonitorService{
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
		HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator locator = new HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator();
		try {
			String address = "http://"+url+"/soa-infra/services/HOL/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv_ep";
//			String address = "http://10.41.223.246:8001/soa-infra/services/HOL/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv_ep";
			locator.setHOL_M03_PageInquirProjBonusDetailInfoSrv_ptEndpointAddress(address);
			HOL_M03_PageInquirProjBonusDetailInfoSrvRequest request = new HOL_M03_PageInquirProjBonusDetailInfoSrvRequest(new Input(),new MsgHeader("","","","",""));
			locator.getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt().process(request);
			
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
		 new MonitorHRWeb().execute(null);
	}

	
	
}
