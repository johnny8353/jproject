/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.siebel;

public class Account  implements java.io.Serializable {
    private java.lang.String accountId;

    private java.lang.String accountStatus;

    private java.lang.String alias;

    private java.lang.String currencyCode;

    private java.lang.String integrationId;

    private java.lang.String location;

    private java.lang.String name;

    private java.lang.String parentAccountId;

    private java.lang.String parentAccountIntegrationId;

    private java.lang.String parentAccountLocation;

    private java.lang.String parentAccountName;

    private java.lang.String primaryOrganization;

    private java.lang.String modId;

    private com.johnny.monitor.business.webservice.siebel.RelatedContact[] listOfRelatedContact;

    private com.johnny.monitor.business.webservice.siebel.RelatedOpportunity[] listOfRelatedOpportunity;

    private com.johnny.monitor.business.webservice.siebel.RelatedServiceRequest[] listOfRelatedServiceRequest;

    private java.lang.String operation;  // attribute

    public Account() {
    }

    public Account(
           java.lang.String accountId,
           java.lang.String accountStatus,
           java.lang.String alias,
           java.lang.String currencyCode,
           java.lang.String integrationId,
           java.lang.String location,
           java.lang.String name,
           java.lang.String parentAccountId,
           java.lang.String parentAccountIntegrationId,
           java.lang.String parentAccountLocation,
           java.lang.String parentAccountName,
           java.lang.String primaryOrganization,
           java.lang.String modId,
           com.johnny.monitor.business.webservice.siebel.RelatedContact[] listOfRelatedContact,
           com.johnny.monitor.business.webservice.siebel.RelatedOpportunity[] listOfRelatedOpportunity,
           com.johnny.monitor.business.webservice.siebel.RelatedServiceRequest[] listOfRelatedServiceRequest,
           java.lang.String operation) {
           this.accountId = accountId;
           this.accountStatus = accountStatus;
           this.alias = alias;
           this.currencyCode = currencyCode;
           this.integrationId = integrationId;
           this.location = location;
           this.name = name;
           this.parentAccountId = parentAccountId;
           this.parentAccountIntegrationId = parentAccountIntegrationId;
           this.parentAccountLocation = parentAccountLocation;
           this.parentAccountName = parentAccountName;
           this.primaryOrganization = primaryOrganization;
           this.modId = modId;
           this.listOfRelatedContact = listOfRelatedContact;
           this.listOfRelatedOpportunity = listOfRelatedOpportunity;
           this.listOfRelatedServiceRequest = listOfRelatedServiceRequest;
           this.operation = operation;
    }


    /**
     * Gets the accountId value for this Account.
     * 
     * @return accountId
     */
    public java.lang.String getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this Account.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.String accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the accountStatus value for this Account.
     * 
     * @return accountStatus
     */
    public java.lang.String getAccountStatus() {
        return accountStatus;
    }


    /**
     * Sets the accountStatus value for this Account.
     * 
     * @param accountStatus
     */
    public void setAccountStatus(java.lang.String accountStatus) {
        this.accountStatus = accountStatus;
    }


    /**
     * Gets the alias value for this Account.
     * 
     * @return alias
     */
    public java.lang.String getAlias() {
        return alias;
    }


    /**
     * Sets the alias value for this Account.
     * 
     * @param alias
     */
    public void setAlias(java.lang.String alias) {
        this.alias = alias;
    }


    /**
     * Gets the currencyCode value for this Account.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this Account.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the integrationId value for this Account.
     * 
     * @return integrationId
     */
    public java.lang.String getIntegrationId() {
        return integrationId;
    }


    /**
     * Sets the integrationId value for this Account.
     * 
     * @param integrationId
     */
    public void setIntegrationId(java.lang.String integrationId) {
        this.integrationId = integrationId;
    }


    /**
     * Gets the location value for this Account.
     * 
     * @return location
     */
    public java.lang.String getLocation() {
        return location;
    }


    /**
     * Sets the location value for this Account.
     * 
     * @param location
     */
    public void setLocation(java.lang.String location) {
        this.location = location;
    }


    /**
     * Gets the name value for this Account.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Account.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the parentAccountId value for this Account.
     * 
     * @return parentAccountId
     */
    public java.lang.String getParentAccountId() {
        return parentAccountId;
    }


    /**
     * Sets the parentAccountId value for this Account.
     * 
     * @param parentAccountId
     */
    public void setParentAccountId(java.lang.String parentAccountId) {
        this.parentAccountId = parentAccountId;
    }


