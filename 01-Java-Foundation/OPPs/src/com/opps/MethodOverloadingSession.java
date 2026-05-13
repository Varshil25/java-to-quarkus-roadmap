package com.opps;

class Cencora{
	
	// void 
	void welcome() {
		System.out.println("Welcome to cencora!");
	}
	
	// void + parameter
	public void join(int id) {
		System.out.println("Your Id is to access the Cencora Network is :" + id);
	}
	
	// return without parameter
	public int numberOfWeeks() {
		return 10;
	}
	
	// return with parameter
	public int dailyTask(int n) {
		return n;
	}
	
	public int journey(int tasks, int days) {
		int schdule = tasks * days;
		return schdule;	
	}
	
}

public class MethodOverloadingSession {
	public static void main(String[] args) {
		Cencora c = new Cencora();
		c.welcome();
		c.join(916646801);
		System.out.println("Number of weeks " + c.numberOfWeeks());
		System.out.println(c.dailyTask(20));
		System.out.println(c.journey(5, 50));
	}
}
