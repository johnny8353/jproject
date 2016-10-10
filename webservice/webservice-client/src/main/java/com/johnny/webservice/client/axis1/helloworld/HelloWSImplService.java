/**
 * HelloWSImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.axis1.helloworld;

public interface HelloWSImplService extends javax.xml.rpc.Service {
    public java.lang.String getHelloWS1Address();

    public com.johnny.webservice.client.axis1.helloworld.HelloWSImpl getHelloWS1() throws javax.xml.rpc.ServiceException;

    public com.johnny.webservice.client.axis1.helloworld.HelloWSImpl getHelloWS1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
