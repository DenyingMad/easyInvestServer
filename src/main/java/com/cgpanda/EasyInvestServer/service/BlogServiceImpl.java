package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;
import com.cgpanda.EasyInvestServer.entity.Blog.Quote;
import com.cgpanda.EasyInvestServer.repository.BlogRepository;
import com.cgpanda.EasyInvestServer.repository.QuotesRepository;
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
    private BlogRepository blogRepository;
    @Autowired
    private QuotesRepository quotesRepository;

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
                articlePage = blogRepository.findAll(paging);
                break;
            case 1:
                paging = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "postDate"));
                articlePage = blogRepository.findAll(paging);
                break;
            case -1:
                paging = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "postDate"));
                articlePage = blogRepository.findAll(paging);
                break;
        }

        if (articlePage != null && articlePage.hasContent())
            return articlePage.getContent();
        else
            return new ArrayList<Article>();
    }

    @Override
    public Quote getRandomQuote() {
        long max = quotesRepository.countAllQuotes();
        long a = (long) (Math.random() * max);
        return quotesRepository.findById(a).orElseGet(()-> new Quote(-1, "Don't work", "Danny"));
    }
}
