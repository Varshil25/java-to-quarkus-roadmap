package com.opps;

public class ClassObject {
	public static void main(String[] args) {
		Student std = new Student();
		std.info();		
		
		Car car = new Car();
		car.color = "White";
		car.year = 2030;
		car.run();
	}
}

class Student{
	int id = 101;
	String name = "Varshil";
	int age = 21;
	String department = "CS";
	
	void info() {
		System.out.println("Student info: " + name + " is "  + age +  " year old and from " + department + " and his id is " + id );
	}
}


class Car{
	String brand;
	String model;
	String color;
	int year;
	int hspeed;
	
	
	void run() {
		System.out.println("This is Car Section...");
		brand = "mercedez";
		model = "maybach";
		color = "Dark Brown";
		year = 2032;
		hspeed = 240;
		
		System.out.println("Tisha like a " + brand + " with this " + model + " specific this " + color + " and guess to buy in next this " + year + " and its highest speed is " + hspeed);
	}
}