    /**
     * Gets the parentAccountIntegrationId value for this Account.
     * 
     * @return parentAccountIntegrationId
     */
    public java.lang.String getParentAccountIntegrationId() {
        return parentAccountIntegrationId;
    }


    /**
     * Sets the parentAccountIntegrationId value for this Account.
     * 
     * @param parentAccountIntegrationId
     */
    public void setParentAccountIntegrationId(java.lang.String parentAccountIntegrationId) {
        this.parentAccountIntegrationId = parentAccountIntegrationId;
    }


    /**
     * Gets the parentAccountLocation value for this Account.
     * 
     * @return parentAccountLocation
     */
    public java.lang.String getParentAccountLocation() {
        return parentAccountLocation;
    }


    /**
     * Sets the parentAccountLocation value for this Account.
     * 
     * @param parentAccountLocation
     */
    public void setParentAccountLocation(java.lang.String parentAccountLocation) {
        this.parentAccountLocation = parentAccountLocation;
    }


    /**
     * Gets the parentAccountName value for this Account.
     * 
     * @return parentAccountName
     */
    public java.lang.String getParentAccountName() {
        return parentAccountName;
    }


    /**
     * Sets the parentAccountName value for this Account.
     * 
     * @param parentAccountName
     */
    public void setParentAccountName(java.lang.String parentAccountName) {
        this.parentAccountName = parentAccountName;
    }


    /**
     * Gets the primaryOrganization value for this Account.
     * 
     * @return primaryOrganization
     */
    public java.lang.String getPrimaryOrganization() {
        return primaryOrganization;
    }


    /**
     * Sets the primaryOrganization value for this Account.
     * 
     * @param primaryOrganization
     */
    public void setPrimaryOrganization(java.lang.String primaryOrganization) {
        this.primaryOrganization = primaryOrganization;
    }


    /**
     * Gets the modId value for this Account.
     * 
     * @return modId
     */
    public java.lang.String getModId() {
        return modId;
    }


    /**
     * Sets the modId value for this Account.
     * 
     * @param modId
     */
    public void setModId(java.lang.String modId) {
        this.modId = modId;
    }


    /**
     * Gets the listOfRelatedContact value for this Account.
     * 
     * @return listOfRelatedContact
     */
    public com.johnny.monitor.business.webservice.siebel.RelatedContact[] getListOfRelatedContact() {
        return listOfRelatedContact;
    }


    /**
     * Sets the listOfRelatedContact value for this Account.
     * 
     * @param listOfRelatedContact
     */
    public void setListOfRelatedContact(com.johnny.monitor.business.webservice.siebel.RelatedContact[] listOfRelatedContact) {
        this.listOfRelatedContact = listOfRelatedContact;
    }


    /**
     * Gets the listOfRelatedOpportunity value for this Account.
     * 
     * @return listOfRelatedOpportunity
     */
    public com.johnny.monitor.business.webservice.siebel.RelatedOpportunity[] getListOfRelatedOpportunity() {
        return listOfRelatedOpportunity;
    }


    /**
     * Sets the listOfRelatedOpportunity value for this Account.
     * 
     * @param listOfRelatedOpportunity
     */
    public void setListOfRelatedOpportunity(com.johnny.monitor.business.webservice.siebel.RelatedOpportunity[] listOfRelatedOpportunity) {
        this.listOfRelatedOpportunity = listOfRelatedOpportunity;
    }


    /**
     * Gets the listOfRelatedServiceRequest value for this Account.
     * 
     * @return listOfRelatedServiceRequest
     */
    public com.johnny.monitor.business.webservice.siebel.RelatedServiceRequest[] getListOfRelatedServiceRequest() {
        return listOfRelatedServiceRequest;
    }


    /**
     * Sets the listOfRelatedServiceRequest value for this Account.
     * 
     * @param listOfRelatedServiceRequest
     */
    public void setListOfRelatedServiceRequest(com.johnny.monitor.business.webservice.siebel.RelatedServiceRequest[] listOfRelatedServiceRequest) {
        this.listOfRelatedServiceRequest = listOfRelatedServiceRequest;
    }


