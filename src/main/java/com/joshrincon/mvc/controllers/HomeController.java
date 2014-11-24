package com.joshrincon.mvc.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static Logger logger = LogManager.getLogger(HomeController.class.getName());

    @RequestMapping("/")
    public String showHome() {
        logger.info("Showing homepage...");
        return "home";
    }
}
