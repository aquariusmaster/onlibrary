package com.onlibrary.controller;

import com.onlibrary.entity.User;
import com.onlibrary.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by harkonnen on 21.03.16.
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    private static final Logger LOGGER = Logger.getLogger(UsersController.class);

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
    }

    @RequestMapping("/logout")
    public String showLoggedOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
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

    @RequestMapping("/users")
    public String showUsers(Model model) {

        System.out.println("LoginsController showUsers");

        model.addAttribute("usersList", usersService.getAllUsers());

        return "users";
    }

}
