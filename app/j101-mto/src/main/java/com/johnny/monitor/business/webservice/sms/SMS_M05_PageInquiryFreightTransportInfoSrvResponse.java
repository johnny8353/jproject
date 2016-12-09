/**
 * SMS_M05_PageInquiryFreightTransportInfoSrvResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.sms;

public class SMS_M05_PageInquiryFreightTransportInfoSrvResponse  implements java.io.Serializable {
    private java.lang.String PROCESS_STATUS;

    private java.lang.String PROCESS_MESSAGE;

    private java.lang.String INSTANCE_ID;

    private java.math.BigInteger PAGE_SIZE;

    private java.math.BigInteger CURRENT_PAGE;

    private java.math.BigInteger TOTAL_RECORD;

    private java.math.BigInteger TOTAL_PAGE;

    private com.johnny.monitor.business.webservice.sms.OutputItem[] outputCollection;

    public SMS_M05_PageInquiryFreightTransportInfoSrvResponse() {
    }

    public SMS_M05_PageInquiryFreightTransportInfoSrvResponse(
           java.lang.String PROCESS_STATUS,
           java.lang.String PROCESS_MESSAGE,
           java.lang.String INSTANCE_ID,
           java.math.BigInteger PAGE_SIZE,
           java.math.BigInteger CURRENT_PAGE,
           java.math.BigInteger TOTAL_RECORD,
           java.math.BigInteger TOTAL_PAGE,
           com.johnny.monitor.business.webservice.sms.OutputItem[] outputCollection) {
           this.PROCESS_STATUS = PROCESS_STATUS;
           this.PROCESS_MESSAGE = PROCESS_MESSAGE;
           this.INSTANCE_ID = INSTANCE_ID;
           this.PAGE_SIZE = PAGE_SIZE;
           this.CURRENT_PAGE = CURRENT_PAGE;
           this.TOTAL_RECORD = TOTAL_RECORD;
           this.TOTAL_PAGE = TOTAL_PAGE;
           this.outputCollection = outputCollection;
    }


    /**
     * Gets the PROCESS_STATUS value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return PROCESS_STATUS
     */
    public java.lang.String getPROCESS_STATUS() {
        return PROCESS_STATUS;
    }


    /**
     * Sets the PROCESS_STATUS value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param PROCESS_STATUS
     */
    public void setPROCESS_STATUS(java.lang.String PROCESS_STATUS) {
        this.PROCESS_STATUS = PROCESS_STATUS;
    }


    /**
     * Gets the PROCESS_MESSAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return PROCESS_MESSAGE
     */
    public java.lang.String getPROCESS_MESSAGE() {
        return PROCESS_MESSAGE;
    }


    /**
     * Sets the PROCESS_MESSAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param PROCESS_MESSAGE
     */
    public void setPROCESS_MESSAGE(java.lang.String PROCESS_MESSAGE) {
        this.PROCESS_MESSAGE = PROCESS_MESSAGE;
    }


    /**
     * Gets the INSTANCE_ID value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return INSTANCE_ID
     */
    public java.lang.String getINSTANCE_ID() {
        return INSTANCE_ID;
    }


    /**
     * Sets the INSTANCE_ID value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param INSTANCE_ID
     */
    public void setINSTANCE_ID(java.lang.String INSTANCE_ID) {
        this.INSTANCE_ID = INSTANCE_ID;
    }


    /**
     * Gets the PAGE_SIZE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return PAGE_SIZE
     */
    public java.math.BigInteger getPAGE_SIZE() {
        return PAGE_SIZE;
    }


    /**
     * Sets the PAGE_SIZE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param PAGE_SIZE
     */
    public void setPAGE_SIZE(java.math.BigInteger PAGE_SIZE) {
        this.PAGE_SIZE = PAGE_SIZE;
    }


    /**
     * Gets the CURRENT_PAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return CURRENT_PAGE
     */
    public java.math.BigInteger getCURRENT_PAGE() {
        return CURRENT_PAGE;
    }


    /**
     * Sets the CURRENT_PAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param CURRENT_PAGE
     */
    public void setCURRENT_PAGE(java.math.BigInteger CURRENT_PAGE) {
        this.CURRENT_PAGE = CURRENT_PAGE;
    }


    /**
     * Gets the TOTAL_RECORD value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return TOTAL_RECORD
     */
    public java.math.BigInteger getTOTAL_RECORD() {
        return TOTAL_RECORD;
    }


    /**
     * Sets the TOTAL_RECORD value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param TOTAL_RECORD
     */
    public void setTOTAL_RECORD(java.math.BigInteger TOTAL_RECORD) {
        this.TOTAL_RECORD = TOTAL_RECORD;
    }


    /**
     * Gets the TOTAL_PAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return TOTAL_PAGE
     */
    public java.math.BigInteger getTOTAL_PAGE() {
        return TOTAL_PAGE;
    }


    /**
     * Sets the TOTAL_PAGE value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param TOTAL_PAGE
     */
    public void setTOTAL_PAGE(java.math.BigInteger TOTAL_PAGE) {
        this.TOTAL_PAGE = TOTAL_PAGE;
    }


    /**
     * Gets the outputCollection value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @return outputCollection
     */
    public com.johnny.monitor.business.webservice.sms.OutputItem[] getOutputCollection() {
        return outputCollection;
    }


    /**
     * Sets the outputCollection value for this SMS_M05_PageInquiryFreightTransportInfoSrvResponse.
     * 
     * @param outputCollection
     */
    public void setOutputCollection(com.johnny.monitor.business.webservice.sms.OutputItem[] outputCollection) {
        this.outputCollection = outputCollection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMS_M05_PageInquiryFreightTransportInfoSrvResponse)) return false;
        SMS_M05_PageInquiryFreightTransportInfoSrvResponse other = (SMS_M05_PageInquiryFreightTransportInfoSrvResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PROCESS_STATUS==null && other.getPROCESS_STATUS()==null) || 
             (this.PROCESS_STATUS!=null &&
              this.PROCESS_STATUS.equals(other.getPROCESS_STATUS()))) &&
            ((this.PROCESS_MESSAGE==null && other.getPROCESS_MESSAGE()==null) || 
             (this.PROCESS_MESSAGE!=null &&
              this.PROCESS_MESSAGE.equals(other.getPROCESS_MESSAGE()))) &&
            ((this.INSTANCE_ID==null && other.getINSTANCE_ID()==null) || 
             (this.INSTANCE_ID!=null &&
              this.INSTANCE_ID.equals(other.getINSTANCE_ID()))) &&
            ((this.PAGE_SIZE==null && other.getPAGE_SIZE()==null) || 
             (this.PAGE_SIZE!=null &&
              this.PAGE_SIZE.equals(other.getPAGE_SIZE()))) &&
            ((this.CURRENT_PAGE==null && other.getCURRENT_PAGE()==null) || 
             (this.CURRENT_PAGE!=null &&
              this.CURRENT_PAGE.equals(other.getCURRENT_PAGE()))) &&
            ((this.TOTAL_RECORD==null && other.getTOTAL_RECORD()==null) || 
             (this.TOTAL_RECORD!=null &&
              this.TOTAL_RECORD.equals(other.getTOTAL_RECORD()))) &&
            ((this.TOTAL_PAGE==null && other.getTOTAL_PAGE()==null) || 
             (this.TOTAL_PAGE!=null &&
              this.TOTAL_PAGE.equals(other.getTOTAL_PAGE()))) &&
            ((this.outputCollection==null && other.getOutputCollection()==null) || 
             (this.outputCollection!=null &&
              java.util.Arrays.equals(this.outputCollection, other.getOutputCollection())));
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
        if (getPROCESS_STATUS() != null) {
            _hashCode += getPROCESS_STATUS().hashCode();
        }
        if (getPROCESS_MESSAGE() != null) {
            _hashCode += getPROCESS_MESSAGE().hashCode();
        }
        if (getINSTANCE_ID() != null) {
            _hashCode += getINSTANCE_ID().hashCode();
        }
        if (getPAGE_SIZE() != null) {
            _hashCode += getPAGE_SIZE().hashCode();
        }
        if (getCURRENT_PAGE() != null) {
            _hashCode += getCURRENT_PAGE().hashCode();
        }
        if (getTOTAL_RECORD() != null) {
            _hashCode += getTOTAL_RECORD().hashCode();
        }
        if (getTOTAL_PAGE() != null) {
            _hashCode += getTOTAL_PAGE().hashCode();
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMS_M05_PageInquiryFreightTransportInfoSrvResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", ">SMS_M05_PageInquiryFreightTransportInfoSrvResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROCESS_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "PROCESS_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROCESS_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "PROCESS_MESSAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INSTANCE_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "INSTANCE_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAGE_SIZE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "PAGE_SIZE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENT_PAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "CURRENT_PAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TOTAL_RECORD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "TOTAL_RECORD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TOTAL_PAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "TOTAL_PAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "OutputCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "OutputItem"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://eai.zte.com/SMS_M05_PageInquiryFreightTransportInfoSrv", "OutputItem"));
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
