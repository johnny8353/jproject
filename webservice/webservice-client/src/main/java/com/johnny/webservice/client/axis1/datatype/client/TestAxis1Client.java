package com.johnny.webservice.client.axis1.datatype.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.junit.Test;

import com.johnny.webservice.client.axis1.datatype.DataTypeWSImpl;
import com.johnny.webservice.client.axis1.datatype.DataTypeWSImplServiceLocator;
import com.johnny.webservice.client.axis1.datatype.Student;
import com.johnny.webservice.client.axis1.helloworld.HelloWSImpl;
import com.johnny.webservice.client.axis1.helloworld.HelloWSImplServiceLocator;

/**
 * 类 编 号：
 * 类 名 称：TestAxis2Client
 * 内容摘要：测试使用Eclipse Web Service Client生成客户端代码 ，服务端为jetty 
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAxis1Client {
	private String namespaceUri = "http://localhost:8077/johnny/services/DataType1";
	private String wsdlUrl = namespaceUri + "?wsdl";

	@Test
	public void TestGetStudentById() throws RemoteException, ServiceException,
			MalformedURLException {
		QName qname = new QName("urn:BeanService", "Student");
		// 创建调用对象
		Service service = new Service();
		Call call = (Call) service.createCall();
		// 注册这个bean为可序列化的.传递参数
		call.registerTypeMapping(Student.class, qname,
				new BeanSerializerFactory(Student.class, qname),
				new BeanDeserializerFactory(Student.class, qname));
		// 调用 远程方法
		call.setOperationName(new QName(namespaceUri, "getStudentById"));
		// 设置URL
		call.setTargetEndpointAddress(new URL(wsdlUrl));
		// 执行远程调用，同时获得返回值
		Student result = (Student) call.invoke(new Object[] { 1});
		System.out.println(result);
	}
	
	@Test
	public void TestAddStudent() throws RemoteException, ServiceException,
			MalformedURLException {
		QName qname = new QName("urn:BeanService", "Student");
		// 创建调用对象
		Service service = new Service();
		Call call = (Call) service.createCall();
		// 注册这个bean为可序列化的.传递参数
		call.registerTypeMapping(Student.class, qname,
				new BeanSerializerFactory(Student.class, qname),
				new BeanDeserializerFactory(Student.class, qname));
		// 调用 远程方法
		call.setOperationName(new QName(namespaceUri, "addStudent"));
		// 设置URL
		call.setTargetEndpointAddress(new URL(wsdlUrl));
		Student s = new Student();
		s.setId(333);
		// 执行远程调用，同时获得返回值
		Object result = (Object) call.invoke(new Object[] { s});
		System.out.println(result);
	}

	@Test
	public void TestGetStudentByIdStub() throws ServiceException, RemoteException {
		//获取locator，locator提供了 设置 请求地址 port，获取接口方法
		DataTypeWSImplServiceLocator locator = new DataTypeWSImplServiceLocator();
		locator.setEndpointAddress("DataType1", namespaceUri);
		DataTypeWSImpl impl = locator.getDataType1();
		Student s = impl.getStudentById(1);
		System.out.println(s);
		
		Object result = (Object) impl.addStudent(s);
		System.out.println(result);
	}

}
