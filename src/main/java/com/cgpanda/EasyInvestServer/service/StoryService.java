package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.entity.stories.StoryCategory;

import java.util.List;

public interface StoryService {
    List<Story> getAll();

    List<Story> getFeatured();

    Story getOne(long story_id);

    List<StoryCategory> getCategories();

}
