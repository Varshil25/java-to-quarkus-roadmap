package com.opps;

/* Inheritance is when one class (the child or subclass) takes on the fields and methods of another class (the parent or superclass),
so you don't have to rewrite them. In Java, you use the extends keyword. */


import static java.lang.System.out;

class Animal{
	public void eat()  { out.println("Animals Eat"); }
}
	
class Dog extends Animal{
	public void bark() { out.println("Dogs bark"); }
}

public class InheritanceEx {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.bark();
		d.eat();
	}
}
