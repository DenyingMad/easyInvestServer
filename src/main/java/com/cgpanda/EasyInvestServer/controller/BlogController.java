package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;
import com.cgpanda.EasyInvestServer.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService service;

    @RequestMapping("/articles")
    @ResponseBody
    public List<Article> getArticleList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer sort)
    {
        return service.getArticles(page, sort);
    }

}
