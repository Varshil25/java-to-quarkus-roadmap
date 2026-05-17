package com.opps;

public class ForEachEx {
	
	public static void main(String[] args) {
		String[] fruits = {"Apple", "Grapes" , "passion Fruit", "Pink Guava"} ;
		
		
		// Basic Loop
		for(String f : fruits) {
			System.out.println(f);
		}
		
		// Using index
		for(int i = 0; i< fruits.length; i++) {
			System.out.println("Fruits on : " + i + " is " + fruits[i]);
		}
		
		
	}
}
