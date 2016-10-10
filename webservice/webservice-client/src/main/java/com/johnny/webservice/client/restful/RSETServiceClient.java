package com.johnny.webservice.client.restful;


import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.johnny.webservice.restful.bean.MapBean;
import com.johnny.webservice.restful.bean.User;
import com.johnny.webservice.restful.bean.Users;

/**
 * 类 编 号：
 * 类 名 称：RSETServiceClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */

public class RSETServiceClient {
	private static WebClient client;

	@Before
	public void init() {
		// 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
		 String url = "http://localhost:8077/cxf/webservice/rest/";
		 client = WebClient.create(url);

		// 从Spring Ioc容器中拿webClient对象
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"applicationContext-client.xml");
//		client = ctx.getBean("webClient", WebClient.class);
	}

	@After
	public void destory() {
	}

	@Test
	public void testGet() {
		System.out.println(client.path("sample").accept(MediaType.TEXT_PLAIN)
				.get(String.class));
	}

	@Test
	public void testRequest() {
		System.out.println(client.path("sample/request/234234")
				.accept(MediaType.TEXT_PLAIN).get(String.class));
	}

	@Test
	public void testBean() {
		User user = client.path("sample/bean/{id}", 25)
				.accept(MediaType.APPLICATION_XML).get(User.class);
		System.out.println(user);
	}

	@Test
	public void testList() {
//		System.out.println(client.path("sample/list")
//				.accept(MediaType.APPLICATION_JSON).get(Users.class).getUsers());
		Users users = client.path("sample/list")
		.accept(MediaType.APPLICATION_JSON).get(Users.class);
		System.out.println(users.getUsers().size());
	}

	@Test
	public void testMap() {
		System.out.println(client.path("sample/map")
				.accept(MediaType.APPLICATION_XML).get(MapBean.class).getMap());
	}

	@Test
	public void testDeleteData() {
		client.path("sample/removeData/23").delete();
	}
//
//	Response-Code: 200
//	Content-Type: application/xml
//	Headers: {Date=[Thu, 08 Sep 2016 05:15:13 GMT]}
//	Payload: <?xml version="1.0" encoding="UTF-8" standalone="yes"?><Users><address>hoojo#gz</address><email>hoojo_@126.com</email><id>21432134</id><name>johnny##12321321</name></Users>
//	--------------------------------------

	@Test
	public void testPostData() {
		User user = new User();
		user.setId(21432134);
		user.setAddress("hoojo#gz");
		user.setEmail("hoojo_@126.com");
		user.setName("hoojo");
		System.out.println(client.path("sample/postData")
				.accept(MediaType.APPLICATION_XML).post(user, User.class));
	}

	@Test
	public void testPutData() {
		User user = new User();
		user.setId(21432134);
		System.out.println(client.path("sample/putData/1")
				.accept(MediaType.APPLICATION_XML).put(user).getEntity());
	}
}
