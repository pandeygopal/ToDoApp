package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
 private static Connection conn;
 public static Connection getConn() {
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root","Gopal@#132");
		 
	 }catch(Exception e) {
		 
		 
		 e.fillInStackTrace();
	 }
	 return conn;
	 
 }
}
