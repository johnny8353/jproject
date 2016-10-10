<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>ServletContextAttributeListener监听器测试</title>
  </head>
  
  <body>
        <%
           //往application域对象中添加属性
           application.setAttribute("name", "johnny");
          //替换application域对象中name属性的值
           application.setAttribute("name", "hhh");
           //移除application域对象中name属性
           application.removeAttribute("name");
           %>
  </body>
</html>