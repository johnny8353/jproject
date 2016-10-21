package com.johnny.monitor.business.webservice.siebel;

public class AccountWSPortProxy implements com.johnny.monitor.business.webservice.siebel.AccountWSPort {
  private String _endpoint = null;
  private com.johnny.monitor.business.webservice.siebel.AccountWSPort accountWSPort = null;
  
  public AccountWSPortProxy() {
    _initAccountWSPortProxy();
  }
  
  public AccountWSPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountWSPortProxy();
  }
  
  private void _initAccountWSPortProxy() {
    try {
      accountWSPort = (new com.johnny.monitor.business.webservice.siebel.AccountWSLocator()).getAccountWSPort();
      if (accountWSPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountWSPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountWSPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountWSPort != null)
      ((javax.xml.rpc.Stub)accountWSPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.monitor.business.webservice.siebel.AccountWSPort getAccountWSPort() {
    if (accountWSPort == null)
      _initAccountWSPortProxy();
    return accountWSPort;
  }
  
  public com.johnny.monitor.business.webservice.siebel.AccountQueryPageMSO_Output accountQueryPageMSO(com.johnny.monitor.business.webservice.siebel.AccountQueryPageMSO_Input accountQueryPageMSO_Input) throws java.rmi.RemoteException{
    if (accountWSPort == null)
      _initAccountWSPortProxy();
    return accountWSPort.accountQueryPageMSO(accountQueryPageMSO_Input);
  }
  
  
}