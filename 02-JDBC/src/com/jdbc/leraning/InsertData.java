package com.jdbc.leraning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. load or register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Established a Connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		
		// 3. creating statement
		Statement st = connect.createStatement();
		
		// execute query
		// Insert data into Database
		String sql = "Insert Into studentInfo(id, sname, sage, scity) VALUES(2, 'Tisha', 23, 'Roxboury')";
		int rowAffected = st.executeUpdate(sql);
		
		if(rowAffected == 0) {
			System.out.println("Inseration is not executed!");
		}else {
			System.out.println("Inseration done successfully!");
		}
		
		// process the result
		
		//close the resources
		st.close();
		connect.close();
		
		
		
	}
}
