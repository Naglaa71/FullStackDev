package com.fullstackdev.backend.service;

import com.fullstackdev.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by nagla on 9/26/2016.
 */
public interface EmailService {
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);
    public void sendGenericEmailMessage(SimpleMailMessage message);
}
