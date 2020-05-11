package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
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
    public @ResponseBody ApiKey registerUser(@RequestBody User userCredentials){
        String[] parts = splitHash(userCredentials.getPassword());

        userCredentials.setSalt(parts[0]);
        userCredentials.setPassword(parts[1]);
        return service.registerUser(userCredentials);
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public @ResponseBody String signIn(@RequestParam String email){
        return service.authUser(email);
    }

    @RequestMapping(value = "/update-api-key", method = RequestMethod.GET)
    public @ResponseBody String updateApiKey(@RequestParam String email){
        return updateApiKey(email);
    }

    private String[] splitHash(String hash){
        return hash.split(":");
    }
}
