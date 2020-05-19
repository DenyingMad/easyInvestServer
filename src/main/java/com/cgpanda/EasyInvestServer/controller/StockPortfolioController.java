package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Portfolio.Portfolio;
import com.cgpanda.EasyInvestServer.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user/securities/")
public class StockPortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value = "portfolio/", method = RequestMethod.GET)
    public @ResponseBody
    Portfolio getUserPortfolio(@RequestHeader("api_key") String apiKey){
        return portfolioService.getPortfolio(apiKey);
    }


}
