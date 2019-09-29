package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.Billing;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		// phase-1 : init/boot
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = SpringApplication.run(App.class, args);
		System.out.println();

		// phase-2 : use
		Billing billing = applicationContext.getBean(Billing.class);
		List<String> cart1 = Arrays.asList("1", "2");
		double totalPrice = billing.getTotalPrice(cart1);
		System.out.println(totalPrice);

		System.out.println();
		// phase-3 : destroy
		applicationContext.close();
	}

}
