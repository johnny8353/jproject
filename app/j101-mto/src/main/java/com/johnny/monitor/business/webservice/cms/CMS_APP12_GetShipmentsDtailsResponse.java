/**
 * CMS_APP12_GetShipmentsDtailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.cms;

public class CMS_APP12_GetShipmentsDtailsResponse  implements java.io.Serializable {
    private com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem[] outputCollection;

    private java.lang.String procMsg;

    private java.lang.String procStatus;

    public CMS_APP12_GetShipmentsDtailsResponse() {
    }

    public CMS_APP12_GetShipmentsDtailsResponse(
           com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem[] outputCollection,
           java.lang.String procMsg,
           java.lang.String procStatus) {
           this.outputCollection = outputCollection;
           this.procMsg = procMsg;
           this.procStatus = procStatus;
    }


    /**
     * Gets the outputCollection value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @return outputCollection
     */
    public com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem[] getOutputCollection() {
        return outputCollection;
    }


    /**
     * Sets the outputCollection value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @param outputCollection
     */
    public void setOutputCollection(com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem[] outputCollection) {
        this.outputCollection = outputCollection;
    }


    /**
     * Gets the procMsg value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @return procMsg
     */
    public java.lang.String getProcMsg() {
        return procMsg;
    }


    /**
     * Sets the procMsg value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @param procMsg
     */
    public void setProcMsg(java.lang.String procMsg) {
        this.procMsg = procMsg;
    }


    /**
     * Gets the procStatus value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this CMS_APP12_GetShipmentsDtailsResponse.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMS_APP12_GetShipmentsDtailsResponse)) return false;
        CMS_APP12_GetShipmentsDtailsResponse other = (CMS_APP12_GetShipmentsDtailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.outputCollection==null && other.getOutputCollection()==null) || 
             (this.outputCollection!=null &&
              java.util.Arrays.equals(this.outputCollection, other.getOutputCollection()))) &&
            ((this.procMsg==null && other.getProcMsg()==null) || 
             (this.procMsg!=null &&
              this.procMsg.equals(other.getProcMsg()))) &&
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus())));
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
        if (getOutputCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOutputCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOutputCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProcMsg() != null) {
            _hashCode += getProcMsg().hashCode();
        }
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMS_APP12_GetShipmentsDtailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_GetShipmentsDtailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "outputCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_OutputItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_OutputItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "procMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "procStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
