package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.CatalogConfigProperties;

@RestController
public class ConfigPopetiesViewController {
//
//	@Autowired
//	private Environment env;
	

	@Autowired
	private CatalogConfigProperties properties;

	@GetMapping("/view-config-properties")
	public CatalogConfigProperties view() {
		
//		System.out.println(env.getProperty("domain"));
//		System.out.println(env.getProperty("location"));
		
		return properties;
	}

}
