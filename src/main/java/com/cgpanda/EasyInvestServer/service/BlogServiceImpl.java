package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;
import com.cgpanda.EasyInvestServer.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository repository;

    @Override
    public List<Article> getArticles(int page, int sort) {
        //Сортировка по дате добавления и по актуальности
        //0 - сортировка по умолчанию - по актуальности
        //1 - сортировка по дате от новых постов к старым
        //-1 - сортировка по дате от старых постов к новым
        Pageable paging;
        Page<Article> articlePage = null;

        switch (sort) {
            case 0:
                paging = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "relevance"));
                articlePage = repository.findAll(paging);
                break;
            case 1:
                paging = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "postDate"));
                articlePage = repository.findAll(paging);
                break;
            case -1:
                paging = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "postDate"));
                articlePage = repository.findAll(paging);
                break;
        }

        if (articlePage != null && articlePage.hasContent())
            return articlePage.getContent();
        else
            return new ArrayList<Article>();
    }
}
