package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Story;
import com.cgpanda.EasyInvestServer.repository.StoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoriesRepository storiesRepository;

    @Override
    public List<Story> getAll() {
        return storiesRepository.findAll();
    }


}
