package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Users.User;
import com.cgpanda.EasyInvestServer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/check-email", method = RequestMethod.GET)
    public @ResponseBody Boolean isEmailRegistered(@RequestParam(defaultValue = "") String email){
        return service.checkEmail(email);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody User userCredentials){
        String hash = userCredentials.getPassword();
        String[] parts = hash.split(":");
        userCredentials.setSalt(parts[0]);
        userCredentials.setPassword(parts[1]);
        return service.registerUser(userCredentials);
    }
}
