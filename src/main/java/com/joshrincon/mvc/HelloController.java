package com.joshrincon.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    /*
    @RequestMapping(method = RequestMethod.GET)
    //argument takes type ModelMap
	public ModelAndView showHome(ModelMap model) {

        ModelAndView mv = new ModelAndView("hello");
        Map<String, Object> models = mv.getModel();
        models.put("name1", "Boris");
        models.put("name2", "Dick");

		model.addAttribute("message", "Hello world!");
		//which view? called hello? and offers-servlet maps it to a jsp?
        return mv;
	}

    */

    @RequestMapping(method = RequestMethod.GET)
    //argument takes type ModelMap
    public String showHome(ModelMap model) {

        model.addAttribute("message", "Hello world!");
        //which view? called hello? and offers-servlet maps it to a jsp?
        return "hello";
    }
}