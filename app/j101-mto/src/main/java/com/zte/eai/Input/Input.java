/**
 * Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zte.eai.Input;

public class Input  implements java.io.Serializable {
    private java.math.BigInteger PAGE_SIZE;

    private java.math.BigInteger CURRENT_PAGE;

    private java.lang.String FREIGHTNO;

    private java.lang.String LANGUAGETYPE;

    private java.lang.String RESERVED1;

    private java.lang.String RESERVED2;

    private java.lang.String RESERVED3;

    private java.lang.String RESERVED4;

    private java.lang.String RESERVED5;

    public Input() {
    }

    public Input(
           java.math.BigInteger PAGE_SIZE,
           java.math.BigInteger CURRENT_PAGE,
           java.lang.String FREIGHTNO,
           java.lang.String LANGUAGETYPE,
           java.lang.String RESERVED1,
           java.lang.String RESERVED2,
           java.lang.String RESERVED3,
           java.lang.String RESERVED4,
           java.lang.String RESERVED5) {
           this.PAGE_SIZE = PAGE_SIZE;
           this.CURRENT_PAGE = CURRENT_PAGE;
           this.FREIGHTNO = FREIGHTNO;
           this.LANGUAGETYPE = LANGUAGETYPE;
           this.RESERVED1 = RESERVED1;
           this.RESERVED2 = RESERVED2;
           this.RESERVED3 = RESERVED3;
           this.RESERVED4 = RESERVED4;
           this.RESERVED5 = RESERVED5;
    }


    /**
     * Gets the PAGE_SIZE value for this Input.
     * 
     * @return PAGE_SIZE
     */
    public java.math.BigInteger getPAGE_SIZE() {
        return PAGE_SIZE;
    }


    /**
     * Sets the PAGE_SIZE value for this Input.
     * 
     * @param PAGE_SIZE
     */
    public void setPAGE_SIZE(java.math.BigInteger PAGE_SIZE) {
        this.PAGE_SIZE = PAGE_SIZE;
    }


    /**
     * Gets the CURRENT_PAGE value for this Input.
     * 
     * @return CURRENT_PAGE
     */
    public java.math.BigInteger getCURRENT_PAGE() {
        return CURRENT_PAGE;
    }


    /**
     * Sets the CURRENT_PAGE value for this Input.
     * 
     * @param CURRENT_PAGE
     */
    public void setCURRENT_PAGE(java.math.BigInteger CURRENT_PAGE) {
        this.CURRENT_PAGE = CURRENT_PAGE;
    }


    /**
     * Gets the FREIGHTNO value for this Input.
     * 
     * @return FREIGHTNO
     */
    public java.lang.String getFREIGHTNO() {
        return FREIGHTNO;
    }


    /**
     * Sets the FREIGHTNO value for this Input.
     * 
     * @param FREIGHTNO
     */
    public void setFREIGHTNO(java.lang.String FREIGHTNO) {
        this.FREIGHTNO = FREIGHTNO;
    }


    /**
     * Gets the LANGUAGETYPE value for this Input.
     * 
     * @return LANGUAGETYPE
     */
    public java.lang.String getLANGUAGETYPE() {
        return LANGUAGETYPE;
    }


    /**
     * Sets the LANGUAGETYPE value for this Input.
     * 
     * @param LANGUAGETYPE
     */
    public void setLANGUAGETYPE(java.lang.String LANGUAGETYPE) {
        this.LANGUAGETYPE = LANGUAGETYPE;
    }


    /**
     * Gets the RESERVED1 value for this Input.
     * 
     * @return RESERVED1
     */
    public java.lang.String getRESERVED1() {
        return RESERVED1;
    }


    /**
     * Sets the RESERVED1 value for this Input.
     * 
     * @param RESERVED1
     */
    public void setRESERVED1(java.lang.String RESERVED1) {
        this.RESERVED1 = RESERVED1;
    }


    /**
     * Gets the RESERVED2 value for this Input.
     * 
     * @return RESERVED2
     */
    public java.lang.String getRESERVED2() {
        return RESERVED2;
    }


    /**
     * Sets the RESERVED2 value for this Input.
     * 
     * @param RESERVED2
     */
    public void setRESERVED2(java.lang.String RESERVED2) {
        this.RESERVED2 = RESERVED2;
    }


    /**
     * Gets the RESERVED3 value for this Input.
     * 
     * @return RESERVED3
     */
    public java.lang.String getRESERVED3() {
        return RESERVED3;
    }


    /**
     * Sets the RESERVED3 value for this Input.
     * 
     * @param RESERVED3
     */
    public void setRESERVED3(java.lang.String RESERVED3) {
        this.RESERVED3 = RESERVED3;
    }


    /**
     * Gets the RESERVED4 value for this Input.
     * 
     * @return RESERVED4
     */
    public java.lang.String getRESERVED4() {
        return RESERVED4;
    }


    /**
     * Sets the RESERVED4 value for this Input.
     * 
     * @param RESERVED4
     */
    public void setRESERVED4(java.lang.String RESERVED4) {
        this.RESERVED4 = RESERVED4;
    }


    /**
     * Gets the RESERVED5 value for this Input.
     * 
     * @return RESERVED5
     */
    public java.lang.String getRESERVED5() {
        return RESERVED5;
    }


    /**
     * Sets the RESERVED5 value for this Input.
     * 
     * @param RESERVED5
     */
    public void setRESERVED5(java.lang.String RESERVED5) {
        this.RESERVED5 = RESERVED5;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Input)) return false;
        Input other = (Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PAGE_SIZE==null && other.getPAGE_SIZE()==null) || 
             (this.PAGE_SIZE!=null &&
              this.PAGE_SIZE.equals(other.getPAGE_SIZE()))) &&
            ((this.CURRENT_PAGE==null && other.getCURRENT_PAGE()==null) || 
             (this.CURRENT_PAGE!=null &&
              this.CURRENT_PAGE.equals(other.getCURRENT_PAGE()))) &&
            ((this.FREIGHTNO==null && other.getFREIGHTNO()==null) || 
             (this.FREIGHTNO!=null &&
              this.FREIGHTNO.equals(other.getFREIGHTNO()))) &&
            ((this.LANGUAGETYPE==null && other.getLANGUAGETYPE()==null) || 
             (this.LANGUAGETYPE!=null &&
              this.LANGUAGETYPE.equals(other.getLANGUAGETYPE()))) &&
            ((this.RESERVED1==null && other.getRESERVED1()==null) || 
             (this.RESERVED1!=null &&
              this.RESERVED1.equals(other.getRESERVED1()))) &&
            ((this.RESERVED2==null && other.getRESERVED2()==null) || 
             (this.RESERVED2!=null &&
              this.RESERVED2.equals(other.getRESERVED2()))) &&
            ((this.RESERVED3==null && other.getRESERVED3()==null) || 
             (this.RESERVED3!=null &&
              this.RESERVED3.equals(other.getRESERVED3()))) &&
            ((this.RESERVED4==null && other.getRESERVED4()==null) || 
             (this.RESERVED4!=null &&
              this.RESERVED4.equals(other.getRESERVED4()))) &&
            ((this.RESERVED5==null && other.getRESERVED5()==null) || 
             (this.RESERVED5!=null &&
              this.RESERVED5.equals(other.getRESERVED5())));
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
        if (getPAGE_SIZE() != null) {
            _hashCode += getPAGE_SIZE().hashCode();
        }
        if (getCURRENT_PAGE() != null) {
            _hashCode += getCURRENT_PAGE().hashCode();
        }
        if (getFREIGHTNO() != null) {
            _hashCode += getFREIGHTNO().hashCode();
        }
        if (getLANGUAGETYPE() != null) {
            _hashCode += getLANGUAGETYPE().hashCode();
        }
        if (getRESERVED1() != null) {
            _hashCode += getRESERVED1().hashCode();
        }
        if (getRESERVED2() != null) {
            _hashCode += getRESERVED2().hashCode();
        }
        if (getRESERVED3() != null) {
            _hashCode += getRESERVED3().hashCode();
        }
        if (getRESERVED4() != null) {
            _hashCode += getRESERVED4().hashCode();
        }
        if (getRESERVED5() != null) {
            _hashCode += getRESERVED5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eai.zte.com/Input", "Input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAGE_SIZE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "PAGE_SIZE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENT_PAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "CURRENT_PAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FREIGHTNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "FREIGHTNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LANGUAGETYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "LANGUAGETYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESERVED1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "RESERVED1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESERVED2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "RESERVED2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESERVED3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "RESERVED3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESERVED4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "RESERVED4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESERVED5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://eai.zte.com/Input", "RESERVED5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
