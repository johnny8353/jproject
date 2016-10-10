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
	//下面是对json对象的增删查改操作

	//声明json对象
	var jsonObj2={persons:[{name:"jordan",sex:"m",age:"40"}, {name:"bryant",sex:"m",age:"28"}, {name:"McGrady",sex:"m",age:"27"} ]};
	var persons=jsonObj2.persons;
	var str="";
	var person={name:"yaoMing",sex:"m",age:"26"};
	
	//以下为json对象的操作，去掉注释可以查看操作结果
	//jsonObj2.persons.push(person);//数组最后加一条记录
	//jsonObj2.persons.pop();//删除最后一项
	//jsonObj2.persons.shift();//删除第一项
	//jsonObj2.persons.unshift(person);//数组最前面加一条记录 只要适合Javascript的方法都是可以用在JSON对象的数组中的！所以还有另外的方法splice( )进行crud操作！ //删除
	//jsonObj2.persons.splice(0,2);//开始位置,删除个数
	
	var self={name:"tom",sex:"m",age:"24"};
	var brother={name:"Mike",sex:"m",age:"29"};
	//替换不删除
	//jsonObj2.persons.splice(1,0,self,brother,self);//开始位置,删除个数,插入对象
	
	//替换并删除 
	jsonObj2.persons.splice(0,1,self,brother);//开始位置,删除个数,插入对象
	
	for(var i=0;i<persons.length;i++ )
	{
		var cur_person=persons[i];
		str =cur_person.name +"'sex is "  +cur_person.sex + " and age is " + cur_person.age  +"<br><br>"; 
		document.writeln(str);
	}
	
	  
	//转换为json文本
	var myjsonobj =  JSON.stringify(jsonObj2);
	document.writeln(myjsonobj);
</script>
<body>

</body>
</html>