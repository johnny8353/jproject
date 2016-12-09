/**
 * CMS_APP_SyncContractInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.cms;

public class CMS_APP_SyncContractInfoServiceLocator extends org.apache.axis.client.Service implements com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoService {

    public CMS_APP_SyncContractInfoServiceLocator() {
    }


    public CMS_APP_SyncContractInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CMS_APP_SyncContractInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CMS_APP_SyncContractInfoServiceHttpPort
    private java.lang.String CMS_APP_SyncContractInfoServiceHttpPort_address = "http://cmstest.zte.com.cn:7780/ztebts/services/CMS_APP_SyncContractInfoService";

    public java.lang.String getCMS_APP_SyncContractInfoServiceHttpPortAddress() {
        return CMS_APP_SyncContractInfoServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName = "CMS_APP_SyncContractInfoServiceHttpPort";

    public java.lang.String getCMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName() {
        return CMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName;
    }

    public void setCMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName(java.lang.String name) {
        CMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName = name;
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType getCMS_APP_SyncContractInfoServiceHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CMS_APP_SyncContractInfoServiceHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCMS_APP_SyncContractInfoServiceHttpPort(endpoint);
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType getCMS_APP_SyncContractInfoServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceHttpBindingStub _stub = new com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceHttpBindingStub(portAddress, this);
            _stub.setPortName(getCMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCMS_APP_SyncContractInfoServiceHttpPortEndpointAddress(java.lang.String address) {
        CMS_APP_SyncContractInfoServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceHttpBindingStub _stub = new com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServiceHttpBindingStub(new java.net.URL(CMS_APP_SyncContractInfoServiceHttpPort_address), this);
                _stub.setPortName(getCMS_APP_SyncContractInfoServiceHttpPortWSDDServiceName());
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
        if ("CMS_APP_SyncContractInfoServiceHttpPort".equals(inputPortName)) {
            return getCMS_APP_SyncContractInfoServiceHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CMS_APP_SyncContractInfoServiceHttpPort".equals(portName)) {
            setCMS_APP_SyncContractInfoServiceHttpPortEndpointAddress(address);
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
