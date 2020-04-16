package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {
}
