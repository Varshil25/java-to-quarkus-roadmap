package com.jdbc.leraning;

import java.sql.*;

public class CRUDWithProperExceptions {
	public static void main(String[] args) {
		
		Connection connect = null;
		Statement st = null;
		
		
		try {
			
			connect = JDBCUtil.getConnection();
			
			st = connect.createStatement();
			
			
//			String sql = "SELECT * FROM studentinfo";
			
			String sql = "UPDATE studentinfo set sage = 28 where id = 1";
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
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeConnection(connect, st);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
