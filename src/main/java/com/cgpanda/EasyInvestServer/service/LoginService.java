package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import com.cgpanda.EasyInvestServer.entity.Users.User;

public interface LoginService {
    boolean checkEmail(String email);
    ApiKey registerUser(User user);
}
