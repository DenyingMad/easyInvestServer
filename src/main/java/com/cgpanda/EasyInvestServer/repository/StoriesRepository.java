package com.cgpanda.EasyInvestServer.repository;

import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.entity.stories.StoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface StoriesRepository extends JpaRepository<Story, Long> {
    @Query("SELECT s FROM Story s WHERE s.isFeatured=true")
    List<Story> findAllFeatured();
}
