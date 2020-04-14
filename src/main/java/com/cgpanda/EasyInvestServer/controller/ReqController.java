package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Episode;
import com.cgpanda.EasyInvestServer.entity.Story;
import com.cgpanda.EasyInvestServer.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class ReqController {

    @Autowired
    private StoryService service;

    @RequestMapping("/")
    @ResponseBody
    public String test(){
        return "Server working";
    }

    @RequestMapping(value = "/stories", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getAllStories(){

        List<Story> storyList = service.getAll();
        for (Story story : storyList){
            story.setEpisodes(null);
        }

        return storyList;
    }

    @RequestMapping(value = "/ep", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getEpisodes(){
        List<Episode> episodes = new ArrayList<>();
        List<Story> storyList = service.getAll();
        for (Story story : storyList){
            episodes.addAll(story.getEpisodes());
        }
        return episodes;
    }


    @RequestMapping(value = "/episodes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getEpisodes(@PathVariable("id") long story_id){
        List<Episode> episodes = new ArrayList<>();
        Story story = service.getOne(story_id);
        episodes.addAll(story.getEpisodes());
        return episodes;
    }
}
