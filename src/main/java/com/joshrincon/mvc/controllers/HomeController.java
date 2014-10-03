package com.joshrincon.mvc.controllers;

import com.joshrincon.mvc.dao.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    //argument takes type ModelMap
    public String showHome(ModelMap model) {

        return "home";
    }

}
