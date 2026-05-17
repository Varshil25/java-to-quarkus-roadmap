package com.opps;

import static java.lang.System.out;

class Animal3{
	public void eat() { out.println("pat Animals eats vages"); }
}

class Dog3 extends Animal3 {
	@Override
	public void eat() { super.eat();  out.println("But Dog is exception!"); }
}

class Cat extends Animal3 {
	@Override
	public void eat() { super.eat(); out.println("Cats are vegitarian!"); }
}

class Cow extends Animal3{
	@Override
	public void eat() { super.eat(); out.println("Cows are vegan!"); }
}

public class InheritanceHierarchical {
	public static void main(String[] args) {
		Dog3 d = new Dog3();
		Cat c = new Cat();
		Cow co = new Cow();
		d.eat();
		c.eat();
		co.eat();
	}
}
