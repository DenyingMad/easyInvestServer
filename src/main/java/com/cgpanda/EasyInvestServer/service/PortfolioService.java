package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Portfolio.Portfolio;

public interface PortfolioService {
    Portfolio getPortfolio(String apiKey);
}
