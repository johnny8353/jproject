/**
 * AccountQueryPageMSO_Output.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.siebel;

public class AccountQueryPageMSO_Output  implements java.io.Serializable {
    private com.siebel.www.xml.Account_EMR.Account[] listOfAccount;

    public AccountQueryPageMSO_Output() {
    }

    public AccountQueryPageMSO_Output(
           com.siebel.www.xml.Account_EMR.Account[] listOfAccount) {
           this.listOfAccount = listOfAccount;
    }


    /**
     * Gets the listOfAccount value for this AccountQueryPageMSO_Output.
     * 
     * @return listOfAccount
     */
    public com.siebel.www.xml.Account_EMR.Account[] getListOfAccount() {
        return listOfAccount;
    }


    /**
     * Sets the listOfAccount value for this AccountQueryPageMSO_Output.
     * 
     * @param listOfAccount
     */
    public void setListOfAccount(com.siebel.www.xml.Account_EMR.Account[] listOfAccount) {
        this.listOfAccount = listOfAccount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountQueryPageMSO_Output)) return false;
        AccountQueryPageMSO_Output other = (AccountQueryPageMSO_Output) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOfAccount==null && other.getListOfAccount()==null) || 
             (this.listOfAccount!=null &&
              java.util.Arrays.equals(this.listOfAccount, other.getListOfAccount())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountQueryPageMSO_Output.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siebel.com/asi/", ">AccountQueryPageMSO_Output"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfAccount"));
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
