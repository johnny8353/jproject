package com.johnny.webservice.client.axis2.helloworld3;

public class HelloWS1PortTypeProxy implements com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType {
  private String _endpoint = null;
  private com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType helloWS1PortType = null;
  
  public HelloWS1PortTypeProxy() {
    _initHelloWS1PortTypeProxy();
  }
  
  public HelloWS1PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWS1PortTypeProxy();
  }
  
  private void _initHelloWS1PortTypeProxy() {
    try {
      helloWS1PortType = (new com.johnny.webservice.client.axis2.helloworld3.HelloWS1Locator()).getHelloWS1HttpSoap11Endpoint();
      if (helloWS1PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWS1PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWS1PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWS1PortType != null)
      ((javax.xml.rpc.Stub)helloWS1PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType getHelloWS1PortType() {
    if (helloWS1PortType == null)
      _initHelloWS1PortTypeProxy();
    return helloWS1PortType;
  }
  
  public java.lang.String saySorry(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWS1PortType == null)
      _initHelloWS1PortTypeProxy();
    return helloWS1PortType.saySorry(name);
  }
  
  public java.lang.String getWorld() throws java.rmi.RemoteException{
    if (helloWS1PortType == null)
      _initHelloWS1PortTypeProxy();
    return helloWS1PortType.getWorld();
  }
  
  public java.lang.String sayHello(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWS1PortType == null)
      _initHelloWS1PortTypeProxy();
    return helloWS1PortType.sayHello(name);
  }
  
  
}