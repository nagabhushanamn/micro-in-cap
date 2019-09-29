package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.Billing;

public class App {

	public static void main(String[] args) {

		// phase-1 : init/boot
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("billing-service.xml");
		System.out.println();
		// phase-2 : use
		Billing billing = applicationContext.getBean(Billing.class);
		List<String> cart1 = Arrays.asList("121", "122", "123");
		double totalPrice = billing.getTotalPrice(cart1);
		System.out.println(totalPrice);

		System.out.println();

		List<String> cart2 = Arrays.asList("121", "122", "124");
		totalPrice = billing.getTotalPrice(cart2);
		System.out.println(totalPrice);

		// phase-3 : destroy
		applicationContext.close();
	}

}
