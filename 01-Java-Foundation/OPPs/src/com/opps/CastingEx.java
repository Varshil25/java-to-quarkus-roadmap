package com.opps;

public class CastingEx {
	public static void main(String[] args) {
		
		// Implicit Type casting
		// byte -> short -> int -> long -> float -> double
		byte a = 10;
		double b = a;
		
		System.out.println(b);
		
		
		// Must manually cast when going from larger to smaller — possible data loss
		double c = 15.9;
		int d = (int) c;
		System.out.println(d);
		
		
		// Integer Division Trap
		int e = 12, f = 5;
		float g = e/f;
		System.out.println(g);
		
		// Fix: using Casting 
		float h = (float) e / f;
		System.out.println(h);
		
		
	}
}
