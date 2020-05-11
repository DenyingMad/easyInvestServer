package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.ApiGenerator;
import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import com.cgpanda.EasyInvestServer.entity.Users.User;
import com.cgpanda.EasyInvestServer.repository.ApiRepository;
import com.cgpanda.EasyInvestServer.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private final ApiGenerator apiGenerator = new ApiGenerator();
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    ApiRepository apiRepository;

    @Override
    public boolean checkEmail(String email) {
        User user = loginRepository.findUserByEmail(email).orElseGet(User::new);
        return user.getEmail() != null;
    }

    @Override
    public ApiKey registerUser(User user) {
        String generatedApi = apiGenerator.getApiKey();
        ApiKey apiKey = new ApiKey();
        apiKey.setApiKey(generatedApi);
        apiRepository.saveAndFlush(apiKey);
        user.setApiKey(apiKey);
        loginRepository.saveAndFlush(user);
        return apiKey;
    }

    @Override
    public String authUser(String email) {
        User user = loginRepository.findUserByEmail(email).orElseGet(User::new);
        if (user.getPassword() != null && user.getSalt() != null){
            return user.getSalt() + ":" + user.getPassword();
        } else
            return ".";
    }
}
