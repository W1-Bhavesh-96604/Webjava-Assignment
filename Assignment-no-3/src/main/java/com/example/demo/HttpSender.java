package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HttpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("HttpSender" + value);
		
	}
	
	

}
