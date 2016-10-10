<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%--导入国际化标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>国际化(i18n)测试</title>
  </head>
  <body>
	<% 
		String code = request.getParameter("code");
	
		if(code != null){
			if("en".equals(code)){
				session.setAttribute("locale", Locale.US);
			}else if("zh".equals(code)){
				session.setAttribute("locale", Locale.CHINA);
			}
			
		}
	%>
	<c:if test="${sessionScope.locale != null }">
		<fmt:setLocale value="${sessionScope.locale }"/>
	</c:if>
	${pageContext.request.servletPath }<br/>
	${pageContext.request.serverName }<br/>
	${pageContext.request.servletContext }<br/>
	${pageContext.request.contextPath }<br/>
    <a href="${pageContext.request.contextPath }/${pageContext.request.servletPath }?code=en">English</a>
	<a href="${pageContext.request.contextPath }/${pageContext.request.servletPath }?code=zh">中文</a>    
    <fmt:setBundle var="bundle"  basename="com.johnny.javaweb.i18n.resource.myproperties" scope="page"/>
    <form action="">
        <fmt:message key="username" bundle="${bundle}"/><input type="text" name="username"><br/>
        <fmt:message key="password" bundle="${bundle}"/><input type="password" name="password"><br/>
        <input type="submit" value="<fmt:message key="submit" bundle="${bundle}"/>">
    </form>
  </body>
</html>