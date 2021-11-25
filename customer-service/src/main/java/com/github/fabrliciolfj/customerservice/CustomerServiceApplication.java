package com.github.fabrliciolfj.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = "com.github.fabrliciolfj.customerservice.providers.database")
@EntityScan(basePackages = "com.github.fabrliciolfj.customerservice.providers.database")
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
