package com.johnny.webservice.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 类 编 号：
 * 类 名 称：AddHeaderInterceptor
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月6日
 * 编码作者：JohnnyHuang 黄福强
 */
public class SoapHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	Log log = LogFactory.getLog(SoapHeaderInterceptor.class);
	private String userId;
	private String userPass;
	
	
	public SoapHeaderInterceptor() {
		super(Phase.WRITE);
	}

	public SoapHeaderInterceptor(String userId, String userPass) {
		super(Phase.WRITE);
		this.userId = userId;
		this.userPass = userPass;
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		log.info("自定义拦截器---AddHeaderInterceptor");
		List<Header> headers = msg.getHeaders();
		//创建Document对象
		Document doc = DOMUtils.createDocument();
		Element ele = doc.createElement("security");
		//配置服务器端Head信息的用户密码
		Element eleId= doc.createElement("username");
		eleId.setTextContent(userId);
		Element elePass = doc.createElement("password");
		elePass.setTextContent(userPass);
		
		ele.appendChild(eleId);
		ele.appendChild(elePass);
		/**
		 * 生成的XML文档
		 <soapenv:Header>
			<security>
				<username>hfq</username>
				<password>123456</password>
			</security>
		 </soapenv:Header>
		 */
		headers.add(new Header(new QName(""), ele));
	}

}
