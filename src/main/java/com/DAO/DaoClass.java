package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoClass {
	public boolean check(String uname ,String pass) { 
		String sql ="select * from login where uname=? and pass =?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Gopal@#132");
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2,pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public void add(String uname,String pass) {
		
		String sql ="insert into login values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Gopal@#132");
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2,pass);
			int rowCount =pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
