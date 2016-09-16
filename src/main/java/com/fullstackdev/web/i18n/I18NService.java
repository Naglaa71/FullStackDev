package com.fullstackdev.web.i18n;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import org.slf4j.Logger;

/**
 * Created by nagla on 9/16/2016.
 */
@Service
public class I18NService {
    //application Logger
    private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);

    @Autowired
    private MessageSource messageSource;
    /**
     * Returns a message for the given message id and the default locale inthe session context
     * @param messageId The key to the messages resource file
     **/
    public String getMessage(String messageId) {
        LOG.info(" My message is {}", messageId);
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId,locale);
    }

    /**
     * Returns a message for the given message id and locale
     * @param messageId The key to the messages resource file
     * @param locale The Locale
     **/
    public String getMessage(String messageId,Locale locale) {
       return messageSource.getMessage(messageId, null, locale);
    }
}
