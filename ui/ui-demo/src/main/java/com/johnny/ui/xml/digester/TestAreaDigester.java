package com.johnny.ui.xml.digester;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.johnny.ui.xml.TestDom4j;

/**
 * 类 编 号：
 * 类 名 称：AreaDigester
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月2日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAreaDigester {
	@Test
	public void digester() throws Exception {
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\viewcache.xml");
		Digester digester = new Digester();
		digester.setValidating(false);
		digester.addObjectCreate("viewcache/areas", ViewCache.class);
		// 指明匹配模式和要创建的类
		digester.addObjectCreate("viewcache/areas/area", Area.class);
		// 设置对象属性,与xml文件对应,不设置则是默认
		digester.addBeanPropertySetter("viewcache/areas/area/id", "id");
		digester.addBeanPropertySetter("viewcache/areas/area/parentId",
				"parentId");
		digester.addBeanPropertySetter("viewcache/areas/area/name", "name");
		digester.addBeanPropertySetter("viewcache/areas/area/areaType",
				"areaType");
		digester.addBeanPropertySetter("viewcache/areas/area/ordering",
				"ordering");
		digester.addBeanPropertySetter("viewcache/areas/area/zip", "zip");
		digester.addBeanPropertySetter("viewcache/areas/area/phoneArea",
				"phoneArea");
		// 当移动到下一个标签中时的动作
		digester.addSetNext("viewcache/areas/area", "addArea");

		ViewCache vc = null;
		try {
			vc = (ViewCache) digester.parse(in);
			
			System.out.println(vc);
		}
		catch (IOException e) {
			throw new Exception(e);
		}
		catch (SAXException e) {
			throw new Exception(e);
		}
	}
}
