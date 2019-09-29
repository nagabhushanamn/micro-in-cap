package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.example.pm", "com.example.bill" })
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
