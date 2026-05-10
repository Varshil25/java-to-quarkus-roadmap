package com.jdbc.leraning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementRetrieve {
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			connect = JDBCUtil.getConnection();
			
			String query = "SELECT * FROM studentinfo Where id = ?";
			pst = connect.prepareStatement(query);
			
			System.out.println("Enter details to insert a Data into Table:");
			System.out.println("Enter your id: ");
			int id = sc.nextInt();
			
			
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			else {
				System.out.println("There is no record for this " + id);
			}			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.closeConnection(connect, pst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
