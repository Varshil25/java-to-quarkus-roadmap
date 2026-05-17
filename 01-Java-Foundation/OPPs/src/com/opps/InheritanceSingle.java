package com.opps;

import static java.lang.System.out;

class Animal1{
	public void eat() { out.println("Animals Eat"); }
}

class Dog1 extends Animal1{
	
	@Override
	public void eat() {
		super.eat();
		out.println("Dog chews");
	}
	
	public void bark() { out.println("Dog barks"); }
}


// Animal -> Dog
public class InheritanceSingle {
	public static void main(String[] args) {
		Dog1 d = new Dog1();
		d.eat();
		d.bark();
	}
}
