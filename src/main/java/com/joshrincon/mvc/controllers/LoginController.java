package com.joshrincon.mvc.controllers;

import com.joshrincon.mvc.dao.Offer;
import com.joshrincon.mvc.dao.User;
import com.joshrincon.mvc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String showNewAccount(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value="/createaccount", method= RequestMethod.POST)
    public String createAccount(@Valid User user, BindingResult result) {

        // do some validation
        if(result.hasErrors()) {
            return "createaccount";
        }

        user.setEnabled(true);
        user.setAuthority("user");
        // create the offer
        usersService.create(user);

        return "accountcreated";
    }

}
