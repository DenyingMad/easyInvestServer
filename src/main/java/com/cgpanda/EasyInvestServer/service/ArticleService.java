package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.NewsArticle;

import java.util.List;

public interface ArticleService {
    List<NewsArticle> getAll();
}
