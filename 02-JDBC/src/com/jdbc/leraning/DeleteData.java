package com.jdbc.leraning;

import java.sql.*;

public class DeleteData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		Statement st = connect.createStatement();
		
		String sql = "DELETE FROM studentinfo Where id = 2";
		int rowAffected = st.executeUpdate(sql);
		
		if(rowAffected == 0) {
			System.out.println("Record not Deleted yet!");
		}else {
			System.out.println("Record Deleted successfully");
		}
		
		st.close();
		connect.close();
	}
}
