package com.johnny.javaweb.filter.autologin;
//package com.johnny.javaweb.filter.autologin;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginServlet extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        
//        UserDao dao = new UserDao();
//        User user = dao.find(username, password);
//        if(user==null){
//            request.setAttribute("message", "用户名或密码不对！！");
//            request.getRequestDispatcher("/message.jsp").forward(request, response);
//            return;
//        }
//        request.getSession().setAttribute("user", user);
//        //发送自动登陆cookie给客户端浏览器进行存储
//        sendAutoLoginCookie(request,response,user);
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//    }
//
//    /**
//    * @Method: sendAutoLoginCookie
//    * @Description: 发送自动登录cookie给客户端浏览器
//    * @param request
//    * @param response
//    * @param user
//    */ 
//    private void sendAutoLoginCookie(HttpServletRequest request, HttpServletResponse response, User user) {
//        if (request.getParameter("logintime")!=null) {
//            int logintime = Integer.parseInt(request.getParameter("logintime"));
//            //创建cookie,cookie的名字是autologin，值是用户登录的用户名和密码，用户名和密码之间使用.进行分割，密码经过md5加密处理
//            Cookie cookie = new Cookie("autologin",user.getUsername() + "." + WebUtils.md5(user.getPassword()));
//            //设置cookie的有效期
//            cookie.setMaxAge(logintime);
//            //设置cookie的有效路径
//            cookie.setPath(request.getContextPath());
//            //将cookie写入到客户端浏览器
//            response.addCookie(cookie);
//        }
//    }
//    
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        doGet(request, response);
//    }
//
//}
//
