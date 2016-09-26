package com.fullstackdev.config;

import com.fullstackdev.backend.service.EmailService;
import com.fullstackdev.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by nagla on 9/26/2016.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.fullstackdev/application-prod.properties")
public class ProductionConfig {
    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
