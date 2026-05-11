package com.opps;

public class ClassObject {
	public static void main(String[] args) {
		Student std = new Student();
		std.info();		
		System.out.println(std.id);
		System.out.println(std.name);
		System.out.println(std.age);
		System.out.println(std.department);
	}
}

class Student{
	int id = 101;
	String name = "Varshil";
	int age = 21;
	String department = "CS";
	
	void info() {
		System.out.println("Student info: " + name + " is "  + age +  " year old and from " + department + " and his id is " + id );
	}
}
