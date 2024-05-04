package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
			String sql ="select * from login where uname=? and pass =?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Gopal@#132");
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, uname);
				pst.setString(2,pass);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("username", uname);
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			


}
}