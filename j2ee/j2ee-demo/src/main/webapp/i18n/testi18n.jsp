<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>国际化(i18n)测试</title>
  </head>
  <%
      //加载i18n资源文件，request.getLocale()获取访问用户所在的国家地区
      ResourceBundle myResourcesBundle = ResourceBundle.getBundle("com.johnny.javaweb.i18n.resource.myproperties",request.getLocale());
  %>
  <body>
        <form action="" method="post">
            <%=myResourcesBundle.getString("username")%>：<input type="text" name="username"/><br/>
            <%=myResourcesBundle.getString("password")%>：<input type="password" name="password"/><br/>
            <input type="submit" value="<%=myResourcesBundle.getString("submit")%>">
        </form>
  </body>
</html>