package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.repository"})
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.example.config", "com.example.service","com.example.repository" })
public class BillingServiceConfiguation {

//	@Bean
//	public PriceMatrix pmV1() {
//		// ...
//		return new PriceMatrixImpl_v1();
//	}

//	@Bean
//	public Billing billing() {
//		// ...
//		return new BillingImpl(pmV1());
//	}

}
