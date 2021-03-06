package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<NewsArticle, Long> {
}
