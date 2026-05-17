package com.opps;

class BankAccount{
	private int cId;
	private String password;
	private double balance;
	
	public int getId() {
		return cId = 916646801;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(amount >= 0 && balance >= amount) {
			balance -= amount;
		}else
		{
			System.out.println("Invalid withdraw!");
		}
	}

	public String getPassword() {
		return password;
	}
	
	
}

public class EncBankEx {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		
		System.out.println("Customer Id : " +ba.getId());
		
		System.out.println("new password is :");
		ba.setPassword("TishaV@1425");
		System.out.println(ba.getPassword());
		
		ba.deposit(1254.56);
		System.out.println(ba.getBalance());
		
		ba.withdraw(512.12);
		System.out.println(ba.getBalance());
	}
}
