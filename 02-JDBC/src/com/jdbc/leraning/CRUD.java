package com.jdbc.leraning;

import java.sql.*;

public class CRUD {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		Statement st = connect.createStatement();
		
		
		String sql = "SELECT * FROM studentinfo";
		
//		String sql = "UPDATE studentinfo set sage = 28 where id = 1";
		boolean status = st.execute(sql);
		
		// Process the Result
		if(status) 
		{
			// read data
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			
		} else
		{
			// insert, update, delete
			int rowsAffected = st.getUpdateCount();
			
			if(rowsAffected == 0) {
				System.out.println("Operation failed!");
			}else {
				System.out.println("Operation successful!");
			}
			
		}
		
		st.close();
		connect.close();
	}
}
