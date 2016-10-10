package com.johnny.webservice.client.axis1.helloworld;

public class HelloWSImplProxy implements com.johnny.webservice.client.axis1.helloworld.HelloWSImpl {
  private String _endpoint = null;
  private com.johnny.webservice.client.axis1.helloworld.HelloWSImpl helloWSImpl = null;
  
  public HelloWSImplProxy() {
    _initHelloWSImplProxy();
  }
  
  public HelloWSImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWSImplProxy();
  }
  
  private void _initHelloWSImplProxy() {
    try {
      helloWSImpl = (new com.johnny.webservice.client.axis1.helloworld.HelloWSImplServiceLocator()).getHelloWS1();
      if (helloWSImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWSImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWSImpl != null)
      ((javax.xml.rpc.Stub)helloWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.webservice.client.axis1.helloworld.HelloWSImpl getHelloWSImpl() {
    if (helloWSImpl == null)
      _initHelloWSImplProxy();
    return helloWSImpl;
  }
  
  public java.lang.String sayHello(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWSImpl == null)
      _initHelloWSImplProxy();
    return helloWSImpl.sayHello(name);
  }
  
  public java.lang.String saySorry(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWSImpl == null)
      _initHelloWSImplProxy();
    return helloWSImpl.saySorry(name);
  }
  
  
}