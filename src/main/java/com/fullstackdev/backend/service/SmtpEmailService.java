package com.fullstackdev.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by nagla on 9/26/2016.
 */
public class SmtpEmailService extends AbstractEmailService {
    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.debug("Simulating an email service...... {}", message);
        mailSender.send(message);
        LOG.info("Email sent.");

    }
}
