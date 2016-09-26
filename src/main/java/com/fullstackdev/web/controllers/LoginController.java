package com.fullstackdev.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nagla on 9/26/2016.
 */
@Controller
public class LoginController {
    public static final String LOGIN_VIEW_NAME = "user/login";
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    public String login() {
        LOG.debug(" login controller returns the name of view {}", LOGIN_VIEW_NAME);
        return LOGIN_VIEW_NAME;
    }
}
