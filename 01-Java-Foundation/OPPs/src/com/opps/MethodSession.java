package com.opps;

import java.util.Scanner;

class Student1 {
	int id;
	String name;
	double physicsMarks;
	double chemistryMarks;
	double mathsMarks;
	
	public double  Result() {
		double res = ((mathsMarks + physicsMarks + chemistryMarks) / 300 ) * 100; 
		return res;
	}
	
	void isCheck() {
		if(mathsMarks <= 33.00 || physicsMarks <= 33.00 || chemistryMarks <= 33.00) {
			System.out.println("Student failes into one of the main subjects");
		}else {
			System.out.println("Student Passed in every papers");
		}
	}
	
	
}

public class MethodSession {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student1 s = new Student1();
		System.out.println("Enter your Maths marks :");
		s.mathsMarks = sc.nextDouble();
		System.out.println("Enter your Checmistry marks :");
		s.chemistryMarks = sc.nextDouble();
		System.out.println("Enter your Physics marks: ");
		s.physicsMarks = sc.nextDouble();
		
		System.out.println(s.Result());
		s.isCheck();
		
	}
}


