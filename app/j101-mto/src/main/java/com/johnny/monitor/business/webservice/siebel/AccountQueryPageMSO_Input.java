/**
 * AccountQueryPageMSO_Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.siebel;

public class AccountQueryPageMSO_Input  implements java.io.Serializable {
    private java.lang.String pageSize;

    private com.johnny.monitor.business.webservice.siebel.Account[] listOfAccount;

    private java.lang.String viewMode;

    private java.lang.String startRowNum;

    public AccountQueryPageMSO_Input() {
    }

    public AccountQueryPageMSO_Input(
           java.lang.String pageSize,
           com.johnny.monitor.business.webservice.siebel.Account[] listOfAccount,
           java.lang.String viewMode,
           java.lang.String startRowNum) {
           this.pageSize = pageSize;
           this.listOfAccount = listOfAccount;
           this.viewMode = viewMode;
           this.startRowNum = startRowNum;
    }


    /**
     * Gets the pageSize value for this AccountQueryPageMSO_Input.
     * 
     * @return pageSize
     */
    public java.lang.String getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this AccountQueryPageMSO_Input.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.String pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the listOfAccount value for this AccountQueryPageMSO_Input.
     * 
     * @return listOfAccount
     */
    public com.johnny.monitor.business.webservice.siebel.Account[] getListOfAccount() {
        return listOfAccount;
    }


    /**
     * Sets the listOfAccount value for this AccountQueryPageMSO_Input.
     * 
     * @param listOfAccount
     */
    public void setListOfAccount(com.johnny.monitor.business.webservice.siebel.Account[] listOfAccount) {
        this.listOfAccount = listOfAccount;
    }


    /**
     * Gets the viewMode value for this AccountQueryPageMSO_Input.
     * 
     * @return viewMode
     */
    public java.lang.String getViewMode() {
        return viewMode;
    }


    /**
     * Sets the viewMode value for this AccountQueryPageMSO_Input.
     * 
     * @param viewMode
     */
    public void setViewMode(java.lang.String viewMode) {
        this.viewMode = viewMode;
    }


    /**
     * Gets the startRowNum value for this AccountQueryPageMSO_Input.
     * 
     * @return startRowNum
     */
    public java.lang.String getStartRowNum() {
        return startRowNum;
    }


    /**
     * Sets the startRowNum value for this AccountQueryPageMSO_Input.
     * 
     * @param startRowNum
     */
    public void setStartRowNum(java.lang.String startRowNum) {
        this.startRowNum = startRowNum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountQueryPageMSO_Input)) return false;
        AccountQueryPageMSO_Input other = (AccountQueryPageMSO_Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.listOfAccount==null && other.getListOfAccount()==null) || 
             (this.listOfAccount!=null &&
              java.util.Arrays.equals(this.listOfAccount, other.getListOfAccount()))) &&
            ((this.viewMode==null && other.getViewMode()==null) || 
             (this.viewMode!=null &&
              this.viewMode.equals(other.getViewMode()))) &&
            ((this.startRowNum==null && other.getStartRowNum()==null) || 
             (this.startRowNum!=null &&
              this.startRowNum.equals(other.getStartRowNum())));
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
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getListOfAccount() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfAccount());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfAccount(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getViewMode() != null) {
            _hashCode += getViewMode().hashCode();
        }
        if (getStartRowNum() != null) {
            _hashCode += getStartRowNum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountQueryPageMSO_Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siebel.com/asi/", ">AccountQueryPageMSO_Input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/asi/", "PageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfAccount"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/asi/", "ViewMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startRowNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/asi/", "StartRowNum"));
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
