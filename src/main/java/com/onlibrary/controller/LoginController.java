package com.onlibrary.controller;

import com.onlibrary.entity.User;
import com.onlibrary.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by harkonnen on 21.03.16.
 */
@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
    }

    @RequestMapping("/loggedout")
    public String showLoggedOut() {
        return "loggedout";
    }

    @RequestMapping("/newaccount")
    public String showNewAccount(Model model) {

        model.addAttribute("user", new User());
        return "newaccount";
    }

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }

    @RequestMapping(value="/createaccount", method= RequestMethod.POST)
    public String createAccount(@Valid User user, BindingResult result) {

        if(result.hasErrors()) {
            LOGGER.error("User saving error");
            return "newaccount";
        }

        user.setAuthority("ROLE_USER");
        user.setEnabled(true);

        if(usersService.exists(user.getUsername())) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }
        System.out.println("Password:" + user.getPassword());
        try {
            usersService.create(user);
        } catch (DuplicateKeyException e) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        LOGGER.info("User saved: " + user);
        return "accountcreated";
    }
}
