package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Users.User;

public interface LoginService {
    boolean checkEmail(String email);
    String registerUser(User user);
}
