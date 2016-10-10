
package com.johnny.webservice.client.cxf.datatype1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getStudentsByPrice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getStudentsByPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentsByPrice", propOrder = {
    "price"
})
public class GetStudentsByPrice {

    protected float price;

    /**
     * ��ȡprice���Ե�ֵ��
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * ����price���Ե�ֵ��
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

}
