<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <h3>AAA PAGE</h3>
   
   <% 
   		String str = "abcde";
   		
   %>
   
   <!-- 在 a.jsp 中包含 b.jsp -->
   <%--  
   <jsp:include>标签对JSP引擎翻译JSP页面的过程不起作用，它是在JSP页面的执行期间才被调用，因此不会影响两个页面的编译。
	由于include指令是在JSP引擎翻译JSP页面的过程中被解释处理的，所以它对JSP引擎翻译JSP页面的过程起作用，如果多个JSP页面中都要
	用到一些相同的声明，那么就可以把这些声明语句放在一个单独的文件中编写，然后在每个JSP页面中使用include指令将那个文件包含进来。 
   	如果在b.jsp里使用<%= str %>获取str，用include指令可以编译通过，用include标签不行。
   <%@ include file="b.jsp" %>
   --%>
   
   <jsp:include page="b.jsp">
		<jsp:param value="abcd" name="username"/>
   </jsp:include>

	
	<%-- 
	<jsp:forward page="/include/b.jsp">
		<jsp:param value="abcd" name="username"/>
	</jsp:forward>	   
		request.getRequestDispatcher("/include/b.jsp").forward(request, response);
	--%>
   
</body>
</html>