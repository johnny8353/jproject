/**
 * HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.hr;

public class HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator extends org.apache.axis.client.Service implements com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv_ep {

    public HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator() {
    }


    public HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HOL_M03_PageInquirProjBonusDetailInfoSrv_epLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HOL_M03_PageInquirProjBonusDetailInfoSrv_pt
    private java.lang.String HOL_M03_PageInquirProjBonusDetailInfoSrv_pt_address = "http://10.41.223.246:8001/soa-infra/services/HOL/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv_ep";

    public java.lang.String getHOL_M03_PageInquirProjBonusDetailInfoSrv_ptAddress() {
        return HOL_M03_PageInquirProjBonusDetailInfoSrv_pt_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName = "HOL_M03_PageInquirProjBonusDetailInfoSrv_pt";

    public java.lang.String getHOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName() {
        return HOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName;
    }

    public void setHOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName(java.lang.String name) {
        HOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName = name;
    }

    public com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HOL_M03_PageInquirProjBonusDetailInfoSrv_pt_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt(endpoint);
    }

    public com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvBindingStub _stub = new com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvBindingStub(portAddress, this);
            _stub.setPortName(getHOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHOL_M03_PageInquirProjBonusDetailInfoSrv_ptEndpointAddress(java.lang.String address) {
        HOL_M03_PageInquirProjBonusDetailInfoSrv_pt_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrv.class.isAssignableFrom(serviceEndpointInterface)) {
                com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvBindingStub _stub = new com.johnny.monitor.business.webservice.hr.HOL_M03_PageInquirProjBonusDetailInfoSrvBindingStub(new java.net.URL(HOL_M03_PageInquirProjBonusDetailInfoSrv_pt_address), this);
                _stub.setPortName(getHOL_M03_PageInquirProjBonusDetailInfoSrv_ptWSDDServiceName());
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
        if ("HOL_M03_PageInquirProjBonusDetailInfoSrv_pt".equals(inputPortName)) {
            return getHOL_M03_PageInquirProjBonusDetailInfoSrv_pt();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", "HOL_M03_PageInquirProjBonusDetailInfoSrv_ep");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", "HOL_M03_PageInquirProjBonusDetailInfoSrv_pt"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HOL_M03_PageInquirProjBonusDetailInfoSrv_pt".equals(portName)) {
            setHOL_M03_PageInquirProjBonusDetailInfoSrv_ptEndpointAddress(address);
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
