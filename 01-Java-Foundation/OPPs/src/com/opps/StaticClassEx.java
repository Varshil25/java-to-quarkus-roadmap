// A class defined inside another class with static keyword.

package com.opps;

public class StaticClassEx {
	static int data = 50;
	
	static class Inner{
		void display() {
			System.out.println("Data : " + data);
		}
	}
	
	public static void main(String[] args) {
		StaticClassEx.Inner obj = new StaticClassEx.Inner();
		obj.display();
	}
}
