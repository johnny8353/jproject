/**
 * CMS_APP05_GetAfterSalesTermsInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.cms;

public class CMS_APP05_GetAfterSalesTermsInfoResponse  implements java.io.Serializable {
    private java.lang.String currentPage;

    private com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem[] outputCollection;

    private java.lang.String pageSize;

    private java.lang.String procMsg;

    private java.lang.String procStatus;

    private java.lang.String totalPage;

    private java.lang.String totalRecord;

    public CMS_APP05_GetAfterSalesTermsInfoResponse() {
    }

    public CMS_APP05_GetAfterSalesTermsInfoResponse(
           java.lang.String currentPage,
           com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem[] outputCollection,
           java.lang.String pageSize,
           java.lang.String procMsg,
           java.lang.String procStatus,
           java.lang.String totalPage,
           java.lang.String totalRecord) {
           this.currentPage = currentPage;
           this.outputCollection = outputCollection;
           this.pageSize = pageSize;
           this.procMsg = procMsg;
           this.procStatus = procStatus;
           this.totalPage = totalPage;
           this.totalRecord = totalRecord;
    }


    /**
     * Gets the currentPage value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return currentPage
     */
    public java.lang.String getCurrentPage() {
        return currentPage;
    }


    /**
     * Sets the currentPage value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param currentPage
     */
    public void setCurrentPage(java.lang.String currentPage) {
        this.currentPage = currentPage;
    }


    /**
     * Gets the outputCollection value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return outputCollection
     */
    public com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem[] getOutputCollection() {
        return outputCollection;
    }


    /**
     * Sets the outputCollection value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param outputCollection
     */
    public void setOutputCollection(com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem[] outputCollection) {
        this.outputCollection = outputCollection;
    }


    /**
     * Gets the pageSize value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return pageSize
     */
    public java.lang.String getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.String pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the procMsg value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return procMsg
     */
    public java.lang.String getProcMsg() {
        return procMsg;
    }


    /**
     * Sets the procMsg value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param procMsg
     */
    public void setProcMsg(java.lang.String procMsg) {
        this.procMsg = procMsg;
    }


    /**
     * Gets the procStatus value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }


    /**
     * Gets the totalPage value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return totalPage
     */
    public java.lang.String getTotalPage() {
        return totalPage;
    }


    /**
     * Sets the totalPage value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param totalPage
     */
    public void setTotalPage(java.lang.String totalPage) {
        this.totalPage = totalPage;
    }


    /**
     * Gets the totalRecord value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @return totalRecord
     */
    public java.lang.String getTotalRecord() {
        return totalRecord;
    }


    /**
     * Sets the totalRecord value for this CMS_APP05_GetAfterSalesTermsInfoResponse.
     * 
     * @param totalRecord
     */
    public void setTotalRecord(java.lang.String totalRecord) {
        this.totalRecord = totalRecord;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CMS_APP05_GetAfterSalesTermsInfoResponse)) return false;
        CMS_APP05_GetAfterSalesTermsInfoResponse other = (CMS_APP05_GetAfterSalesTermsInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currentPage==null && other.getCurrentPage()==null) || 
             (this.currentPage!=null &&
              this.currentPage.equals(other.getCurrentPage()))) &&
            ((this.outputCollection==null && other.getOutputCollection()==null) || 
             (this.outputCollection!=null &&
              java.util.Arrays.equals(this.outputCollection, other.getOutputCollection()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.procMsg==null && other.getProcMsg()==null) || 
             (this.procMsg!=null &&
              this.procMsg.equals(other.getProcMsg()))) &&
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus()))) &&
            ((this.totalPage==null && other.getTotalPage()==null) || 
             (this.totalPage!=null &&
              this.totalPage.equals(other.getTotalPage()))) &&
            ((this.totalRecord==null && other.getTotalRecord()==null) || 
             (this.totalRecord!=null &&
              this.totalRecord.equals(other.getTotalRecord())));
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
        if (getCurrentPage() != null) {
            _hashCode += getCurrentPage().hashCode();
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
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getProcMsg() != null) {
            _hashCode += getProcMsg().hashCode();
        }
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        if (getTotalPage() != null) {
            _hashCode += getTotalPage().hashCode();
        }
        if (getTotalRecord() != null) {
            _hashCode += getTotalRecord().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CMS_APP05_GetAfterSalesTermsInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_GetAfterSalesTermsInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "currentPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "outputCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_OutputItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_OutputItem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "pageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "totalPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "totalRecord"));
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
