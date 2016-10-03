package com.fullstackdev.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by nagla on 10/3/2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.fullstackdev.backend.persistence.repositories")
@EntityScan(basePackages = "com.fullstackdev.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
