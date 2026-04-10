package com.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.bank")
@Configuration
public class AppConfig {

	@Bean
	Account acc() {
		Account a =new AccountImpl();
		a.setId(101);
		a.setType("Saving");
		a.setBalance(40000);
		return a;
		
	}
	
}
