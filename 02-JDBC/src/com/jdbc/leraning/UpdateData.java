package com.jdbc.leraning;

import java.sql.*;

public class UpdateData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		Statement st = connect.createStatement();
		
		
		String sql = "UPDATE studentinfo set sage = 23 where id = 1";
		int rowAffected = st.executeUpdate(sql);
		
		if(rowAffected == 0) {
			System.out.println("Data is not updated yet!");
		}else
		{
			System.out.println("Data is Successfully Updated!");
		}
		
		
		st.close();
		connect.close();
	}
}
