package com.opps;

// what is the this?
// --> this is the reference variable that refers to the current object of class.

// Use 1 : Resolve Variable Shadowing.
// When parameter name and instance variable name are same, this differentiates them.

class Object{
	
	
	// Use 1 : Resolve Variable Shadowing.
	// When parameter name and instance variable name are same, this differentiates them.
	// Without this → Java reads the parameter, not the instance variable — data not saved!
	
	// Instance Variable
	private String name;
	private int age;
	
	
	// here this.name is Instance variable and name is local variable that refers to the parameter variable.
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	void print(thisEx tx) {
		System.out.println("Printing :" + tx.name);
	}
	
}

public class thisEx {
	
	String name;
	int age;
	String grade;
	
	// Constructor
	public thisEx(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public thisEx(String name, int age, String grade) {
		this(name, age);
		this.grade = grade;
	}
	
	public void display() {
		System.out.println(name + " | " + age + " | " + grade);
	}
	
	
	void sendPrinter() {
		Object obj = new Object();
		obj.print(this);
	}
	
	
	public static void main(String[] args) {
		Object obj = new Object();
		obj.setName("Varshil");
		obj.setAge(23);
		
		
		thisEx tx = new thisEx("Varshil", 23);
		thisEx tx2 = new thisEx("Varshil" , 23, "A");
		
		tx.display();
		tx2.display();
		
		
		tx.sendPrinter();
		
	}
}
