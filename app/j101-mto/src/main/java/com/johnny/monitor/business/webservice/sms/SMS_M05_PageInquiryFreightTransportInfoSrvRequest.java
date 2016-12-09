/**
 * SMS_M05_PageInquiryFreightTransportInfoSrvRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.sms;

public class SMS_M05_PageInquiryFreightTransportInfoSrvRequest  implements java.io.Serializable {
    private com.zte.eai.MsgHeader.MsgHeader msgHeader;

    private com.zte.eai.Input.Input input;

    public SMS_M05_PageInquiryFreightTransportInfoSrvRequest() {
    }

    public SMS_M05_PageInquiryFreightTransportInfoSrvRequest(
           com.zte.eai.MsgHeader.MsgHeader msgHeader,
           com.zte.eai.Input.Input input) {
           this.msgHeader = msgHeader;
           this.input = input;
    }


    /**
     * Gets the msgHeader value for this SMS_M05_PageInquiryFreightTransportInfoSrvRequest.
     * 
     * @return msgHeader
     */
    public com.zte.eai.MsgHeader.MsgHeader getMsgHeader() {
        return msgHeader;
    }


    /**
     * Sets the msgHeader value for this SMS_M05_PageInquiryFreightTransportInfoSrvRequest.
     * 
     * @param msgHeader
     */
    public void setMsgHeader(com.zte.eai.MsgHeader.MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }


    /**
     * Gets the input value for this SMS_M05_PageInquiryFreightTransportInfoSrvRequest.
     * 
     * @return input
     */
    public com.zte.eai.Input.Input getInput() {
        return input;
    }


    /**
     * Sets the input value for this SMS_M05_PageInquiryFreightTransportInfoSrvRequest.
     * 
     * @param input
     */
    public void setInput(com.zte.eai.Input.Input input) {
        this.input = input;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMS_M05_PageInquiryFreightTransportInfoSrvRequest)) return false;
        SMS_M05_PageInquiryFreightTransportInfoSrvRequest other = (SMS_M05_PageInquiryFreightTransportInfoSrvRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.msgHeader==null && other.getMsgHeader()==null) || 
             (this.msgHeader!=null &&
              this.msgHeader.equals(other.getMsgHeader()))) &&
            ((this.input==null && other.getInput()==null) || 
             (this.input!=null &&
              this.input.equals(other.getInput())));
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
        if (getMsgHeader() != null) {
            _hashCode += getMsgHeader().hashCode();
        }
        if (getInput() != null) {
            _hashCode += getInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMS_M05_PageInquiryFreightTransportInfoSrvRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", ">SMS_M05_PageInquiryFreightTransportInfoSrvRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgHeader");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "MsgHeader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "MsgHeader"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("input");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "Input"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/Input", "Input"));
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
