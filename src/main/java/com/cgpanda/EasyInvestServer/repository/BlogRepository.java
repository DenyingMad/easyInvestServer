package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
