
package com.johnny.webservice.client.jdkimpl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doHelloResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doHelloResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doHelloResponse", propOrder = {
    "jResult"
})
public class DoHelloResponse {

    protected String jResult;

    /**
     * Gets the value of the jResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJResult() {
        return jResult;
    }

    /**
     * Sets the value of the jResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJResult(String value) {
        this.jResult = value;
    }

}
