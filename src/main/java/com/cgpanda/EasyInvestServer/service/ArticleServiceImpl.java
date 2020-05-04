package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.NewsArticle;
import com.cgpanda.EasyInvestServer.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticlesRepository repository;

    @Override
    public List<NewsArticle> getAll() {
        return repository.findAll();
    }
}
