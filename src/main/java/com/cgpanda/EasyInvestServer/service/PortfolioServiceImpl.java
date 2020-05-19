package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Portfolio.Portfolio;
import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import com.cgpanda.EasyInvestServer.repository.ApiRepository;
import com.cgpanda.EasyInvestServer.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private ApiRepository apiRepository;

    @Override
    public Portfolio getPortfolio(String apiKey) {
        ApiKey api = apiRepository.findByApiKey(apiKey).orElseGet(ApiKey::new);
        return portfolioRepository.findById(api.getPortfolioId()).orElseGet(Portfolio::new);
    }
}
