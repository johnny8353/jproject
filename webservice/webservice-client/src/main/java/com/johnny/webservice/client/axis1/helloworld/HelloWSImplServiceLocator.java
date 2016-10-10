/**
 * HelloWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.axis1.helloworld;

public class HelloWSImplServiceLocator extends org.apache.axis.client.Service implements com.johnny.webservice.client.axis1.helloworld.HelloWSImplService {

    public HelloWSImplServiceLocator() {
    }


    public HelloWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWS1
    private java.lang.String HelloWS1_address = "http://localhost:8077/johnny/services/HelloWS1";

    public java.lang.String getHelloWS1Address() {
        return HelloWS1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWS1WSDDServiceName = "HelloWS1";

    public java.lang.String getHelloWS1WSDDServiceName() {
        return HelloWS1WSDDServiceName;
    }

    public void setHelloWS1WSDDServiceName(java.lang.String name) {
        HelloWS1WSDDServiceName = name;
    }

    public com.johnny.webservice.client.axis1.helloworld.HelloWSImpl getHelloWS1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWS1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWS1(endpoint);
    }

    public com.johnny.webservice.client.axis1.helloworld.HelloWSImpl getHelloWS1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.johnny.webservice.client.axis1.helloworld.HelloWS1SoapBindingStub _stub = new com.johnny.webservice.client.axis1.helloworld.HelloWS1SoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloWS1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWS1EndpointAddress(java.lang.String address) {
        HelloWS1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.johnny.webservice.client.axis1.helloworld.HelloWSImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.johnny.webservice.client.axis1.helloworld.HelloWS1SoapBindingStub _stub = new com.johnny.webservice.client.axis1.helloworld.HelloWS1SoapBindingStub(new java.net.URL(HelloWS1_address), this);
                _stub.setPortName(getHelloWS1WSDDServiceName());
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
        if ("HelloWS1".equals(inputPortName)) {
            return getHelloWS1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8077/johnny/services/HelloWS1", "HelloWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8077/johnny/services/HelloWS1", "HelloWS1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWS1".equals(portName)) {
            setHelloWS1EndpointAddress(address);
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
