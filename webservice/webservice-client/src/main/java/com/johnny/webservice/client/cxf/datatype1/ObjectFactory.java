
package com.johnny.webservice.client.cxf.datatype1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.johnny.webservice.client.cxfimpl2 package. 
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

    private final static QName _GetStudentsByPriceResponse_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getStudentsByPriceResponse");
    private final static QName _GetStudentById_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getStudentById");
    private final static QName _GetAllStudentsMap_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getAllStudentsMap");
    private final static QName _AddStudentResponse_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "addStudentResponse");
    private final static QName _GetAllStudentsMapResponse_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getAllStudentsMapResponse");
    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getStudentByIdResponse");
    private final static QName _GetStudentsByPrice_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "getStudentsByPrice");
    private final static QName _AddStudent_QNAME = new QName("http://cxfimp2.webservice.johnny.com/", "addStudent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.johnny.webservice.client.cxfimpl2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse }
     * 
     */
    public GetAllStudentsMapResponse createGetAllStudentsMapResponse() {
        return new GetAllStudentsMapResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse.Result }
     * 
     */
    public GetAllStudentsMapResponse.Result createGetAllStudentsMapResponseResult() {
        return new GetAllStudentsMapResponse.Result();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByPrice }
     * 
     */
    public GetStudentsByPrice createGetStudentsByPrice() {
        return new GetStudentsByPrice();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link GetAllStudentsMap }
     * 
     */
    public GetAllStudentsMap createGetAllStudentsMap() {
        return new GetAllStudentsMap();
    }

    /**
     * Create an instance of {@link GetStudentsByPriceResponse }
     * 
     */
    public GetStudentsByPriceResponse createGetStudentsByPriceResponse() {
        return new GetStudentsByPriceResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse.Result.Entry }
     * 
     */
    public GetAllStudentsMapResponse.Result.Entry createGetAllStudentsMapResponseResultEntry() {
        return new GetAllStudentsMapResponse.Result.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getStudentsByPriceResponse")
    public JAXBElement<GetStudentsByPriceResponse> createGetStudentsByPriceResponse(GetStudentsByPriceResponse value) {
        return new JAXBElement<GetStudentsByPriceResponse>(_GetStudentsByPriceResponse_QNAME, GetStudentsByPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getAllStudentsMap")
    public JAXBElement<GetAllStudentsMap> createGetAllStudentsMap(GetAllStudentsMap value) {
        return new JAXBElement<GetAllStudentsMap>(_GetAllStudentsMap_QNAME, GetAllStudentsMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsMapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getAllStudentsMapResponse")
    public JAXBElement<GetAllStudentsMapResponse> createGetAllStudentsMapResponse(GetAllStudentsMapResponse value) {
        return new JAXBElement<GetAllStudentsMapResponse>(_GetAllStudentsMapResponse_QNAME, GetAllStudentsMapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "getStudentsByPrice")
    public JAXBElement<GetStudentsByPrice> createGetStudentsByPrice(GetStudentsByPrice value) {
        return new JAXBElement<GetStudentsByPrice>(_GetStudentsByPrice_QNAME, GetStudentsByPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfimp2.webservice.johnny.com/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

}
