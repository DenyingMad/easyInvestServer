package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.stories.StoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoriesCategoryRepository extends JpaRepository<StoryCategory, Long> {
}
