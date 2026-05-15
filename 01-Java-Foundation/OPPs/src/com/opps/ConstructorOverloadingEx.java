package com.opps;

public class ConstructorOverloadingEx {
	String name;
	int age;
	String grade;
	
	// Constructor 1 : no args
	public ConstructorOverloadingEx() {
		this.name = "unknown";
		this.age = 0;
	}
	
	// Constructor 2 : two args
	public ConstructorOverloadingEx(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Constructor 3 : Three args
	public ConstructorOverloadingEx(String name, int age, String grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public void display() {
		System.out.println(name + " | " + age + " | " + grade);
	}
	
	public static void main(String[] args) {
		ConstructorOverloadingEx c1  = new ConstructorOverloadingEx();
		ConstructorOverloadingEx c2 = new ConstructorOverloadingEx("Varshil" , 23);
		ConstructorOverloadingEx c3 = new ConstructorOverloadingEx("Varshil" , 23, "A-");
		
		c1.display();
		c2.display();
		c3.display();
	}
}
