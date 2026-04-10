package com.bank;

import org.springframework.beans.factory.annotation.Value;

public class AccountImpl implements Account {
	
	private int id;
	private String type;
	private double balance;
	@Value("#{fileLoggerImpl}")
	private Logger logger;
	
	public AccountImpl() {
		// TODO Auto-generated constructor stub
	}

	public AccountImpl(int id, String type, double balance, Logger logger) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.logger = logger;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;

		
	}

	@Override
	public void setType(String type) {
		this.type = type;

		
	}

	@Override
	public void setLogger(Logger logger) {
		this.logger = logger;

		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return this.logger;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void deposit(double amount) {
		this.balance = this.balance + amount;
		if(logger != null)
			logger.log("Deposit amount Rs. " + amount + " in account " + this.id + " & new balance is Rs. " + this.balance);

		
	}

	@Override
	public void withdraw(double amount) {
		this.balance = this.balance - amount;
		if(logger != null)
			logger.log("Withdraw amount Rs. " + amount + " in account " + this.id + " & new balance is Rs. " + this.balance);
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", logger=" + logger + "]";
	}
	
	
	

}
