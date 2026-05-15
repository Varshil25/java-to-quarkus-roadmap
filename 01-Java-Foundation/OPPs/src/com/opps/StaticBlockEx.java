//A block of code that runs once when the class is loaded — before main() or any object.

package com.opps;

public class StaticBlockEx {
	
	static int value;
	
	static {
		value = 100;
		System.out.println("Static Block!");
	}
	
	public static void main(String[] args) {
		System.out.println("Main Block!");
		System.out.println("Value : " + value);
	}
}
