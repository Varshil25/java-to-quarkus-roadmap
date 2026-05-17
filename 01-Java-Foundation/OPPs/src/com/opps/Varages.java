package com.opps;

import static java.lang.System.out;

// Varargs (variable arguments) is a Java feature that lets a method accept any number of arguments of the same type — zero, one, or many — without you having to overload it for each case.

public class Varages {
	
	public void show(int... nums) {
		for(int n : nums) out.print(n);
	}
	
	public static void main(String[] args) {
		Varages v = new Varages();
		v.show();
		v.show(1);
		v.show(1,2,3);
		v.show(new int[] {1,2});
		
	}
}
