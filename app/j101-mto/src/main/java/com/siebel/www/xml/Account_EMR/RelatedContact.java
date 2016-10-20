/**
 * RelatedContact.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.siebel.www.xml.Account_EMR;

public class RelatedContact  implements java.io.Serializable {
    private java.lang.String contactId;

    private java.lang.String firstName;

    private java.lang.String contactIntegrationId;

    private java.lang.String lastName;

    private java.lang.String middleName;

    private java.lang.String personUId;

    private java.lang.String primaryOrganization;

    private java.lang.String modId;

    public RelatedContact() {
    }

    public RelatedContact(
           java.lang.String contactId,
           java.lang.String firstName,
           java.lang.String contactIntegrationId,
           java.lang.String lastName,
           java.lang.String middleName,
           java.lang.String personUId,
           java.lang.String primaryOrganization,
           java.lang.String modId) {
           this.contactId = contactId;
           this.firstName = firstName;
           this.contactIntegrationId = contactIntegrationId;
           this.lastName = lastName;
           this.middleName = middleName;
           this.personUId = personUId;
           this.primaryOrganization = primaryOrganization;
           this.modId = modId;
    }


    /**
     * Gets the contactId value for this RelatedContact.
     * 
     * @return contactId
     */
    public java.lang.String getContactId() {
        return contactId;
    }


    /**
     * Sets the contactId value for this RelatedContact.
     * 
     * @param contactId
     */
    public void setContactId(java.lang.String contactId) {
        this.contactId = contactId;
    }


    /**
     * Gets the firstName value for this RelatedContact.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this RelatedContact.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the contactIntegrationId value for this RelatedContact.
     * 
     * @return contactIntegrationId
     */
    public java.lang.String getContactIntegrationId() {
        return contactIntegrationId;
    }


    /**
     * Sets the contactIntegrationId value for this RelatedContact.
     * 
     * @param contactIntegrationId
     */
    public void setContactIntegrationId(java.lang.String contactIntegrationId) {
        this.contactIntegrationId = contactIntegrationId;
    }


    /**
     * Gets the lastName value for this RelatedContact.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this RelatedContact.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the middleName value for this RelatedContact.
     * 
     * @return middleName
     */
    public java.lang.String getMiddleName() {
        return middleName;
    }


    /**
     * Sets the middleName value for this RelatedContact.
     * 
     * @param middleName
     */
    public void setMiddleName(java.lang.String middleName) {
        this.middleName = middleName;
    }


    /**
     * Gets the personUId value for this RelatedContact.
     * 
     * @return personUId
     */
    public java.lang.String getPersonUId() {
        return personUId;
    }


    /**
     * Sets the personUId value for this RelatedContact.
     * 
     * @param personUId
     */
    public void setPersonUId(java.lang.String personUId) {
        this.personUId = personUId;
    }


    /**
     * Gets the primaryOrganization value for this RelatedContact.
     * 
     * @return primaryOrganization
     */
    public java.lang.String getPrimaryOrganization() {
        return primaryOrganization;
    }


    /**
     * Sets the primaryOrganization value for this RelatedContact.
     * 
     * @param primaryOrganization
     */
    public void setPrimaryOrganization(java.lang.String primaryOrganization) {
        this.primaryOrganization = primaryOrganization;
    }


    /**
     * Gets the modId value for this RelatedContact.
     * 
     * @return modId
     */
    public java.lang.String getModId() {
        return modId;
    }


    /**
     * Sets the modId value for this RelatedContact.
     * 
     * @param modId
     */
    public void setModId(java.lang.String modId) {
        this.modId = modId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedContact)) return false;
        RelatedContact other = (RelatedContact) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contactId==null && other.getContactId()==null) || 
             (this.contactId!=null &&
              this.contactId.equals(other.getContactId()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.contactIntegrationId==null && other.getContactIntegrationId()==null) || 
             (this.contactIntegrationId!=null &&
              this.contactIntegrationId.equals(other.getContactIntegrationId()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.middleName==null && other.getMiddleName()==null) || 
             (this.middleName!=null &&
              this.middleName.equals(other.getMiddleName()))) &&
            ((this.personUId==null && other.getPersonUId()==null) || 
             (this.personUId!=null &&
              this.personUId.equals(other.getPersonUId()))) &&
            ((this.primaryOrganization==null && other.getPrimaryOrganization()==null) || 
             (this.primaryOrganization!=null &&
              this.primaryOrganization.equals(other.getPrimaryOrganization()))) &&
            ((this.modId==null && other.getModId()==null) || 
             (this.modId!=null &&
              this.modId.equals(other.getModId())));
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
        if (getContactId() != null) {
            _hashCode += getContactId().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getContactIntegrationId() != null) {
            _hashCode += getContactIntegrationId().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMiddleName() != null) {
            _hashCode += getMiddleName().hashCode();
        }
        if (getPersonUId() != null) {
            _hashCode += getPersonUId().hashCode();
        }
        if (getPrimaryOrganization() != null) {
            _hashCode += getPrimaryOrganization().hashCode();
        }
        if (getModId() != null) {
            _hashCode += getModId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelatedContact.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "RelatedContact"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ContactId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "FirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactIntegrationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "ContactIntegrationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "LastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("middleName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "MiddleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personUId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/Account_EMR", "PersonUId"));
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
