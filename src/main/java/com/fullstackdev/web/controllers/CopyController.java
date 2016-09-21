package com.fullstackdev.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nagla on 9/20/2016.
 */
@Controller
public class CopyController {
    @RequestMapping("/about")
    public String about() {
        return "copy/about";
    }
}
