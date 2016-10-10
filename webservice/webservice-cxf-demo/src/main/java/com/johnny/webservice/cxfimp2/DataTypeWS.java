package com.johnny.webservice.cxfimp2;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WebService
@WSDLDocumentationCollection({ @WSDLDocumentation(value = "数据中心用户信息接口：为第三方子系统提供用户信息，访问此接口的客户端需要IP授权。"
		+ "作者：xxx，邮箱：xxx@126.com", placement = WSDLDocumentation.Placement.TOP) })
public interface DataTypeWS {
	@WebMethod
	@WebResult(name = "result")
	@WSDLDocumentation("addStudent-说明信息")
	public boolean addStudent(@WebParam(name = "student") Student s);

	@WebMethod
	@WebResult(name = "result")
	public Student getStudentById(@WebParam(name = "id2") int id);

	@WebMethod
	@WebResult(name = "result")
	public List<Student> getStudentsByPrice(
			@WebParam(name = "price") float price);

	@WebMethod
	@WebResult(name = "result")
	public Map<Integer, Student> getAllStudentsMap();
}
