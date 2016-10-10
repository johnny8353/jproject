package com.johnny.webservice.axis2.datatype;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface DataTypeWS {
	@WebMethod
	@WebResult(name = "result")
	public boolean addStudent(@WebParam(name="student") Student s) ;
	@WebMethod
	@WebResult(name = "result")
	public Student getStudentById(@WebParam(name="id2") int id);

	@WebMethod
	@WebResult(name = "result")
	public List<Student> getStudentsByPrice(@WebParam(name="price") float price);

	@WebMethod
	@WebResult(name = "result")
	public Map<Integer, Student> getAllStudentsMap();
}
