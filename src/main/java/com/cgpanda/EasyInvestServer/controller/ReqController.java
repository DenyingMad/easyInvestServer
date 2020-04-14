package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Episode;
import com.cgpanda.EasyInvestServer.entity.Story;
import com.cgpanda.EasyInvestServer.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Story> getAll(){
        return service.getAll();
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
}
