package com.bank;

public interface Account {

	void setId(int id);
	void setBalance(double balance);
	void setType(String type);
	void setLogger(Logger logger);
	int getId();
	double getBalance();
	String getType();
	Logger getLogger();
	void deposit(double amount);
	void withdraw(double amount);
	
	
}
