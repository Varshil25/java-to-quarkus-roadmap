package com.jdbc.leraning;

import java.sql.*;
import java.util.Scanner;

public class BatchUpdate {
	public static void main(String[] args) {
			Connection connect = null;
			PreparedStatement pstmt = null;
		try {
			connect = JDBCUtil.getConnection();
			
			String Query = "UPDATE studentinfo set sage=? where id=?";
			pstmt = connect.prepareStatement(Query );
					
			pstmt.setInt(1, 29);
			pstmt.setInt(2, 1);
			pstmt.addBatch();
			pstmt.setInt(1, 39);
			pstmt.setInt(2, 2);
			pstmt.addBatch();
			pstmt.setInt(1, 49);
			pstmt.setInt(2, 3);
			pstmt.addBatch();
			
			pstmt.executeBatch();
			System.out.println("Check the db for update!");
			
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
