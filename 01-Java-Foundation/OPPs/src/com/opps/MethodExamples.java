package com.opps;

class Example{
	
	// void + without parameter
	public void welcome() {
		System.out.println("Welcome to Cencora!");
	}
	
	// void + parameter
	public void greet(String name) {
		System.out.println("Hello " + name);
	}
	
	// return + parameter
	public int add(int a, int b) {
		return a+b;
	}
	
	public boolean isCheck(boolean test) {
		if(test) {
			System.out.print("You passed in drug test..");
		}
		return test;
	}
	
}

public class MethodExamples {
	public static void main(String[] args) {
		Example ex = new Example();
		ex.welcome();
		ex.greet("Varshil");
		System.out.println("a + b is " + ex.add(10, 15));
		System.out.println(ex.isCheck(true));
	}
}
