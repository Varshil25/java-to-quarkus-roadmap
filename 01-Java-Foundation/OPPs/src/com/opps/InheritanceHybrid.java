package com.opps;

import static java.lang.System.out;

interface twoWheel {
	public void tier(int n, String name);
}

interface fourWheel {
	public void tier(int n, String name);
}

class Vehicle{
	public void start() { out.println("Vehicle Started!"); }
	public void stop() { out.println("Vehicle Stopped!");}
}


class Tata extends Vehicle implements twoWheel, fourWheel {
	
	@Override
	public void tier(int n, String name) { out.println(name + " is " + n + " Wheeler!"); }
	
	@Override
	public void start() { out.println("Car engine starts!"); }
	
	@Override
	public void stop() { out.println("Car engine Stopped!"); }
	
}



// class Child extends Parent implements InterfaceA, InterfaceB { }   Hybrid Interface.
public class InheritanceHybrid {
	public static void main(String[] args) {
		Tata t = new Tata();
		t.tier(4, "Nexon");
		t.tier(2, "Hero");
		t.start();
		t.stop();
	}
}
