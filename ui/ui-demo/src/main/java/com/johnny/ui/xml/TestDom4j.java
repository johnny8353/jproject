package com.johnny.ui.xml;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：  TestDOM
 * 内容摘要：dom4j是一个简单的开源库，用于处理XML、 XPath和XSLT，它基于Java平台，使用Java的集合框架，全面集成了DOM，SAX和JAXP。
 * 完成日期：2016年9月2日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestDom4j {

	@Test
	public void TestPath() {
		// String filePath = System.getProperty("user.dir") ;
		// System.out.println(filePath);
		// String fileName = filePath + "\\demo.xml"; //当前路径下的demo.xml
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\demo.xml");
		try {
			SAXReader reader = new SAXReader();
			// 读取文件 转换成Document
			Document doc = reader.read(in); // 加载xml文件

			List peoples = doc.selectNodes("//*[@name]"); // 选择所有具有name属性的节点(即demo.xml中的所有card节点)
			for (Iterator iter = peoples.iterator(); iter.hasNext();) {
				Element card = (Element) iter.next();
				// System.out.println(node.asXML());
				// System.out.println("---------------------------------------");
				// System.out.println(node.attributeCount());
				List attrList = card.attributes();
				// 输出每个card的所有属性
				for (Iterator attr = attrList.iterator(); attr.hasNext();) {
					Attribute a = (Attribute) attr.next();
					System.out.println(a.getName() + "=" + a.getValue());

				}
				System.out
						.println("----------------------------------------------------");
			}

			Element zhangsan = (Element) doc
					.selectSingleNode("//card[@id='2']"); // 查找“id属性”=2的card元素
			System.out
					.println("张三的名称：" + zhangsan.attribute("name").getValue()); // 输出zhangsan的name属性

			Node addrFamily = zhangsan.selectSingleNode("./address/item[2]"); // 选择zhangsan元素下的address节点下的第2个item子节点
			System.out.println("张三的单位地址：" + addrFamily.getStringValue()); // 输出cdata内容

			System.out
					.println("----------------------------------------------------");
			// 为zhangsan下增加二个节点
			zhangsan.addElement("email").addAttribute("type", "工作")
					.addText("work@some-domain.com");
			zhangsan.addElement("email").addAttribute("type", "私人")
					.addCDATA("private@some-domain.com"); // 设置CDATA内容

			System.out.println(zhangsan.asXML()); // 打印zhangsan节点的xml内容(调试用)
			System.out
					.println("----------------------------------------------------");

			// 将上述改动保存到文件demo2.xml
			FileWriter fileWriter = new FileWriter(
					System.getProperty("user.dir") + "\\demo2.xml");

			OutputFormat format = OutputFormat.createPrettyPrint(); // 设置美观的缩进格式，便于阅读
			// format = OutputFormat.createCompactFormat();//设置紧凑格式（消除多余空格），便于下载
			XMLWriter writer = new XMLWriter(System.out, format);
			writer.setWriter(fileWriter);
			writer.write(doc);
			writer.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testListNode() throws Exception {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		// 读取文件 转换成Document
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\student.xml");
		Document document = reader.read(in);
		// 获取根节点元素对象
		Element root = document.getRootElement();
		// 遍历
		listNodes(root);
	}

	// 遍历当前节点下的所有节点
	public void listNodes(Element node) {
		System.out.println("-当前节点的名称：" + node.getName());
		// 首先获取当前节点的所有属性节点
		List<Attribute> list = node.attributes();
		// 遍历属性节点
		for (Attribute attribute : list) {
			System.out.println("属性" + attribute.getName() + ":"
					+ attribute.getValue());
		}
		// 如果当前节点内容不为空，则输出
		if(!(node.getTextTrim().equals(""))) {
			System.out.println(node.getName() + "：" + node.getText());
		}
		// 同时迭代当前节点下面的所有子节点
		// 使用递归
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e);
		}
	}

	@Test
	public void testAttr() throws Exception {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\student.xml");
		// 读取文件 转换成Document
		Document document = reader.read(in);
		// 获取根节点元素对象
		Element root = document.getRootElement();

		System.out.println("-------添加属性前------");
		// 获取节点student1
		Element student1Element = root.element("student1");
		// 遍历
		listNodes(student1Element);
		// 获取其属性
		Attribute idAttribute = student1Element.attribute("id");
		// 删除其属性
		student1Element.remove(idAttribute);
		// 为其添加新属性
		student1Element.addAttribute("name", "这是student1节点的新属性");
		System.out.println("-------添加属性后------");
		listNodes(student1Element);
	}

	// 添加节点
	@Test
	public void testAddNode() throws Exception {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\student.xml");
		// 读取文件 转换成Document
		Document document = reader.read(in);
		// 获取根节点元素对象
		Element root = document.getRootElement();
		System.out.println("-------添加节点前------");
		// 获取节点student1
		Element student1Element = root.element("student1");
		// 遍历
		listNodes(student1Element);
		// 添加phone节点
		Element phoneElement = student1Element.addElement("phone");
		// 为phone节点设置值
		phoneElement.setText("137xxxxxxxx");
		System.out.println("-------添加节点后------");
		listNodes(student1Element);
	}
	
}
