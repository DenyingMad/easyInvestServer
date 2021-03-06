package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.entity.stories.StoryCategory;
import com.cgpanda.EasyInvestServer.repository.StoriesCategoryRepository;
import com.cgpanda.EasyInvestServer.repository.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoriesRepository storiesRepository;

    @Autowired
    private StoriesCategoryRepository categoryRepository;

    @Override
    public List<Story> getAll() {
        return storiesRepository.findAll();
    }

    @Override
    public List<Story> getFeatured() {
        return storiesRepository.findAllFeatured();
    }

    @Override
    public Story getOne(long story_id) {
        Optional<Story> episodes = storiesRepository.findById(story_id);
        return episodes.orElseGet(() -> new Story(0, "Don't exist", "null"));
    }

    @Override
    public List<StoryCategory> getCategories() {
        return categoryRepository.findAll();
    }


}
