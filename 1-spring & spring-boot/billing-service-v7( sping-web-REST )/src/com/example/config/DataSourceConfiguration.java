package com.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/PM");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root1234");
		return basicDataSource;
	}

}
