/**
 * GetAllStudentsMapResponseResultEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.webservice.client.cxf.datatype2;

public class GetAllStudentsMapResponseResultEntry  implements java.io.Serializable {
    private java.lang.Integer key;

    private com.johnny.webservice.client.cxf.datatype2.Student value;

    public GetAllStudentsMapResponseResultEntry() {
    }

    public GetAllStudentsMapResponseResultEntry(
           java.lang.Integer key,
           com.johnny.webservice.client.cxf.datatype2.Student value) {
           this.key = key;
           this.value = value;
    }


    /**
     * Gets the key value for this GetAllStudentsMapResponseResultEntry.
     * 
     * @return key
     */
    public java.lang.Integer getKey() {
        return key;
    }


    /**
     * Sets the key value for this GetAllStudentsMapResponseResultEntry.
     * 
     * @param key
     */
    public void setKey(java.lang.Integer key) {
        this.key = key;
    }


    /**
     * Gets the value value for this GetAllStudentsMapResponseResultEntry.
     * 
     * @return value
     */
    public com.johnny.webservice.client.cxf.datatype2.Student getValue() {
        return value;
    }


    /**
     * Sets the value value for this GetAllStudentsMapResponseResultEntry.
     * 
     * @param value
     */
    public void setValue(com.johnny.webservice.client.cxf.datatype2.Student value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAllStudentsMapResponseResultEntry)) return false;
        GetAllStudentsMapResponseResultEntry other = (GetAllStudentsMapResponseResultEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAllStudentsMapResponseResultEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cxfimp2.webservice.johnny.com/", ">>getAllStudentsMapResponse>result>entry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cxfimp2.webservice.johnny.com/", "student"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
