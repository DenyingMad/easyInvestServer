package com.cgpanda.EasyInvestServer.service;

import com.cgpanda.EasyInvestServer.entity.Episode;
import com.cgpanda.EasyInvestServer.entity.Story;

import java.util.List;

public interface StoryService {
    List<Story> getAll();

    Story getOne(long story_id);
}
