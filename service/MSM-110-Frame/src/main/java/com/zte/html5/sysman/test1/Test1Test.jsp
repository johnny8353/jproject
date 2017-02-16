<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>测试页面</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
function run(type,url,data,dataType,contentType){
	$.ajax({
		type: type,
		url: url,
		data:data,
		dataType:dataType,
		contentType:contentType,
		success: function(data, textStatus){
			$("#returnmsg")[0].value = JSON.stringify(data);
		},
		error: function(){
			$("#returnmsg")[0].value = "ajax请求出错";
		} 
	});
}
	
function test(type,url,data,dataType,contentType){
$.ajax({
	type: $("#jsontype")[0].value,
	url: $("#jsonurl")[0].value,
	data:$("#jsondata")[0].value,
	dataType:"json",
	contentType:"application/json",
	success: function(data, textStatus){
		$("#returnmsg")[0].value = JSON.stringify(data);
	},
	error: function(){
		$("#returnmsg")[0].value = "ajax请求出错";
	} 
});
}
</script>

</head>
<body>  

	Controler功能测试：

	<br />
	添加 服务地址:<input type="text" id="inserturl" value="<%=request.getContextPath()%>/sysman/Test1/insert.do" size="150"/>
	<br />
	提交数据:<input type="text" id="insertdata" value='{"id":123}' size="200"/>
	<br />
	<input type="button" value="添加 测试" onclick='javascript:run("post",$("#inserturl")[0].value,$("#insertdata")[0].value,"json","application/json");'/>
	<br />
	
	<br />
	修改 服务地址:<input type="text" id="updateurl" value="<%=request.getContextPath()%>/sysman/Test1/update.do" size="150"/>
	<br />
	提交数据:<input type="text" id="updatedata" value='{"id":123}' size="200"/>
	<br />
	<input type="button" value="修改 测试" onclick='javascript:run("post",$("#updateurl")[0].value,$("#updatedata")[0].value,"json","application/json");'/>
	<br />
	
	<br />
	主键查询 服务地址:<input type="text" id="geturl" value='<%=request.getContextPath()%>/sysman/Test1/get.do' size="150"/>
	<br />
	提交数据:<input type="text" id="getdata" value='{"id":123}' size="200"/>
	<br />
	<input type="button" value="主键查询 测试" onclick='javascript:run("post",$("#geturl")[0].value,$("#getdata")[0].value,"json","application/json");'/>
	<br />
	
	<br />
	列表查询 服务地址:<input type="text" id="getListurl" value="<%=request.getContextPath()%>/sysman/Test1/getList.do" size="150"/>
	<br />
	提交数据:<input type="text" id="getListdata" value='{"bo":{"id":123},"sort":"","order":"desc"}' size="200"/>
	<br />
	<input type="button" value="列表查询 测试" onclick='javascript:run("post",$("#getListurl")[0].value,$("#getListdata")[0].value,"json","application/json");'/>
	<br />
	
	<br />
	翻页查询 服务地址:<input type="text" id="getPageurl" value="<%=request.getContextPath()%>/sysman/Test1/getPage.do" size="150"/>
	<br />
	提交数据:<input type="text" id="getPagedata" value='{"bo":{"id":123},"page":1,"rows":5,"sort":"","order":"desc"}' size="200"/>
	<br />
	<input type="button" value="翻页查询 测试" onclick='javascript:run("post",$("#getPageurl")[0].value,$("#getPagedata")[0].value,"json","application/json");'/>
	<br />
	
	<br />
	删除 服务地址:<input type="text" id="deleteurl" value='<%=request.getContextPath()%>/sysman/Test1/delete.do' size="150"/>
	<br />
	提交数据:<input type="text" id="deletedata" value='{"id":123}' size="200"/>
	<br />
	<input type="button" value="删除 测试" onclick='javascript:run("post",$("#deleteurl")[0].value,$("#deletedata")[0].value,"json","application/json");'/>
	<br />

	
	<br/><br/> 测试返回结果：
	<br/>
	<textarea id="returnmsg" name="returnmsg" rows="20" cols="160"></textarea>
		
</body>
</html>
