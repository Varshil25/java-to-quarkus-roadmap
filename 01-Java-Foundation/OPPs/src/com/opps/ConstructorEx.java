//Key Rules

//Same name as the class
//No return type (not even void)
//Called automatically when object is created with new

package com.opps;

public class ConstructorEx {
	
	// A constructor is a special method that is automatically called when an object is created. It is used to initialize the object.
	
	String name;
	int age;
	
	// default constructor  --> Default values: int = 0, double = 0.0, String = null, boolean = false
//	public ConstructorEx(){}

//	// Parameterized constructor
//	public ConstructorEx(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	
	
//	Explicitly written no-arg constructor
	public ConstructorEx() {
		this.name = "unknown";
		this.age = 0;
		
	}
	
	public static void main(String[] args) {
		
		// when we initialized the Object then Java is create a one default constructor and its hidden..
		ConstructorEx ce = new ConstructorEx();
//		ConstructorEx ce1 = new ConstructorEx("Varshil" , 23);

//		System.out.println(ce.name + " is " + ce.age + " year old ");		
		
		System.out.println(ce.name);
		System.out.println(ce.age);
	}
}
