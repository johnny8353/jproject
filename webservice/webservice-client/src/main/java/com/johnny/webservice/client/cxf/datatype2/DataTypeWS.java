/**
 * DataTypeWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.cxf.datatype2;

public interface DataTypeWS extends java.rmi.Remote {
    public com.johnny.webservice.client.cxf.datatype2.Student[] getStudentsByPrice(float price) throws java.rmi.RemoteException;
    public boolean addStudent(com.johnny.webservice.client.cxf.datatype2.Student student) throws java.rmi.RemoteException;
    public com.johnny.webservice.client.cxf.datatype2.Student getStudentById(int id2) throws java.rmi.RemoteException;
    public com.johnny.webservice.client.cxf.datatype2.GetAllStudentsMapResponseResultEntry[] getAllStudentsMap() throws java.rmi.RemoteException;
}
