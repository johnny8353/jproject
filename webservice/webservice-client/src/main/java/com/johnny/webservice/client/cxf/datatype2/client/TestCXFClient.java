package com.johnny.webservice.client.cxf.datatype2.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import com.johnny.webservice.client.cxf.datatype1.GetAllStudentsMapResponse;
import com.johnny.webservice.client.cxf.datatype1.GetAllStudentsMapResponse.Result;
import com.johnny.webservice.client.cxf.datatype2.DataTypeWS;
import com.johnny.webservice.client.cxf.datatype2.DataTypeWSImplServiceLocator;
import com.johnny.webservice.client.cxf.datatype2.GetAllStudentsMapResponseResultEntry;
import com.johnny.webservice.client.cxf.datatype2.Student;


public class TestCXFClient {
	private String namespaceUri = "http://localhost:8077/johnny/webservice/dataTypeWS";
	private String wsdlUrl = namespaceUri + "?wsdl";
	/**
	 * 类 编 号：
	 * 类 名 称：TestCXFClient
	 * 内容摘要：使用Eclipse 自带的 Web Service Client 生成客户端代码
	 * 完成日期：2016年9月19日
	 * 编码作者：JohnnyHuang 黄福强
	 */
	@Test
	public void TestGetStudentByIdStub() throws ServiceException, RemoteException {
		//获取locator，locator提供了 设置 请求地址 port，获取接口方法
		DataTypeWSImplServiceLocator locator = new DataTypeWSImplServiceLocator();
		//查看wsdl:port name
		locator.setEndpointAddress("DataTypeWSImplPort", namespaceUri);
		DataTypeWS impl = locator.getDataTypeWSImplPort();
		Student s = impl.getStudentById(1);
		System.out.println(s);
		
		Object result = (Object) impl.addStudent(s);
		System.out.println(result);
		
		GetAllStudentsMapResponseResultEntry[] allStudentsMap = impl.getAllStudentsMap();
		for (GetAllStudentsMapResponseResultEntry iterable_element : allStudentsMap) {
			System.out.println(iterable_element.getKey());
			System.out.println(iterable_element.getValue());
		}
		
	}
}
