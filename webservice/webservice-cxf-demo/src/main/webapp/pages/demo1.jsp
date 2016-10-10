<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#btn2").click(function() {
			var name = document.getElementById("name").value;
			$.post("HttpURLConnectionServlet", "name=" + name, function(msg) {
				//alert(msg);
				var $Result = $(msg);
				var value = $Result.find("return").text();
				alert(value);
			}, "xml");
		});

		$("#btn").click(
			function() { //回调函数
				var name = document.getElementById("name").value;
				var data = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cxf="http://cxfimp.webservice.johnny.com/">'
					+'   <soapenv:Header/>'
					+'  	 <soapenv:Body>'
					+'      <cxf:doHello>'
					+'         <jName>'+name+'</jName>'
					+'      </cxf:doHello>'
					+'   </soapenv:Body>'
					+'</soapenv:Envelope>';
				//alert(data);
				/* $.post(
					"http://192.168.10.165:8888/day01_ws/datatypews",
					data,
					function(msg){
						alert("------");
						var $Result = $(msg);
						var value = $Result.find("return").text();
						alert(value);
					},
					"xml"
				); */

			$.ajax({
				type : "POST",
				url : "http://localhost:8077/cxf/webservice/hellows",
				data : data,
				success : function(xml,status,msg) {
					//var result = $(msg)[0].responseText.replace(new RegExp("\"",'gm'),"'");
					
					//var description = $(result).find("JResult").text();
					var description4 = $($(msg)[0].responseText).find("JResult").text();
					//var description2 = $("<xml><root><item>22</item></root></xml>").find("item").text();
					//var description3 = $("<soap:Envelope xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body><ns2:doHelloResponse xmlns:ns2='http://cxfimp.webservice.johnny.com/'><jResult>Hello CXF！ ffff</jResult></ns2:doHelloResponse></soap:Body></soap:Envelope>").find("jResult").text();
					alert(description4);
				},
				error : function(msg) {
					//alert("-----"+msg);
				},
				dataType : "xml"
			});
		});
	});

	function reqWebService() {
		var name = document.getElementById("name").value;
		var data = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cxf="http://cxfimp.webservice.johnny.com/">'
				+'   <soapenv:Header/>'
				+'  	 <soapenv:Body>'
				+'      <cxf:doHello>'
				+'         <jName>'+name+'</jName>'
				+'      </cxf:doHello>'
				+'   </soapenv:Body>'
				+'</soapenv:Envelope>';
		//XMLHttpRequest对象
		var request = getRequest();
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				//var result = request.response;
				//alert(result);
				var returnEle = request.responseXML.getElementsByTagName("jResult")[0];
				var value = returnEle.firstChild.data;
				alert(value);
			}
		};

		request.open("POST", "http://localhost:8077/cxf/webservice/hellows");

		request.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");

		request.send(data);
	}

	function getRequest() {
		var xmlHttp = null;
		try {
			// Firefox, Opera 8.0+, Safari  chrome
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}
</script>
</head>
<body>
	用户名:
	<input id="name" name="username" value="" />
	<br>
	<button onclick="reqWebService()">AJax请求webservice</button>
	<button id="btn">Jquery请求webservice</button>
	<button id="btn2">HttpURLConnection请求webservice</button>

</body>
</html>