<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts//jquery/json.js"></script>
</head>
<script> 
	//直接声明json数据结构
	var myJSONObject = {"bindings": [
	        {"ircEvent": "PRIVMSG", "method": "newURI", "regex": "^http://.*"},
	        {"ircEvent": "PRIVMSG", "method": "deleteURI", "regex": "^delete.*"},
	        {"ircEvent": "PRIVMSG", "method": "randomURI", "regex": "^random.*"}
	    ]
	};
	

	//声明字符串,可对比一下json文本与我们正常文本的区别
	var normalstring = '[{persons:[{name:"jordan",sex:"m",age:"40"}, {name:"bryant",sex:"m",age:"28"}, {name:"McGrady",sex:"m",age:"27"} ]}]';
	var jsontext = '[{"persons":[{"name":"jordan","sex":"m","age":"40"}, {"name":"bryant","sex":"m","age":"28"}, {"name":"McGrady","sex":"m","age":"27"} ]}]';
	
	//调用eval函数转换为json对象，
	var myE = eval(normalstring);
	document.writeln(myE + '<br><br>');
	//myE2和myE都能得到json对象
	var myE2 = eval(jsontext);
	document.writeln(myE2 + '<br><br>');

	//将json对象转换为字符串
	var text = JSON.stringify(myE);

	//对比转换后的json文本与声明的文本区别
	document.writeln('转换后的json文本：' +  text  + '<br><br>声明的json格式文本' +  jsontext  + '<br><br>声明的普通格式文本'  + normalstring +  '<br><br>');
	  
	//当安全比较重要的时候使用JSON解析就好一些。JSON解析只会识别JSON文本并且它更安全,下面调用json的parse函数对文本数据转换生成json数据结构
	var myData = JSON.parse(jsontext);
	document.writeln(myData  + '<br><br>');
	
	//undefined
	var myData2 = JSON.parse(normalstring);
	document.writeln(myData2  + '<br><br>');
</script>
<body>

</body>
</html>