package com.jdbc.leraning;

import java.sql.*;
import java.util.Scanner;

public class PrepareStatementDelete {
	public static void main(String[] args) {
			Connection connect = null;
			PreparedStatement pstmt = null;
		try {
			connect = JDBCUtil.getConnection();
			
			String Query = "DELETE FROM studentinfo Where id = ?";
			pstmt = connect.prepareStatement(Query );
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id :");
			int id = sc.nextInt();
			
			
			pstmt.setInt(1, id);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 0) {
				System.out.println("Unable is to Detaltion!");
			}else
			{
				System.out.println("Deletation Operation runs Successfully!");
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
