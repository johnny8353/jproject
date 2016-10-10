package com.johnny.webservice.client.axis1.datatype;

public class DataTypeWSImplProxy implements com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl {
  private String _endpoint = null;
  private com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl dataTypeWSImpl = null;
  
  public DataTypeWSImplProxy() {
    _initDataTypeWSImplProxy();
  }
  
  public DataTypeWSImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataTypeWSImplProxy();
  }
  
  private void _initDataTypeWSImplProxy() {
    try {
      dataTypeWSImpl = (new com.johnny.webservice.client.axis1.datatype.DataTypeWSImplServiceLocator()).getDataType1();
      if (dataTypeWSImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataTypeWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataTypeWSImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataTypeWSImpl != null)
      ((javax.xml.rpc.Stub)dataTypeWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl getDataTypeWSImpl() {
    if (dataTypeWSImpl == null)
      _initDataTypeWSImplProxy();
    return dataTypeWSImpl;
  }
  
  public boolean addStudent(com.johnny.webservice.client.axis1.datatype.Student s) throws java.rmi.RemoteException{
    if (dataTypeWSImpl == null)
      _initDataTypeWSImplProxy();
    return dataTypeWSImpl.addStudent(s);
  }
  
  public java.util.HashMap getAllStudentsMap() throws java.rmi.RemoteException{
    if (dataTypeWSImpl == null)
      _initDataTypeWSImplProxy();
    return dataTypeWSImpl.getAllStudentsMap();
  }
  
  public java.lang.Object[] getStudentsByPrice(float price) throws java.rmi.RemoteException{
    if (dataTypeWSImpl == null)
      _initDataTypeWSImplProxy();
    return dataTypeWSImpl.getStudentsByPrice(price);
  }
  
  public com.johnny.webservice.client.axis1.datatype.Student getStudentById(int id) throws java.rmi.RemoteException{
    if (dataTypeWSImpl == null)
      _initDataTypeWSImplProxy();
    return dataTypeWSImpl.getStudentById(id);
  }
  
  
}