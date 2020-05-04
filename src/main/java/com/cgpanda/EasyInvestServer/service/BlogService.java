package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;

import java.util.List;

public interface BlogService {
    List<Article> getArticles(int page, int sort);
}
