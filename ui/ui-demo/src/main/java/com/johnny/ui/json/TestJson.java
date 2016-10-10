package com.johnny.ui.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.johnny.ui.json.bean.OrderBO;
import com.johnny.ui.json.bean.OrderLine;
import com.johnny.ui.json.bean.Product;

/**
 * 类 编 号：
 * 类 名 称：TestJson
 * 内容摘要：
	性能排序：网上
	Java Bean序列化为Json，性能：Jackson > FastJson > Gson > Json-lib。这4中类库的序列化结构都正确。
	Json字符串反序列化为Java Bean时，性能：Jackson > Gson > FastJson >Json-lib。
	并且Jackson、Gson、FastJson可以很好的支持复杂的嵌套结构定义的类，而Json-lib对于复制的反序列化会出错。
	Jackson、FastJson、Gson类库各有优点，各有自己的专长，都具有很高的可用性。
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestJson {
	@Test
	public void testBean2Json() throws IOException {
		Product product = new Product("iphone5", 3000);
		Product product2 = new Product("iphone6", 5000);
		Product product3 = new Product("iphone6S", 6000);

		OrderLine orderLine = new OrderLine("1", "Line1", product);
		OrderLine orderLine2 = new OrderLine("2", "Line2", product2);
		OrderLine orderLine3 = new OrderLine("3", "Line3", product3);
		List<OrderLine> lines = new ArrayList<>();
		lines.add(orderLine);
		lines.add(orderLine2);
		lines.add(orderLine3);

		OrderBO orderbo = new OrderBO("1", 8000, new Date(), new Date(),
				new Date(), lines);

		System.out.println(orderbo);

		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {

			// 1000	-	2018
			// {"createTime":{"date":1,"day":4,"hours":18,"minutes":33,"month":8,"seconds":5,"time":1472725985927,"timezoneOffset":-480,"year":116},"lastupdTime":{"date":1,"day":4,"hours":18,"minutes":33,"month":8,"seconds":5,"time":1472725985927,"timezoneOffset":-480,"year":116},"orderNum":"1","orderPrice":8000,"orderline":[{"name":"Line1","product":{"name":"iphone5","price":3000},"seq":"1"},{"name":"Line2","product":{"name":"iphone6","price":5000},"seq":"2"},{"name":"Line3","product":{"name":"iphone6S","price":6000},"seq":"3"}],"submitDate":{"date":1,"day":4,"hours":18,"minutes":33,"month":8,"seconds":5,"time":1472725985927,"timezoneOffset":-480,"year":116}}
//			String str = JsonObjectUtil.bean2Json(orderbo);
			
			// 1000	-	1146
			// {"orderNum":"1","orderPrice":8000.0,"submitDate":"Sep 1, 2016 6:32:31 PM","createTime":"Sep 1, 2016 6:32:31 PM","lastupdTime":"Sep 1, 2016 6:32:31 PM","orderline":[{"seq":"1","name":"Line1","product":{"name":"iphone5","price":3000.0}},{"seq":"2","name":"Line2","product":{"name":"iphone6","price":5000.0}},{"seq":"3","name":"Line3","product":{"name":"iphone6S","price":6000.0}}]}
//			 String str = GsonUtil.bean2Json(orderbo);
			 
			// 1000	-	965
			// {"orderNum":"1","orderPrice":8000.0,"submitDate":1472725856685,"createTime":1472725856685,"lastupdTime":1472725856685,"orderline":[{"seq":"1","name":"Line1","product":{"name":"iphone5","price":3000.0}},{"seq":"2","name":"Line2","product":{"name":"iphone6","price":5000.0}},{"seq":"3","name":"Line3","product":{"name":"iphone6S","price":6000.0}}]}
			 String str = JacksonUtil.bean2Json(orderbo);
			 
			// 1000	-	1321
			// {"createTime":1472726169047,"lastupdTime":1472726169047,"orderNum":"1","orderPrice":8000,"orderline":[{"name":"Line1","product":{"name":"iphone5","price":3000},"seq":"1"},{"name":"Line2","product":{"name":"iphone6","price":5000},"seq":"2"},{"name":"Line3","product":{"name":"iphone6S","price":6000},"seq":"3"}],"submitDate":1472726169047}
//			String str = FastjsonUtil.bean2Json(orderbo);
			System.out.println(str);
		}
		long end = System.currentTimeMillis();

		System.out.println("spends:" + (end - begin));

	}
	
	
	/**
	 * 业务描述：	反序列化的输出只有JsonObject输出不一样，其他三种一致
	 * 			
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016年9月1日
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testJson2Bean() throws JsonParseException, JsonMappingException, IOException{

		String str = "{\"orderNum\":\"1\",\"orderPrice\":8000.0,\"submitDate\":null,\"createTime\":null,\"lastupdTime\":null,\"orderline\":[{\"seq\":\"1\",\"name\":\"Line1\",\"product\":{\"name\":\"iphone5\",\"price\":3000.0}},{\"seq\":\"2\",\"name\":\"Line2\",\"product\":{\"name\":\"iphone6\",\"price\":5000.0}},{\"seq\":\"3\",\"name\":\"Line3\",\"product\":{\"name\":\"iphone6S\",\"price\":6000.0}}]}";
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {

			// 1000	-	1242
//			OrderBO [orderNum=1, orderPrice=8000.0, submitDate=null, createTime=null, lastupdTime=null, orderline=[net.sf.ezmorph.bean.MorphDynaBean@1510e56[
//			                                                                                                                                                 {product=net.sf.ezmorph.bean.MorphDynaBean@84433d[
//			                                                                                                                                                 {price=3000.0, name=iphone5}
//			                                                                                                                                               ], name=Line1, seq=1}
//			                                                                                                                                               ], net.sf.ezmorph.bean.MorphDynaBean@15a9173[
//			                                                                                                                                                 {product=net.sf.ezmorph.bean.MorphDynaBean@10345ed[
//			                                                                                                                                                 {price=5000.0, name=iphone6}
//			                                                                                                                                               ], name=Line2, seq=2}
//			                                                                                                                                               ], net.sf.ezmorph.bean.MorphDynaBean@1e3e4c5[
//			                                                                                                                                                 {product=net.sf.ezmorph.bean.MorphDynaBean@c04fd1[
//			                                                                                                                                                 {price=6000.0, name=iphone6S}
//			                                                                                                                                               ], name=Line3, seq=3}
//			                                                                                                                                               ]]]
//			OrderBO orderBO = JsonObjectUtil.json2Bean(str, OrderBO.class);
			
			// 1000	-	1219
			// OrderBO [orderNum=1, orderPrice=8000.0, submitDate=null, createTime=null, lastupdTime=null, orderline=[OrderLine [seq=1, name=Line1, product=Product [name=iphone5, price=3000.0]], OrderLine [seq=2, name=Line2, product=Product [name=iphone6, price=5000.0]], OrderLine [seq=3, name=Line3, product=Product [name=iphone6S, price=6000.0]]]]
//			 OrderBO orderBO = GsonUtil.json2Bean(str, OrderBO.class);
			 
			// 1000	-	952
			// OrderBO [orderNum=1, orderPrice=8000.0, submitDate=null, createTime=null, lastupdTime=null, orderline=[OrderLine [seq=1, name=Line1, product=Product [name=iphone5, price=3000.0]], OrderLine [seq=2, name=Line2, product=Product [name=iphone6, price=5000.0]], OrderLine [seq=3, name=Line3, product=Product [name=iphone6S, price=6000.0]]]]
			 OrderBO orderBO = JacksonUtil.json2Bean(str, OrderBO.class);
			 
			// 1000	-	985
			// OrderBO [orderNum=1, orderPrice=8000.0, submitDate=null, createTime=null, lastupdTime=null, orderline=[OrderLine [seq=1, name=Line1, product=Product [name=iphone5, price=3000.0]], OrderLine [seq=2, name=Line2, product=Product [name=iphone6, price=5000.0]], OrderLine [seq=3, name=Line3, product=Product [name=iphone6S, price=6000.0]]]]
//			OrderBO orderBO = FastjsonUtil.json2Bean(str, OrderBO.class);
			System.out.println(orderBO);
			
		}
		long end = System.currentTimeMillis();

		System.out.println("spends:" + (end - begin));
	}
	
	@Test
	public void test3() throws JsonGenerationException, JsonMappingException, IOException{
//		JSON与JAVA数据的转换（JSON 即 JavaScript Object Natation，它是一种轻量级的数据交换格式，非常适合于服务器与 JavaScript 的交互。）
//		1. List集合转换成json代码
		List list = new ArrayList();
		list.add( "first" );
		list.add( "second" );
		String a = JacksonUtil.bean2Json(list);
		System.out.println(a);

//		2. Map集合转换成json代码
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");
		String b = JacksonUtil.bean2Json(map);
		System.out.println(b);


//		4. 数组转换成json代码
		boolean[] boolArray = new boolean[] { true, false, true };
		String c = JacksonUtil.bean2Json(boolArray);
		System.out.println(c);

		//		5. 一般数据转换成json代码
		String str = "['json','is','easy']" ;
		String d = JacksonUtil.bean2Json(str);
		System.out.println(d);
	}

}
