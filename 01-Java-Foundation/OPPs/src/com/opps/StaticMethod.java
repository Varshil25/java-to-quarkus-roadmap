//Important Rules for Static Methods:
//
//Cannot use this keyword
//Cannot access instance variables directly
//Can only directly access other static members

package com.opps;

public class StaticMethod {
	
	// StaticMethod : Belongs to the class, not an object. Called without creating an instance.
	
	int x = 20;
	static int y = 10;
		
	public static int add(int a , int b) {
		return a + b;
	}
	
	public static double sqrt(double a) {
		return Math.sqrt(a);
	}
	
	public static void main(String[] args) {
		System.out.println(StaticMethod.add(10, 20));
		System.out.println(StaticMethod.sqrt(24));
		
//		System.out.println(StaticMethod.x);  // we can call instance variable directly.. it's throws compile time error.
		System.out.println(StaticMethod.y);
	}
	
}
