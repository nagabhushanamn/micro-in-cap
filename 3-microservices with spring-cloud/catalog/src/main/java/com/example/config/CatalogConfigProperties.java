package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class CatalogConfigProperties {

	private String domain;
	private String itemsType; 
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getItemsType() {
		return itemsType;
	}

	public void setItemsType(String itemsType) {
		this.itemsType = itemsType;
	}
	
	

}
