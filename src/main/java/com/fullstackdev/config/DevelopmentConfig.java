package com.fullstackdev.config;

import com.fullstackdev.backend.service.EmailService;
import com.fullstackdev.backend.service.MocEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by nagla on 9/26/2016.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.fullstackdev/application-dev.properties")
public class DevelopmentConfig {
    @Bean
    public EmailService emailSerice() {
        return new MocEmailService();
    }
}
