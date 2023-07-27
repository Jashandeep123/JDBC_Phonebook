package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {

	private static Connection con;
	
	public static Connection getCon() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phoneBook","root","root");
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
