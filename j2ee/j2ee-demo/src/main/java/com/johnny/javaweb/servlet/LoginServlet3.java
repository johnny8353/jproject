package com.johnny.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		PrintWriter out = resp.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///johnny";
			String user = "root";
			String password2 = "1230";
			connection = DriverManager.getConnection(url, user, password2);
			
			String sql = "SELECT count(id) FROM users WHERE username = ? " +
					"AND password = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			resultSet = statement.executeQuery();

			StringBuilder result = new StringBuilder();
			result.append("<html>")
			      .append(" <head>")
			      .append(" </head>") 
			      .append("</html>");
			
			if(resultSet.next()){
				int count = resultSet.getInt(1);
				
				if(count > 0){
					out.print(result.toString());
					
				}else{
					out.print("Sorry: " + username);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
