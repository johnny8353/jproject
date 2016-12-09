package com.johnny.monitor.business.webservice.cms;

public class CMS_APP_SyncContractInfoServicePortTypeProxy implements com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType {
  private String _endpoint = null;
  private com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType cMS_APP_SyncContractInfoServicePortType = null;
  
  public CMS_APP_SyncContractInfoServicePortTypeProxy() {
    _initCMS_APP_SyncContractInfoServicePortTypeProxy();
  }
  
  public CMS_APP_SyncContractInfoServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCMS_APP_SyncContractInfoServicePortTypeProxy();
  }
  
  private void _initCMS_APP_SyncContractInfoServicePortTypeProxy() {
    try {
      cMS_APP_SyncContractInfoServicePortType = (new com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceLocator()).getCMS_APP_SyncContractInfoServiceHttpPort();
      if (cMS_APP_SyncContractInfoServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cMS_APP_SyncContractInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cMS_APP_SyncContractInfoServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cMS_APP_SyncContractInfoServicePortType != null)
      ((javax.xml.rpc.Stub)cMS_APP_SyncContractInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType getCMS_APP_SyncContractInfoServicePortType() {
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType;
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse getShipmentsDtails(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getShipmentsDtails(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse getReceiptOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getReceiptOutline(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse getConDeliveryTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getConDeliveryTermsInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse getCustomerConInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getCustomerConInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse getReceiptInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getReceiptInfoList(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse getContractOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractOutline(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse getProjectToContractSum(com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getProjectToContractSum(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse getContractPayTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractPayTermsInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse getShipmentsOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getShipmentsOutline(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse getContractMainInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractMainInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse getAfterSalesTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getAfterSalesTermsInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse getShipmentsInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getShipmentsInfoList(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse getContractStatusList(com.johnny.monitor.business.webservice.cms.CMS_APP18_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractStatusList(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse searchContractInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.searchContractInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse getContractProgressInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractProgressInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse getInvoiceOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getInvoiceOutline(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse getRoleMember(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getRoleMember(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse getProjectToContractList(com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getProjectToContractList(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse getInvoiceInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getInvoiceInfoList(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse getPrjContractInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getPrjContractInfo(in0);
  }
  
  public com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse getContractBasicInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException{
    if (cMS_APP_SyncContractInfoServicePortType == null)
      _initCMS_APP_SyncContractInfoServicePortTypeProxy();
    return cMS_APP_SyncContractInfoServicePortType.getContractBasicInfo(in0);
  }
  
  
}