package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.Blog.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Long> {
    @Query("select count(q) from Quote q where q.id>=0")
    int countAllQuotes();
}
