package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;
import com.cgpanda.EasyInvestServer.entity.Blog.Quote;

import java.util.List;

public interface BlogService {
    List<Article> getArticles(int page, int sort);

    Quote getRandomQuote();
}
