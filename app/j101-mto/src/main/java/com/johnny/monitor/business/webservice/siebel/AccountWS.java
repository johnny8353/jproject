/**
 * AccountWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.siebel;

public interface AccountWS extends javax.xml.rpc.Service {
    public java.lang.String getAccountWSPortAddress();

    public com.johnny.monitor.business.webservice.siebel.AccountWSPort getAccountWSPort() throws javax.xml.rpc.ServiceException;

    public com.johnny.monitor.business.webservice.siebel.AccountWSPort getAccountWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
