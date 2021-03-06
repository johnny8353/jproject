package com.johnny.webservice.client.cxf.datatype1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.5.9
 * 2016-09-07T20:22:36.188+08:00
 * Generated source version: 2.5.9
 * 
 */
@WebServiceClient(name = "DataTypeWSImplService", 
                  wsdlLocation = "file:/E:/share/JAVA/010未分类-分类在笔记本汇总/johnnyp/JohnnyMaven/webservice/webservice-client/src/main/java/com/johnny/webservice/client/cxfimpl2/datatypews.wsdl",
                  targetNamespace = "http://cxfimp2.webservice.johnny.com/") 
public class DataTypeWSImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cxfimp2.webservice.johnny.com/", "DataTypeWSImplService");
    public final static QName DataTypeWSImplPort = new QName("http://cxfimp2.webservice.johnny.com/", "DataTypeWSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/E:/share/JAVA/010未分类-分类在笔记本汇总/johnnyp/JohnnyMaven/webservice/webservice-client/src/main/java/com/johnny/webservice/client/cxfimpl2/datatypews.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DataTypeWSImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/E:/share/JAVA/010未分类-分类在笔记本汇总/johnnyp/JohnnyMaven/webservice/webservice-client/src/main/java/com/johnny/webservice/client/cxfimpl2/datatypews.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DataTypeWSImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DataTypeWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DataTypeWSImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DataTypeWSImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DataTypeWSImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DataTypeWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns DataTypeWS
     */
    @WebEndpoint(name = "DataTypeWSImplPort")
    public DataTypeWS getDataTypeWSImplPort() {
        return super.getPort(DataTypeWSImplPort, DataTypeWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DataTypeWS
     */
    @WebEndpoint(name = "DataTypeWSImplPort")
    public DataTypeWS getDataTypeWSImplPort(WebServiceFeature... features) {
        return super.getPort(DataTypeWSImplPort, DataTypeWS.class, features);
    }

}
