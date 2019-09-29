package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.CatalogConfigProperties;

@RestController
@RefreshScope
public class ConfigPropertiesViewController {

	@Autowired
	private Environment env;

	@Autowired
	private CatalogConfigProperties properties;

	
	@Value("${domain}")
	private String domain;
	@Value("${location}")
	private String location;

	@GetMapping("/view-config-properties")
	public CatalogConfigProperties view() {

		System.out.println(env.getProperty("domain"));
		System.out.println(env.getProperty("location"));

		System.out.println(domain);
		System.out.println(location);

		return properties;
	}

}
