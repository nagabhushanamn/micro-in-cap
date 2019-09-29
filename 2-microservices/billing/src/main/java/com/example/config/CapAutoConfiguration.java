package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnJava(value = JavaVersion.EIGHT)
@ConfigurationProperties(prefix = "cap")
public class CapAutoConfiguration {

	private String location = "universe";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		System.out.println(this.location);
	}

}
