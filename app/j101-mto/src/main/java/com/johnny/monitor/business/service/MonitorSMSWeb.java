package com.johnny.monitor.business.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrvRequest;
import com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrv_epLocator;
import com.johnny.monitor.common.data.SysDataDictionary;
import com.zte.eai.Input.Input;
import com.zte.eai.MsgHeader.MsgHeader;

public class MonitorSMSWeb extends MonitorService{
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
		SMS_M05_PageInquiryFreightTransportInfoSrv_epLocator locator = new SMS_M05_PageInquiryFreightTransportInfoSrv_epLocator();
		try {
			String address = "http://"+url+"/soa-infra/services/SMS/SMS_M05_PageInquiryFreightTransportInfoSrv/SMS_M05_PageInquiryFreightTransportInfoSrv_ep";
//			String address = "http://10.41.223.246:8001/soa-infra/services/SMS/SMS_M05_PageInquiryFreightTransportInfoSrv/SMS_M05_PageInquiryFreightTransportInfoSrv_ep";
			locator.setSMS_M05_PageInquiryFreightTransportInfoSrv_ptEndpointAddress(address);
			SMS_M05_PageInquiryFreightTransportInfoSrvRequest request = new SMS_M05_PageInquiryFreightTransportInfoSrvRequest(new MsgHeader("","","","",""),new Input());
			locator.getSMS_M05_PageInquiryFreightTransportInfoSrv_pt().process(request);
			
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
		 new MonitorSMSWeb().execute(null);
	}

	
	
}
