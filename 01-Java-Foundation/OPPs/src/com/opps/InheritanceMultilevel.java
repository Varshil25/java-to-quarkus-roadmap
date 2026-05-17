package com.opps;

import static java.lang.System.out;

class Animal2{
	public void eat() { out.println("Animals eat a lot!"); }
}

class Dog2 extends Animal2{
	@Override
	public void eat() { super.eat();  out.print(" Dogs are chews"); }
	
	public void bark() { out.println("Dogs bark in harsh way"); }
}

class Puppy extends Dog2 {
	
	@Override
	public void bark() { super.bark(); out.print(" But puppies barks slowely"); }
	
	public void cute() { out.println("Pappies are very cute!"); }
}

// Animal → Dog → Puppy
public class InheritanceMultilevel {
	public static void main(String[] args) {
		Puppy p = new Puppy();
		p.eat();
		p.bark();
		p.cute();
		
		Dog2 d2 = new Dog2();
		d2.eat();
	}
}
