package com.johnny.monitor.business.webservice.sms;

public class SMS_M05_PageInquiryFreightTransportInfoSrvProxy implements com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrv {
  private String _endpoint = null;
  private com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrv sMS_M05_PageInquiryFreightTransportInfoSrv = null;
  
  public SMS_M05_PageInquiryFreightTransportInfoSrvProxy() {
    _initSMS_M05_PageInquiryFreightTransportInfoSrvProxy();
  }
  
  public SMS_M05_PageInquiryFreightTransportInfoSrvProxy(String endpoint) {
    _endpoint = endpoint;
    _initSMS_M05_PageInquiryFreightTransportInfoSrvProxy();
  }
  
  private void _initSMS_M05_PageInquiryFreightTransportInfoSrvProxy() {
    try {
      sMS_M05_PageInquiryFreightTransportInfoSrv = (new com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrv_epLocator()).getSMS_M05_PageInquiryFreightTransportInfoSrv_pt();
      if (sMS_M05_PageInquiryFreightTransportInfoSrv != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sMS_M05_PageInquiryFreightTransportInfoSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sMS_M05_PageInquiryFreightTransportInfoSrv)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sMS_M05_PageInquiryFreightTransportInfoSrv != null)
      ((javax.xml.rpc.Stub)sMS_M05_PageInquiryFreightTransportInfoSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrv getSMS_M05_PageInquiryFreightTransportInfoSrv() {
    if (sMS_M05_PageInquiryFreightTransportInfoSrv == null)
      _initSMS_M05_PageInquiryFreightTransportInfoSrvProxy();
    return sMS_M05_PageInquiryFreightTransportInfoSrv;
  }
  
  public com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrvResponse process(com.johnny.monitor.business.webservice.sms.SMS_M05_PageInquiryFreightTransportInfoSrvRequest payload) throws java.rmi.RemoteException{
    if (sMS_M05_PageInquiryFreightTransportInfoSrv == null)
      _initSMS_M05_PageInquiryFreightTransportInfoSrvProxy();
    return sMS_M05_PageInquiryFreightTransportInfoSrv.process(payload);
  }
  
  
}