/**
 * HelloWS1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.axis2.helloworld3;

public class HelloWS1Locator extends org.apache.axis.client.Service implements com.johnny.webservice.client.axis2.helloworld3.HelloWS1 {

    public HelloWS1Locator() {
    }


    public HelloWS1Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWS1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWS1HttpSoap11Endpoint
    private java.lang.String HelloWS1HttpSoap11Endpoint_address = "http://localhost:8077/johnny/services/HelloWS1.HelloWS1HttpSoap11Endpoint/";

    public java.lang.String getHelloWS1HttpSoap11EndpointAddress() {
        return HelloWS1HttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWS1HttpSoap11EndpointWSDDServiceName = "HelloWS1HttpSoap11Endpoint";

    public java.lang.String getHelloWS1HttpSoap11EndpointWSDDServiceName() {
        return HelloWS1HttpSoap11EndpointWSDDServiceName;
    }

    public void setHelloWS1HttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        HelloWS1HttpSoap11EndpointWSDDServiceName = name;
    }

    public com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType getHelloWS1HttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWS1HttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWS1HttpSoap11Endpoint(endpoint);
    }

    public com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType getHelloWS1HttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.johnny.webservice.client.axis2.helloworld3.HelloWS1Soap11BindingStub _stub = new com.johnny.webservice.client.axis2.helloworld3.HelloWS1Soap11BindingStub(portAddress, this);
            _stub.setPortName(getHelloWS1HttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWS1HttpSoap11EndpointEndpointAddress(java.lang.String address) {
        HelloWS1HttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.johnny.webservice.client.axis2.helloworld3.HelloWS1Soap11BindingStub _stub = new com.johnny.webservice.client.axis2.helloworld3.HelloWS1Soap11BindingStub(new java.net.URL(HelloWS1HttpSoap11Endpoint_address), this);
                _stub.setPortName(getHelloWS1HttpSoap11EndpointWSDDServiceName());
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
        if ("HelloWS1HttpSoap11Endpoint".equals(inputPortName)) {
            return getHelloWS1HttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://helloworld.axis2.webservice.johnny.com", "HelloWS1");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://helloworld.axis2.webservice.johnny.com", "HelloWS1HttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWS1HttpSoap11Endpoint".equals(portName)) {
            setHelloWS1HttpSoap11EndpointEndpointAddress(address);
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
