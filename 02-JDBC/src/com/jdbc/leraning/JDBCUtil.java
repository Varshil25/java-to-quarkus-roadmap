package com.jdbc.leraning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() throws SQLException {
		
		// create a Connection 
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection connect, Statement st) throws SQLException {
		st.close();
		connect.close();
	}

}
