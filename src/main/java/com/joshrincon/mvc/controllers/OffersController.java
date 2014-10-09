package com.joshrincon.mvc.controllers;

import com.joshrincon.mvc.dao.Offer;
import com.joshrincon.mvc.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping("/offers")
    //argument takes type ModelMap
    public String showOffers(ModelMap model) {

        offersService.throwTestException();

        List<Offer> offers = offersService.getCurrent();

        model.addAttribute("offers", offers);
        //which view? called hello? and offers-servlet maps it to a jsp?
        return "offers";
    }


    @RequestMapping("/createoffer")
    public String createOffer(ModelMap model) {

        // add an attribute to the model from the commandName in createoffer.jsp
        // this will remember what the user types in
        model.addAttribute("offer", new Offer());

        return "createoffer";
    }

    // only handles post requests (so paramaters are not in the url and is more secure)
    // @valid is from validation-api
    // bindingresult is validator
    @RequestMapping(value="/docreate", method=RequestMethod.POST)
    public String doCreate(ModelMap model, @Valid Offer offer, BindingResult result) {

        // do some validation
        if(result.hasErrors()) {
            return "createoffer";
        }

        // create the offer
        offersService.create(offer);

        return "offercreated";
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    //argument takes type ModelMap
    public String showTest(ModelMap model, @RequestParam("id") String id) {
        // if you have a parameter in a url
        System.out.println("Id is " + id);
        return "home";
    }
}