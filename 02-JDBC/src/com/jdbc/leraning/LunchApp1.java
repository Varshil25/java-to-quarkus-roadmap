package com.jdbc.leraning;
import java.sql.*;

public class LunchApp1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. Load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Established the Connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		// 3. Create a Statement to run a SQL Query.
		Statement st = connect.createStatement();
		
		// 4. Execute a Query.
		
		// 5. Process the Result.
		
		// 6. Close the Resources.
		st.close();
		connect.close();
	}
}
