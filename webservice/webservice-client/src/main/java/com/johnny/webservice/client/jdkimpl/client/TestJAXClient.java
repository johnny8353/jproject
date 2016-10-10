package com.johnny.webservice.client.jdkimpl.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.johnny.webservice.client.jdkimpl.HelloWSImpl;
import com.johnny.webservice.client.jdkimpl.HelloWSImplService;

/**
 * 类 编 号：
 * 类 名 称：TestClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月5日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestJAXClient {
	/* jdkimpl
	 wsimport -keep -d e:\ -s
	 E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client\src\main\java\
	 -p com.johnny.webservice.client.jdkimpl -verbose
	 E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client\src\main\java\com\johnny\webservice\client\jdkimpl\hellows.wsdl
	*/
	@Test
	public void TestJAXWS() {
		/**
		 <service name="HelloWSImplService">
			<port name="HelloWSImplPort" binding="tns:HelloWSImplPortBinding">
		  		<soap:address location="http://10.17.183.43:8989/johnny/hellows" /> 
		  	</port>
		 </service>
		 */
		HelloWSImplService helloWSImplService = new HelloWSImplService();
		HelloWSImpl helloWSImpl = helloWSImplService.getHelloWSImplPort();
		String result = helloWSImpl.doHello("johnny");
		System.out.println("JAX_WS client:" + result);
	}
	
	
	
}
