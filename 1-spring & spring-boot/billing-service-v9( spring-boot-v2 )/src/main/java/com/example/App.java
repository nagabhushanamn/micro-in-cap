package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		// phase-1 : init/boot
		ConfigurableApplicationContext applicationContext = null;
		applicationContext = SpringApplication.run(App.class, args);
		System.out.println();
	}

}