    /**
     * Gets the operation value for this Account.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this Account.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountId==null && other.getAccountId()==null) || 
             (this.accountId!=null &&
              this.accountId.equals(other.getAccountId()))) &&
            ((this.accountStatus==null && other.getAccountStatus()==null) || 
             (this.accountStatus!=null &&
              this.accountStatus.equals(other.getAccountStatus()))) &&
            ((this.alias==null && other.getAlias()==null) || 
             (this.alias!=null &&
              this.alias.equals(other.getAlias()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.integrationId==null && other.getIntegrationId()==null) || 
             (this.integrationId!=null &&
              this.integrationId.equals(other.getIntegrationId()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.parentAccountId==null && other.getParentAccountId()==null) || 
             (this.parentAccountId!=null &&
              this.parentAccountId.equals(other.getParentAccountId()))) &&
            ((this.parentAccountIntegrationId==null && other.getParentAccountIntegrationId()==null) || 
             (this.parentAccountIntegrationId!=null &&
              this.parentAccountIntegrationId.equals(other.getParentAccountIntegrationId()))) &&
            ((this.parentAccountLocation==null && other.getParentAccountLocation()==null) || 
             (this.parentAccountLocation!=null &&
              this.parentAccountLocation.equals(other.getParentAccountLocation()))) &&
            ((this.parentAccountName==null && other.getParentAccountName()==null) || 
             (this.parentAccountName!=null &&
              this.parentAccountName.equals(other.getParentAccountName()))) &&
            ((this.primaryOrganization==null && other.getPrimaryOrganization()==null) || 
             (this.primaryOrganization!=null &&
              this.primaryOrganization.equals(other.getPrimaryOrganization()))) &&
            ((this.modId==null && other.getModId()==null) || 
             (this.modId!=null &&
              this.modId.equals(other.getModId()))) &&
            ((this.listOfRelatedContact==null && other.getListOfRelatedContact()==null) || 
             (this.listOfRelatedContact!=null &&
              java.util.Arrays.equals(this.listOfRelatedContact, other.getListOfRelatedContact()))) &&
            ((this.listOfRelatedOpportunity==null && other.getListOfRelatedOpportunity()==null) || 
             (this.listOfRelatedOpportunity!=null &&
              java.util.Arrays.equals(this.listOfRelatedOpportunity, other.getListOfRelatedOpportunity()))) &&
            ((this.listOfRelatedServiceRequest==null && other.getListOfRelatedServiceRequest()==null) || 
             (this.listOfRelatedServiceRequest!=null &&
              java.util.Arrays.equals(this.listOfRelatedServiceRequest, other.getListOfRelatedServiceRequest()))) &&
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation())));
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
        if (getAccountId() != null) {
            _hashCode += getAccountId().hashCode();
        }
        if (getAccountStatus() != null) {
            _hashCode += getAccountStatus().hashCode();
        }
        if (getAlias() != null) {
            _hashCode += getAlias().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getIntegrationId() != null) {
            _hashCode += getIntegrationId().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getParentAccountId() != null) {
            _hashCode += getParentAccountId().hashCode();
        }
        if (getParentAccountIntegrationId() != null) {
            _hashCode += getParentAccountIntegrationId().hashCode();
        }
        if (getParentAccountLocation() != null) {
            _hashCode += getParentAccountLocation().hashCode();
        }
        if (getParentAccountName() != null) {
            _hashCode += getParentAccountName().hashCode();
        }
        if (getPrimaryOrganization() != null) {
            _hashCode += getPrimaryOrganization().hashCode();
        }
        if (getModId() != null) {
            _hashCode += getModId().hashCode();
        }
        if (getListOfRelatedContact() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfRelatedContact());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfRelatedContact(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListOfRelatedOpportunity() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfRelatedOpportunity());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfRelatedOpportunity(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListOfRelatedServiceRequest() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfRelatedServiceRequest());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfRelatedServiceRequest(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperation() != null) {
            _hashCode += getOperation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "Account"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operation");
        attrField.setXmlName(new javax.xml.namespace.QName("", "operation"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "AccountStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "Alias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "CurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integrationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "IntegrationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "Location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentAccountId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ParentAccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentAccountIntegrationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ParentAccountIntegrationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentAccountLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ParentAccountLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentAccountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ParentAccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryOrganization");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "PrimaryOrganization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ModId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfRelatedContact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfRelatedContact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedContact"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedContact"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfRelatedOpportunity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfRelatedOpportunity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedOpportunity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedOpportunity"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfRelatedServiceRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ListOfRelatedServiceRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedServiceRequest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedServiceRequest"));
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
