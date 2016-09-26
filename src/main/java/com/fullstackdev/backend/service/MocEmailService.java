package com.fullstackdev.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by nagla on 9/26/2016.
 */
public class MocEmailService extends AbstractEmailService {
    private static final Logger LOG = LoggerFactory.getLogger(MocEmailService.class);

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.debug("Simulating an email service......");
        LOG.info(message.toString());
        LOG.debug("Email sent.");

    }
}
