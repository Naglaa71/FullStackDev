package com.fullstackdev.backend.service;

import com.fullstackdev.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by nagla on 9/26/2016.
 */
public abstract class AbstractEmailService implements EmailService {
    @Value("${default.to.address}")
    private String defaultToAddress;
    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackOPojo(FeedbackPojo feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[DevOps Buddy]: Feedback recieved from " + feedback.getFirstName() + " " + feedback
        .getLastName() + "!");
        message.setText(feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackOPojo(feedbackPojo));
    }
}
