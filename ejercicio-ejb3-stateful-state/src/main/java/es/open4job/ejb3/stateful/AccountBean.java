package es.open4job.ejb3.stateful;

import javax.ejb.Stateful;

@Stateful
public class AccountBean implements Account {

	private String name = "Default";

	private double balance = 50;

	public AccountBean() {
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public String printAccountDetails() {
		return "Account [name=" + name + ", balance=" + balance + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
