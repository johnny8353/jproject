package com.johnny.ui.xml.digester;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.johnny.ui.xml.TestDom4j;

/**
 * 类 编 号：
 * 类 名 称：TestBookDigester
 * 内容摘要：
		一般用来读取xml文件的工具包有DOM、SAX和JDOM等，但用过的人都知道，它们属于比较底层的API，写起来代码量很大，而且如果修改了xml文件的格式，代码也要做大幅度的改动。
		而使用Apache Jakarta的Digester，解析XML文件非常方便且不需要过多的关心底层的具体解析过程。Digester本来仅仅是Jakarta Struts中的一个工具，
		用于处理struts-config.xml配置文件。显然，将XML文件转换成相应的Java对象是一项很通用的功能，这个工具理应具有更广泛的用途，
		所以很快它就在Jakarta Commons项目(用于提供可重用的Java组件库)中有了一席之地。Digester由"事件"驱动，通过调用预定义的规则操作对象栈，将XML文件转换为Java对象。

    	工作原理如下: Digester底层采用SAX(Simple API for XML)析XML文件，所以很自然的，对象转换由"事件"驱动，在遍历每个节点时，检查是否有匹配模式，
    	如果有，则执行规则定义的操作，比如创建特定的Java对象，或调用特定对象的方法等。此处的XML元素根据匹配模式(matching pattern)识别，而相关操作由规则(rule)定义。
 * 完成日期：2016年9月2日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestBookDigester {
	@Test
	public void Test(){
		InputStream in = TestDom4j.class.getClassLoader().getResourceAsStream(
				"com\\johnny\\ui\\xml\\books.xml");
		 // 建立一个Digester对象
        Digester digester = new Digester();
        //指定它不要用DTD验证XML文档的合法性——这是因为我们没有为XML文档定义DTD
        digester.setValidating(false);
        // 从library标签开始解析,并新建一个Library对象做为根对象
        digester.addObjectCreate("library", Library.class);
        // 根据library标签属性值设置对象的属性,一次可以设置多个属性
        digester.addSetProperties("library");
        // 也可以用下面的方法，指定propertyName
        // digester.addSetProperties("library", "name", "name");

        // -----第1层元素开始
        digester.addObjectCreate("library/book", Book.class);
        //digester.addSetProperties("library/book");
        // 可以用以下三条语句代替
        digester.addCallMethod("library/book", "setBookInfo", 2);
        digester.addCallParam("library/book", 0, "title");
        digester.addCallParam("library/book", 1, "author");
        /**
         * addCallParam(String rule, int  paraIndex,String attributeName)
         * 该方法与addCallMethod配合使用
         * int paraIndex:表明需要填充的方法形参序号,从 0 开始,方法由addCallMethod指定
         * String attributeName:指定标签属性名称
         */
        
        
        // -----第2层元素开始
        digester.addObjectCreate("library/book/chapter", Chapter.class);
        /** addBeanPropertySetter()是将子节点转换为对象的属性，这个方法还可以有第二个参数，当对象的属性名和子节点的名字不一样时用来指定对象的属性名
		该方法的作用及使用方法类似于addSetProperties,只不过它是用String rule规则所指定标签的值(而不是标签的属性)来调用对象的setter*/
        digester.addBeanPropertySetter("library/book/chapter/no");
        // digester.addBeanPropertySetter("library/book/chapter/no", "no");
        
        /** addCallMethod(String rule,String methodName, int  paraNumber) 方法
         * 同样是设置对象的属性,但是方式更加灵活,不需要对象具有setter
         * 当paraNumber = 0时,可以单独使用(表明为标签的值来调用),不然需要配合addCallParam方法
        */
        // digester.addBeanPropertySetter("library/book/chapter/caption");
        // 下面的方法，可以用来代替上一句，作用是一样的 
        digester.addCallMethod("library/book/chapter/caption", "setCaption", 0);

        // addSetNext()是说在再次遇到匹配节点后， 调用当前对象(Chapter类的对象)的父对象(Book类的对象)的方法，方法参数是当前层元素的对象
        digester.addSetNext("library/book/chapter", "addChapter");
        // -----第2层元素结束

        digester.addSetNext("library/book", "addBook");
        // -----第1层元素结束

        try {
            // 解析XML文件,并得到ROOT元素
            Library library = (Library) digester.parse(in);
            System.out.println(" 图书馆: " + library.getName());
            System.out.println(" 共藏书: " + library.getBookList().size() + " 本 ");
            System.out.println(" ***************************** ");

            for (Book book : library.getBookList()) {
                System.out.println(" 书名: " + book.getTitle() + "        作者: " + book.getAuthor());
                System.out.println(" ------------------------------ ");
                // 显示章节
                System.out.println(" 共 " + book.getChapters().size() + " 章 ");
                for (Chapter chapter : book.getChapters()) {
                    System.out.println(chapter.getNo() + ": " + chapter.getCaption());
                }
                System.out.println(" ------------------------------ ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
	}

}
