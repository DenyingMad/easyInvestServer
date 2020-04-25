package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.entity.stories.StoryCategory;
import com.cgpanda.EasyInvestServer.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoriesController {

    @Autowired
    private StoryService service;

    @RequestMapping(value = "/featured", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getFeaturedStories(){
        List<Story> storyList = service.getFeatured();
        storyList.forEach(story -> story.setEpisodes(null));
        return storyList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getAllStories(){

        List<Story> storyList = service.getAll();
        storyList.forEach(story -> story.setEpisodes(null));
        return storyList;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List<StoryCategory> getAllStoriesByCategory(){
        return service.getCategories();
    }
}
