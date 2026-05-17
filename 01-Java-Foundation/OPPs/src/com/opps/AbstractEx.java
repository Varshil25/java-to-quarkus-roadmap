package com.opps;

import static java.lang.System.out;

abstract class Animal4{
	private String name;
	
	public Animal4(String name) { this.name = name; }
	
	public abstract void sound();
	public abstract String getType();
	
	public void eat() { out.println( name + "eats"); }
	
	public void describe() {
		out.println("I am " + name + " a " + getType());
		sound();
	}
	
}

class Dog4 extends Animal4{
	public Dog4(String name) {super(name); }
	
	@Override public void sound() { out.println("Woof!"); }
	@Override public String getType() { return "Dog"; }
	
}

class Cat2 extends Animal4{
	public Cat2(String name) { super(name); }
	
	@Override public void sound() { out.println("Meow!"); }
	@Override public String getType() { return "Cat"; }
}

public class AbstractEx {
	public static void main(String[] args) {
		Dog4 d4 = new Dog4("Tommy");
		d4.describe();
		Cat2 c2 = new Cat2("Caty");
		c2.describe();
		
	}
}
