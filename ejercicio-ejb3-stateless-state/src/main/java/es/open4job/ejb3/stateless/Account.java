package es.open4job.ejb3.stateless;

import javax.ejb.Remote;

@Remote
public interface Account {

	public void deposit(double amount);

	public String printAccountDetails();

	public String getName();

	public void setName(String name);

	public double getBalance();

	public void setBalance(double balance);

}