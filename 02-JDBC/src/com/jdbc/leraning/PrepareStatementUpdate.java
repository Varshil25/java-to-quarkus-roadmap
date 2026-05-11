package com.jdbc.leraning;

import java.sql.*;
import java.util.Scanner;

public class PrepareStatementUpdate {
	public static void main(String[] args) {
			Connection connect = null;
			PreparedStatement pstmt = null;
		try {
			connect = JDBCUtil.getConnection();
			
			String Query = "UPDATE studentinfo set sage=? where id=?";
			pstmt = connect.prepareStatement(Query );
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id :");
			int id = sc.nextInt();
			System.out.println("Enter your age that you want to update :");
			int age = sc.nextInt();
			
			
			pstmt.setInt(1, age);
			pstmt.setInt(2, id);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 0) {
				System.out.println("data is not updated!");
			}else
			{
				System.out.println("Updation Operation runs Successfully!");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
