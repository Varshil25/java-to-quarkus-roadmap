package com.jdbc.leraning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementInsert {
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			connect = JDBCUtil.getConnection();
			
			String query = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
			pst = connect.prepareStatement(query);
			
			System.out.println("Enter details to insert a Data into Table:");
			System.out.println("Enter your id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter your name: ");
			String name = sc.next();
			
			System.out.println("Enter your age: ");
			int age = sc.nextInt();
			
			System.out.println("Enter your city: ");
			String city = sc.next();
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, city);
			
			int rowAffected = pst.executeUpdate();
			
			if(rowAffected == 0) {
				System.out.println("Data not Instered!");
			}else {
				System.out.println("Data Inserated Successfully!");
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
