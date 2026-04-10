package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class AssignmentNo3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentNo3Application.class, args);
	}
	
	@Autowired
	public ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		
		Sender s = ctx.getBean(Sender.class);
		s.send(100);
		System.out.println(s);
	}

}
