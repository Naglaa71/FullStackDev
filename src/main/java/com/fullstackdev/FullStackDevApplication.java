package com.fullstackdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fullstackdev.backend.persistence.repositories")
public class FullStackDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackDevApplication.class, args);
	}
}
