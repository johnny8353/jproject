/**
 * DataTypeWSImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.axis1.datatype;

public interface DataTypeWSImpl extends java.rmi.Remote {
    public boolean addStudent(com.johnny.webservice.client.axis1.datatype.Student s) throws java.rmi.RemoteException;
    public java.util.HashMap getAllStudentsMap() throws java.rmi.RemoteException;
    public java.lang.Object[] getStudentsByPrice(float price) throws java.rmi.RemoteException;
    public com.johnny.webservice.client.axis1.datatype.Student getStudentById(int id) throws java.rmi.RemoteException;
}
