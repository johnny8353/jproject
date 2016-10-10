
package com.johnny.webservice.client.cxfimpl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.johnny.webservice.client.cxfimpl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DoHello_QNAME = new QName("http://cxfimp.webservice.johnny.com/", "doHello");
    private final static QName _DoHelloResponse_QNAME = new QName("http://cxfimp.webservice.johnny.com/", "doHelloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.johnny.webservice.client.cxfimpl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoHello }
     * 
     */
    public DoHello createDoHello() {
        return new DoHello();
    }

    /**
     * Create an instance of {@link DoHelloResponse }
     * 
     */
    public DoHelloResponse createDoHelloResponse() {
        return new DoHelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp.webservice.johnny.com/", name = "doHello")
    public JAXBElement<DoHello> createDoHello(DoHello value) {
        return new JAXBElement<DoHello>(_DoHello_QNAME, DoHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp.webservice.johnny.com/", name = "doHelloResponse")
    public JAXBElement<DoHelloResponse> createDoHelloResponse(DoHelloResponse value) {
        return new JAXBElement<DoHelloResponse>(_DoHelloResponse_QNAME, DoHelloResponse.class, null, value);
    }

}
