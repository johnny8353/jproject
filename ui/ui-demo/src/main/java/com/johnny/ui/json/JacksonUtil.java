package com.johnny.ui.json;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 类 编 号：
 * 类 名 称：TestJsonObject
 * 内容摘要：Jackson从2.0开始改用新的包名fasterxml;
 		使用新的jackson较优
 		<!-- 老的jackson 性能较差
		<dependency>
           <groupId>org.codehaus.jackson</groupId>
           <artifactId>jackson-mapper-asl</artifactId>
           <version>1.9.4</version>
     	</dependency>
		 -->
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class JacksonUtil {
	public static String bean2Json(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createGenerator(sw);
        mapper.writeValue(gen, obj);
        gen.close();
        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }
}
