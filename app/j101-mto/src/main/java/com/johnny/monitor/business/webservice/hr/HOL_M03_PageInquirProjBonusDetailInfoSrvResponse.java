/**
 * HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.hr;

public class HOL_M03_PageInquirProjBonusDetailInfoSrvResponse  implements java.io.Serializable {
    private com.zte.eai.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse srvResponse;

    public HOL_M03_PageInquirProjBonusDetailInfoSrvResponse() {
    }

    public HOL_M03_PageInquirProjBonusDetailInfoSrvResponse(
           com.zte.eai.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse srvResponse) {
           this.srvResponse = srvResponse;
    }


    /**
     * Gets the srvResponse value for this HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.
     * 
     * @return srvResponse
     */
    public com.zte.eai.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse getSrvResponse() {
        return srvResponse;
    }


    /**
     * Sets the srvResponse value for this HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.
     * 
     * @param srvResponse
     */
    public void setSrvResponse(com.zte.eai.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.HOL_M03_PageInquirProjBonusDetailInfoSrvResponse srvResponse) {
        this.srvResponse = srvResponse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HOL_M03_PageInquirProjBonusDetailInfoSrvResponse)) return false;
        HOL_M03_PageInquirProjBonusDetailInfoSrvResponse other = (HOL_M03_PageInquirProjBonusDetailInfoSrvResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.srvResponse==null && other.getSrvResponse()==null) || 
             (this.srvResponse!=null &&
              this.srvResponse.equals(other.getSrvResponse())));
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
        if (getSrvResponse() != null) {
            _hashCode += getSrvResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HOL_M03_PageInquirProjBonusDetailInfoSrvResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", ">HOL_M03_PageInquirProjBonusDetailInfoSrvResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srvResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrv/HOL_M03_PageInquirProjBonusDetailInfoSrv", "srvResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/HOL_M03_PageInquirProjBonusDetailInfoSrvResponse", "HOL_M03_PageInquirProjBonusDetailInfoSrvResponse"));
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
