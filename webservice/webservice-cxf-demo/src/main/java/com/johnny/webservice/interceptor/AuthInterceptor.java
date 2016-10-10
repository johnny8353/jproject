package com.johnny.webservice.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 类 编 号：
 * 类 名 称：CheckUserInterceptor
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月6日
 * 编码作者：JohnnyHuang 黄福强
 */
public class AuthInterceptor extends AbstractPhaseInterceptor<Message> {
	
	public AuthInterceptor() {
		//拦截器在调用方法之前拦截SOAP消息
		super(Phase.PRE_PROTOCOL);
	}

	/**
	 * @Description: 拦截器操作
	 * @param msg 被拦截到的SOAP消息
	 	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cxf="http://cxfimp2.webservice.johnny.com/">
		   <soapenv:Header>
			<security>
				<username>hfq</username>
				<password>123456</password>
			</security>
		   </soapenv:Header>
		   <soapenv:Body>
		      <cxf:getAllStudentsMap/>
		   </soapenv:Body>
		</soapenv:Envelope>
	 * @throws Fault
	 */
	@Override
	public void handleMessage(Message msg2) throws Fault {
		@SuppressWarnings("unused")
		String smsg = msg2.getContent(String.class);
		if(true) return ;
		@SuppressWarnings("unused")
		SoapMessage msg = (SoapMessage)msg2;
		System.out.println("=====自定义拦截器=======");
		//获取SOAP消息的Header
		List<Header> headers = msg.getHeaders();
	    //如果没有Header
		if(headers == null || headers.size() < 1) {
			throw new Fault(new IllegalArgumentException("没有Header,拦截器实施拦截"));
		}
		//获取Header携带是用户和密码信息
		Header firstHeader = headers.get(0);
		Element ele = (Element) firstHeader.getObject();
		
		NodeList userIdEle = ele.getElementsByTagName("username");
		NodeList userPassEle = ele.getElementsByTagName("password");
		
		if (userIdEle.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("用户Id格式不对"));
		}
			
		if (userPassEle.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("用户密码格式不对"));
		}
		
		//获取元素的文本内容
		String userId = userIdEle.item(0).getTextContent();
		String userPass = userPassEle.item(0).getTextContent();
		
		if (!userId.equals("hfq") || !userPass.equals("123456")) {
			throw new Fault(new IllegalArgumentException("用户和密码不正确"));
		}
	}
	
}
