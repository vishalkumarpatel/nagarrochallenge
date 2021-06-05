package com.nagarro.challenge.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.nagarro.challenge")
public class SpringJdbcConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");
		dataSource.setUrl(
				"jdbc:ucanaccess://C:/Users/Vishal-PC/Downloads/JavaTest/accountsdb.accdb;showSchema=true;openExclusive=false;ignoreCase=true");
//        dataSource.setUsername("");
//        dataSource.setPassword("");

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
