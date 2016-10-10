package com.johnny.webservice.client.cxf.datatype2;

public class DataTypeWSProxy implements com.johnny.webservice.client.cxf.datatype2.DataTypeWS {
  private String _endpoint = null;
  private com.johnny.webservice.client.cxf.datatype2.DataTypeWS dataTypeWS = null;
  
  public DataTypeWSProxy() {
    _initDataTypeWSProxy();
  }
  
  public DataTypeWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataTypeWSProxy();
  }
  
  private void _initDataTypeWSProxy() {
    try {
      dataTypeWS = (new com.johnny.webservice.client.cxf.datatype2.DataTypeWSImplServiceLocator()).getDataTypeWSImplPort();
      if (dataTypeWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataTypeWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataTypeWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataTypeWS != null)
      ((javax.xml.rpc.Stub)dataTypeWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.johnny.webservice.client.cxf.datatype2.DataTypeWS getDataTypeWS() {
    if (dataTypeWS == null)
      _initDataTypeWSProxy();
    return dataTypeWS;
  }
  
  public com.johnny.webservice.client.cxf.datatype2.Student[] getStudentsByPrice(float price) throws java.rmi.RemoteException{
    if (dataTypeWS == null)
      _initDataTypeWSProxy();
    return dataTypeWS.getStudentsByPrice(price);
  }
  
  public boolean addStudent(com.johnny.webservice.client.cxf.datatype2.Student student) throws java.rmi.RemoteException{
    if (dataTypeWS == null)
      _initDataTypeWSProxy();
    return dataTypeWS.addStudent(student);
  }
  
  public com.johnny.webservice.client.cxf.datatype2.Student getStudentById(int id2) throws java.rmi.RemoteException{
    if (dataTypeWS == null)
      _initDataTypeWSProxy();
    return dataTypeWS.getStudentById(id2);
  }
  
  public com.johnny.webservice.client.cxf.datatype2.GetAllStudentsMapResponseResultEntry[] getAllStudentsMap() throws java.rmi.RemoteException{
    if (dataTypeWS == null)
      _initDataTypeWSProxy();
    return dataTypeWS.getAllStudentsMap();
  }
  
  
}