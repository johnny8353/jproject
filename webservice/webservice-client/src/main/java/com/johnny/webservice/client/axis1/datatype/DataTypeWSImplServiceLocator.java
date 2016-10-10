/**
 * DataTypeWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.axis1.datatype;

public class DataTypeWSImplServiceLocator extends org.apache.axis.client.Service implements com.johnny.webservice.client.axis1.datatype.DataTypeWSImplService {

    public DataTypeWSImplServiceLocator() {
    }


    public DataTypeWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DataTypeWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DataType1
    private java.lang.String DataType1_address = "http://localhost:8077/johnny/services/DataType1";

    public java.lang.String getDataType1Address() {
        return DataType1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DataType1WSDDServiceName = "DataType1";

    public java.lang.String getDataType1WSDDServiceName() {
        return DataType1WSDDServiceName;
    }

    public void setDataType1WSDDServiceName(java.lang.String name) {
        DataType1WSDDServiceName = name;
    }

    public com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl getDataType1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DataType1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDataType1(endpoint);
    }

    public com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl getDataType1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.johnny.webservice.client.axis1.datatype.DataType1SoapBindingStub _stub = new com.johnny.webservice.client.axis1.datatype.DataType1SoapBindingStub(portAddress, this);
            _stub.setPortName(getDataType1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDataType1EndpointAddress(java.lang.String address) {
        DataType1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.johnny.webservice.client.axis1.datatype.DataType1SoapBindingStub _stub = new com.johnny.webservice.client.axis1.datatype.DataType1SoapBindingStub(new java.net.URL(DataType1_address), this);
                _stub.setPortName(getDataType1WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DataType1".equals(inputPortName)) {
            return getDataType1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8077/johnny/services/DataType1", "DataTypeWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8077/johnny/services/DataType1", "DataType1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DataType1".equals(portName)) {
            setDataType1EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
