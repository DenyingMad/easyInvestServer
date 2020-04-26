package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Article;
import com.cgpanda.EasyInvestServer.entity.stories.Episode;
import com.cgpanda.EasyInvestServer.entity.Equity;
import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.service.ArticleService;
import com.cgpanda.EasyInvestServer.service.EquityService;
import com.cgpanda.EasyInvestServer.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReqController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private EquityService equityService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    @ResponseBody
    public String test(){
        return "Server working";
    }





    @RequestMapping(value = "/equities", method = RequestMethod.GET)
    @ResponseBody
    public List<Equity> getAllEquities(){
        return equityService.getAll();
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public List<Article> getAllArticles(){
        return articleService.getAll();
    }
}
