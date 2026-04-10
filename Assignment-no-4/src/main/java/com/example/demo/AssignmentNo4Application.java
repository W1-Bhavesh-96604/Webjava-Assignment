package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


import com.bank.Account;
import com.bank.AppConfig;
import com.bank.ConsoleLoggerImpl;
import com.bank.FileLoggerImpl;
import com.bank.Logger;
import com.bank.SpELTest;

@Import(AppConfig.class)
@SpringBootApplication
public class AssignmentNo4Application implements CommandLineRunner{

	private final SpELTest spELTest;

    private final ConsoleLoggerImpl consoleLoggerImpl;
    
	AssignmentNo4Application(ConsoleLoggerImpl consoleLoggerImpl, SpELTest spELTest) {
        this.consoleLoggerImpl = consoleLoggerImpl;
        this.spELTest = spELTest;
    }

	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentNo4Application.class, args);
	}
	@Autowired
	private ApplicationContext ctx;
	


	@Override
	public void run(String... args) throws Exception {
		Logger consoleLogger = ctx.getBean(ConsoleLoggerImpl.class);
		consoleLogger.log("Log Message 5");
	
		Logger fileLogger = ctx.getBean(FileLoggerImpl.class);
		//fileLogger.log("Log Message 6");
		
		Logger logger = ctx.getBean(Logger.class); // Error --> @Primary on some logger impl.
		//logger.log("Log Message 7");
		
		Account acc = ctx.getBean(Account.class);
		//acc.setLogger(consoleLoggerImpl);
		//acc.setLogger(fileLogger);
		//acc.setLogger(logger);
		
		System.out.println("acc -- " + acc); // 40000
		acc.deposit(4000);
		System.out.println("acc -- " + acc); // 44000
		acc.withdraw(3000);
		System.out.println("acc -- " + acc); // 41000
		
 		SpELTest test = ctx.getBean(SpELTest.class);
 		test.displayInfo();

		
	}

}
