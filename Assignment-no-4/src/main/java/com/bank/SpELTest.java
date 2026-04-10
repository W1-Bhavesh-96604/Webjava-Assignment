package com.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELTest {

		@Value("#{acc.id}")
		private int accid;
		@Value("#{acc.getType()}")
		private String accType;
		@Value("#{acc.balance + 100}")
		private double accBalancePlus100;
		@Value("#{acc}")
		private Account acc;
		
		public void displayInfo() {
			System.out.println("Acc Id : " + accid);
			System.out.println("Acc Type : " + accType);
			System.out.println("Acc Balance + 100: " + accBalancePlus100);
			System.out.println("Acc Object : " + acc.toString());
		}

}
