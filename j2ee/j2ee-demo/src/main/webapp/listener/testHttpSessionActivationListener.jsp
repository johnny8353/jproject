<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.johnny.javaweb.listener.*"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
  </head>
  
  <body>
      一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}
       <hr/>
   <% 
        session.setAttribute("bean",new MyHttpSessionActivationListener("孤傲苍狼"));
    %>
  </body>
</html>