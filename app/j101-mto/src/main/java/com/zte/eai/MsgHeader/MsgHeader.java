/**
 * MsgHeader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zte.eai.MsgHeader;

public class MsgHeader  implements java.io.Serializable {
    private java.lang.String SOURCE_SYSTEM_ID;

    private java.lang.String SOURCE_SYSTEM_NAME;

    private java.lang.String USER_ID;

    private java.lang.String USER_NAME;

    private java.lang.String SUBMIT_DATE;

    public MsgHeader() {
    }

    public MsgHeader(
           java.lang.String SOURCE_SYSTEM_ID,
           java.lang.String SOURCE_SYSTEM_NAME,
           java.lang.String USER_ID,
           java.lang.String USER_NAME,
           java.lang.String SUBMIT_DATE) {
           this.SOURCE_SYSTEM_ID = SOURCE_SYSTEM_ID;
           this.SOURCE_SYSTEM_NAME = SOURCE_SYSTEM_NAME;
           this.USER_ID = USER_ID;
           this.USER_NAME = USER_NAME;
           this.SUBMIT_DATE = SUBMIT_DATE;
    }


    /**
     * Gets the SOURCE_SYSTEM_ID value for this MsgHeader.
     * 
     * @return SOURCE_SYSTEM_ID
     */
    public java.lang.String getSOURCE_SYSTEM_ID() {
        return SOURCE_SYSTEM_ID;
    }


    /**
     * Sets the SOURCE_SYSTEM_ID value for this MsgHeader.
     * 
     * @param SOURCE_SYSTEM_ID
     */
    public void setSOURCE_SYSTEM_ID(java.lang.String SOURCE_SYSTEM_ID) {
        this.SOURCE_SYSTEM_ID = SOURCE_SYSTEM_ID;
    }


    /**
     * Gets the SOURCE_SYSTEM_NAME value for this MsgHeader.
     * 
     * @return SOURCE_SYSTEM_NAME
     */
    public java.lang.String getSOURCE_SYSTEM_NAME() {
        return SOURCE_SYSTEM_NAME;
    }


    /**
     * Sets the SOURCE_SYSTEM_NAME value for this MsgHeader.
     * 
     * @param SOURCE_SYSTEM_NAME
     */
    public void setSOURCE_SYSTEM_NAME(java.lang.String SOURCE_SYSTEM_NAME) {
        this.SOURCE_SYSTEM_NAME = SOURCE_SYSTEM_NAME;
    }


    /**
     * Gets the USER_ID value for this MsgHeader.
     * 
     * @return USER_ID
     */
    public java.lang.String getUSER_ID() {
        return USER_ID;
    }


    /**
     * Sets the USER_ID value for this MsgHeader.
     * 
     * @param USER_ID
     */
    public void setUSER_ID(java.lang.String USER_ID) {
        this.USER_ID = USER_ID;
    }


    /**
     * Gets the USER_NAME value for this MsgHeader.
     * 
     * @return USER_NAME
     */
    public java.lang.String getUSER_NAME() {
        return USER_NAME;
    }


    /**
     * Sets the USER_NAME value for this MsgHeader.
     * 
     * @param USER_NAME
     */
    public void setUSER_NAME(java.lang.String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }


    /**
     * Gets the SUBMIT_DATE value for this MsgHeader.
     * 
     * @return SUBMIT_DATE
     */
    public java.lang.String getSUBMIT_DATE() {
        return SUBMIT_DATE;
    }


    /**
     * Sets the SUBMIT_DATE value for this MsgHeader.
     * 
     * @param SUBMIT_DATE
     */
    public void setSUBMIT_DATE(java.lang.String SUBMIT_DATE) {
        this.SUBMIT_DATE = SUBMIT_DATE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsgHeader)) return false;
        MsgHeader other = (MsgHeader) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SOURCE_SYSTEM_ID==null && other.getSOURCE_SYSTEM_ID()==null) || 
             (this.SOURCE_SYSTEM_ID!=null &&
              this.SOURCE_SYSTEM_ID.equals(other.getSOURCE_SYSTEM_ID()))) &&
            ((this.SOURCE_SYSTEM_NAME==null && other.getSOURCE_SYSTEM_NAME()==null) || 
             (this.SOURCE_SYSTEM_NAME!=null &&
              this.SOURCE_SYSTEM_NAME.equals(other.getSOURCE_SYSTEM_NAME()))) &&
            ((this.USER_ID==null && other.getUSER_ID()==null) || 
             (this.USER_ID!=null &&
              this.USER_ID.equals(other.getUSER_ID()))) &&
            ((this.USER_NAME==null && other.getUSER_NAME()==null) || 
             (this.USER_NAME!=null &&
              this.USER_NAME.equals(other.getUSER_NAME()))) &&
            ((this.SUBMIT_DATE==null && other.getSUBMIT_DATE()==null) || 
             (this.SUBMIT_DATE!=null &&
              this.SUBMIT_DATE.equals(other.getSUBMIT_DATE())));
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
        if (getSOURCE_SYSTEM_ID() != null) {
            _hashCode += getSOURCE_SYSTEM_ID().hashCode();
        }
        if (getSOURCE_SYSTEM_NAME() != null) {
            _hashCode += getSOURCE_SYSTEM_NAME().hashCode();
        }
        if (getUSER_ID() != null) {
            _hashCode += getUSER_ID().hashCode();
        }
        if (getUSER_NAME() != null) {
            _hashCode += getUSER_NAME().hashCode();
        }
        if (getSUBMIT_DATE() != null) {
            _hashCode += getSUBMIT_DATE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsgHeader.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "MsgHeader"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOURCE_SYSTEM_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "SOURCE_SYSTEM_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOURCE_SYSTEM_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "SOURCE_SYSTEM_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USER_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "USER_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USER_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "USER_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBMIT_DATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/MsgHeader", "SUBMIT_DATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
