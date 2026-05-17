//What is static?
//--> static means the member belongs to the class, not to any specific object. Shared across all objects.
// Shared by all objects of the class. Only one copy exists in memory.


//  Static Variable (Class Variable)

package com.opps;

public class StaticEx {
	String name;  // Instance Variable
	static int count = 0;
	
	public StaticEx(String name) {
		this.name = name;
		count++;
	}
	
	public static void main(String[] args) {
		StaticEx s1 = new StaticEx("Varshil");
		StaticEx s2 = new StaticEx("Bob");
		StaticEx s3 = new StaticEx("Olia");
		
		System.out.println(s1.name);
		System.out.println(StaticEx.count);
		
	}
}
