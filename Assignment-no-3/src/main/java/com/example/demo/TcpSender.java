package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;
@Primary
@Component
public class TcpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("Tcp Sender" + value);
		
	}
	
	

}
