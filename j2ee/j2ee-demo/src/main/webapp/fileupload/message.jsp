<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>消息提示</title>
  </head>
  
  <body>
        ${message}
        <a href="${pageContext.request.contextPath }/servlet/ListFileServlet">文件列表</a>
  </body>
</html>