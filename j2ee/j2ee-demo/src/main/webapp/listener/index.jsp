<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>HttpSessionListener监听器监听HttpSession对象的创建</title>
  </head>
  
  <body>
       一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}
  </body>
</html>