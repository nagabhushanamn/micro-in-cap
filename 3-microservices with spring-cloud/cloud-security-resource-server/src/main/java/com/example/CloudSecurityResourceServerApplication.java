package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class CloudSecurityResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSecurityResourceServerApplication.class, args);
	}

}
