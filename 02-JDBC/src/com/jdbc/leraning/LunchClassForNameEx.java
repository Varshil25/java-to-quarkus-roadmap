package com.jdbc.leraning;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LunchClassForNameEx {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// first way to execute the Demo class
//		Demo d = new Demo();
		
		// we can also load a class using forName..
//		Class.forName("com.jdbc.leraning.Demo").newInstance();
		
//		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
							// OR
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
	}
}


class Demo
{
	static 
	{
		System.out.println("Static Block");
	}
	
	{
		System.out.println("Non Static Block ==> Instance Block");
	}
}