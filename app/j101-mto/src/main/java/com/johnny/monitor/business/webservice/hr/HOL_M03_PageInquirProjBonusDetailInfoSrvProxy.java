package com.johnny.monitor.business.webservice.hr;

public class HOL_M03_PageInquirProjBonusDetailInfoSrvProxy implements com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv {
  private String _endpoint = null;
  private com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv hOL_M03_PageInquirProjBonusDetailInfoSrv = null;
  
  public HOL_M03_PageInquirProjBonusDetailInfoSrvProxy() {
    _initHOL_M03_PageInquirProjBonusDetailInfoSrvProxy();
  }
  
  public HOL_M03_PageInquirProjBonusDetailInfoSrvProxy(String endpoint) {
    _endpoint = endpoint;
    _initHOL_M03_PageInquirProjBonusDetailInfoSrvProxy();
  }
  
  private void _initHOL_M03_PageInquirProjBonusDetailInfoSrvProxy() {
    try {
      hOL_M03_PageInquirProjBonusDetailInfoSrv = (new com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator()).getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt();
      if (hOL_M03_PageInquirProjBonusDetailInfoSrv != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hOL_M03_PageInquirProjBonusDetailInfoSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hOL_M03_PageInquirProjBonusDetailInfoSrv)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hOL_M03_PageInquirProjBonusDetailInfoSrv != null)
      ((javax.xml.rpc.Stub)hOL_M03_PageInquirProjBonusDetailInfoSrv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv getHOL_M03_PageInquirProjBonusDetailInfoSrv() {
    if (hOL_M03_PageInquirProjBonusDetailInfoSrv == null)
      _initHOL_M03_PageInquirProjBonusDetailInfoSrvProxy();
    return hOL_M03_PageInquirProjBonusDetailInfoSrv;
  }
  
  public com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse process(com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvRequest payload) throws java.rmi.RemoteException{
    if (hOL_M03_PageInquirProjBonusDetailInfoSrv == null)
      _initHOL_M03_PageInquirProjBonusDetailInfoSrvProxy();
    return hOL_M03_PageInquirProjBonusDetailInfoSrv.process(payload);
  }
  
  
}