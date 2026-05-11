package com.jdbc.leraning;

import java.sql.*;

public class RetrieveData {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		Statement st = connect.createStatement();
		
		String sql = "SELECT * FROM studentinfo";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			// first way using column index:
//			System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			
			// second way using the column name:
			System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + rs.getString("scity"));
		}
		
		rs.close();
		st.close();
		connect.close();
	}

}
