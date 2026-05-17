package com.opps;


class University{
	private String name;
	private String department;

	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
}

public class EncapsulationExample {
	public static void main(String[] args) {
		University u = new University();
		u.setDepartment("CST");
		u.setName("Varshil");
		
		System.out.println(u.getName() + " is from " + u.getDepartment() + " Department");
	}
}
