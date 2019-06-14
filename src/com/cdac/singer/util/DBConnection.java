package com.cdac.singer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		Connection con=null;
		try {
			 con=DriverManager.getConnection(url, username, password);
			 System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return con; 	
	}
}
