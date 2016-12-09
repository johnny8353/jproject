/**
 * HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.hr;

public class HOL_M03_PageInquirProjBonusDetailInfoSrvRequest  implements java.io.Serializable {
    private com.zte.eai.Input.Input input;

    private com.zte.eai.MsgHeader.MsgHeader msgHeader;

    public HOL_M03_PageInquirProjBonusDetailInfoSrvRequest() {
    }

    public HOL_M03_PageInquirProjBonusDetailInfoSrvRequest(
           com.zte.eai.Input.Input input,
           com.zte.eai.MsgHeader.MsgHeader msgHeader) {
           this.input = input;
           this.msgHeader = msgHeader;
    }


    /**
     * Gets the input value for this HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.
     * 
     * @return input
     */
    public com.zte.eai.Input.Input getInput() {
        return input;
    }


    /**
     * Sets the input value for this HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.
     * 
     * @param input
     */
    public void setInput(com.zte.eai.Input.Input input) {
        this.input = input;
    }


    /**
     * Gets the msgHeader value for this HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.
     * 
     * @return msgHeader
     */
    public com.zte.eai.MsgHeader.MsgHeader getMsgHeader() {
        return msgHeader;
    }


    /**
     * Sets the msgHeader value for this HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.
     * 
     * @param msgHeader
     */
    public void setMsgHeader(com.zte.eai.MsgHeader.MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HOL_M03_PageInquirProjBonusDetailInfoSrvRequest)) return false;
        HOL_M03_PageInquirProjBonusDetailInfoSrvRequest other = (HOL_M03_PageInquirProjBonusDetailInfoSrvRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.input==null && other.getInput()==null) || 
             (this.input!=null &&
              this.input.equals(other.getInput()))) &&
            ((this.msgHeader==null && other.getMsgHeader()==null) || 
             (this.msgHeader!=null &&
              this.msgHeader.equals(other.getMsgHeader())));
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
        if (getInput() != null) {
            _hashCode += getInput().hashCode();
        }
        if (getMsgHeader() != null) {
            _hashCode += getMsgHeader().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HOL_M03_PageInquirProjBonusDetailInfoSrvRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", ">HOL_M03_PageInquirProjBonusDetailInfoSrvRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("input");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", "Input"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/Input", "Input"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgHeader");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", "MsgHeader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "MsgHeader"));
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
