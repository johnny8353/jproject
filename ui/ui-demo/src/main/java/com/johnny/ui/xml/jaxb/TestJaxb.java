package com.johnny.ui.xml.jaxb;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.junit.Test;

import com.johnny.ui.xml.jaxb.bean.Person;
import com.johnny.ui.xml.jaxb.bean.Student;

/**
 * 类 编 号：
 * 类 名 称：TestJavaToXml
 * 内容摘要：
 
 一.Jaxb处理java对象和xml之间转换常用的annotation有：
	@XmlType
	@XmlElement
	@XmlRootElement
	@XmlAttribute
	@XmlAccessorType
	@XmlAccessorOrder
	@XmlTransient
	@XmlJavaTypeAdapter
二.常用annotation使用说明
	1.@XmlType
		@XmlType用在class类的注解，常与@XmlRootElement，@XmlAccessorType一起使用。它有三个属性：name、propOrder、namespace，经常使用的只有前两个属性。如：
		@XmlType(name = "basicStruct", propOrder = {
		    "intValue",
		    "stringArray",
		    "stringValue"
		)
		在使用@XmlType的propOrder 属性时，必须列出JavaBean对象中的所有属性，否则会报错。
　　2.@XmlElement
	　　@XmlElement将java对象的属性映射为xml的节点，在使用@XmlElement时，可通过name属性改变java对象属性在xml中显示的名称。如：
	　　@XmlElement(name="Address")　　
	　　private String yourAddress;
　　3.@XmlRootElement
	　　@XmlRootElement用于类级别的注解，对应xml的跟元素，常与 @XmlType 和 @XmlAccessorType一起使用。如：
	
	　　@XmlType
	　　@XmlAccessorType(XmlAccessType.FIELD)
	　　@XmlRootElement
	　　public class Address {}
　　4.@XmlAttribute
	　　@XmlAttribute用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名。如：
	　　@XmlAttribute(name="Country")
	　　private String state;
　　5.@XmlAccessorType
	　　@XmlAccessorType用于指定由java对象生成xml文件时对java对象属性的访问方式。常与@XmlRootElement、@XmlType一起使用。它的属性值是XmlAccessType的4个枚举值，分　　　别为：
	
	　　XmlAccessType.FIELD:java对象中的所有成员变量
	
	　　XmlAccessType.PROPERTY：java对象中所有通过getter/setter方式访问的成员变量
	
	　　XmlAccessType.PUBLIC_MEMBER：java对象中所有的public访问权限的成员变量和通过getter/setter方式访问的成员变量
	
	　　XmlAccessType.NONE:java对象的所有属性都不映射为xml的元素
	
	　　注意：@XmlAccessorType的默认访问级别是XmlAccessType.PUBLIC_MEMBER，因此，如果java对象中的private成员变量设置了public权限的getter/setter方法，就不要在　　　private变量上使用@XmlElement和@XmlAttribute注解，否则在由java对象生成xml时会报同一个属性在java类里存在两次的错误。同理，如果@XmlAccessorType的访问权限　　　为XmlAccessType.NONE，如果在java的成员变量上使用了@XmlElement或@XmlAttribute注解，这些成员变量依然可以映射到xml文件。

　　6.@XmlAccessorOrder
	　　@XmlAccessorOrder用于对java对象生成的xml元素进行排序。它有两个属性值：
	
	　　AccessorOrder.ALPHABETICAL：对生成的xml元素按字母书序排序
	
	　　XmlAccessOrder.UNDEFINED:不排序

　　7.@XmlTransient
		@XmlTransient用于标示在由java对象映射xml时，忽略此属性。即，在生成的xml文件中不出现此元素。

　　8.@XmlJavaTypeAdapter
	　　@XmlJavaTypeAdapter常用在转换比较复杂的对象时，如map类型或者格式化日期等。使用此注解时，需要自己写一个adapter类继承XmlAdapter抽象类，并实现里面的方法。
	
	　　@XmlJavaTypeAdapter(value=xxx.class),value为自己定义的adapter类
	
	　　XmlAdapter如下：
	
	public abstract class XmlAdapter<ValueType,BoundType> {
	    // Do-nothing constructor for the derived classes.
	    protected XmlAdapter() {}
	    // Convert a value type to a bound type.
	    public abstract BoundType unmarshal(ValueType v);
	    // Convert a bound type to a value type.
	    public abstract ValueType marshal(BoundType v);
	 }
 
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestJaxb {

	@Test
	public void test01() {
		try {
			JAXBContext jc = JAXBContext.newInstance(Student.class);
			Marshaller ms = jc.createMarshaller();
			Student st = new Student("zhang", "w", "h", 11);
			ms.marshal(st, System.out);
		}
		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// xml转换Java
	@Test
	public void test02() throws JAXBException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>112</age><height>h</height><name>zhangAAA</name><width>w</width></student>";
		JAXBContext jc = JAXBContext.newInstance(Student.class);
		Unmarshaller unmar = jc.createUnmarshaller();
		Student stu = (Student) unmar.unmarshal(new StringReader(xml));
		System.out.println(stu.getName());
	}

	// JAXB生成XML不需要加@XmlRootElement注解的方法
	@Test
	public void test03() throws JAXBException {
		Person user = new Person();
		user.setId("123");
		user.setName("zc");
		user.setSex("女");
		// 创建JAXB上下文
		JAXBContext context = JAXBContext.newInstance(user.getClass());
		// 创建QName，这个是关键，有了这个就不要使用@XmlRootElement注解了，关于QName的资料大家自己网上找，这里不赘述
		QName q = new QName("http://ws.test.com", "Person");
		JAXBElement<Person> jaxbPerson = new JAXBElement<Person>(q,
				Person.class, user);
		Marshaller m = context.createMarshaller();
		StringWriter sw = new StringWriter();
		m.marshal(jaxbPerson, sw);
		// 输出转换后的XML代码
		System.out.println(sw.toString());
	}

	/**
	 * JAXB（Java API for XML Binding），提供了一个快速便捷的方式将Java对象与XML进行转换。在JAX-WS（Java的WebService规范之一）中，
	 * JDK1.6 自带的版本JAX-WS2.1，其底层支持就是JAXB。
		JAXB 可以实现Java对象与XML的相互转换，在JAXB中，将一个Java对象转换为XML的过程称之为Marshal，将XML转换为Java对象的过程称之为UnMarshal。
		我们可以通过在 Java 类中标注注解的方式将一个Java对象绑定到一段XML，也就是说，在Java类中标注一些注解，这些注解定义了如何将这个类转换为XML，怎么转换，
		以及一段XML如何被解析成这个类所定义的对象；也可以使用JAXB的XJC工具，通过定义schema的方式实现Java对象与XML的绑定（这个下次研究）。
	 * @throws JAXBException 
	 */
	@Test
	public void test4() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Student.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "gb2312");// 编码格式

		// 我在实际开发中重新封装了JAXB基本类，这里就使用到了该属性。不过默认的编码格式UTF-8
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息（<?xml
																// version="1.0"
																// encoding="gb2312"
																// standalone="yes"?>）

		Student student = new Student();
		marshaller.marshal(student, System.out);
	}

	// xml to java
	public void test5() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Student.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		File file = new File("src/people.xml");
		Student student = (Student) unmarshaller.unmarshal(file);
		System.out.println(student.getName());
	}
	
	//    其实Marshal 和 UnMarshal的过程并不复杂，只需要从JAXBContext中获得Marshaller或Unmarshaller对象，就可以让JAXB帮我们来进行转换了。
	//	我们需要操作的主要内容是定义一个规则，告诉JAXB如何将一个类、按照什么样的格式转换为XML，下面是JAXB中主要的一些注解。

}
