package com.cgpanda.EasyInvestServer.controller;

import com.cgpanda.EasyInvestServer.entity.Article;
import com.cgpanda.EasyInvestServer.entity.stories.Episode;
import com.cgpanda.EasyInvestServer.entity.Equity;
import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.cgpanda.EasyInvestServer.service.ArticleService;
import com.cgpanda.EasyInvestServer.service.EquityService;
import com.cgpanda.EasyInvestServer.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReqController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private EquityService equityService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    @ResponseBody
    public String test(){
        return "Server working";
    }

    @RequestMapping(value = "/stories", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getAllStories(){

        List<Story> storyList = storyService.getAll();
        storyList.forEach(story -> story.setEpisodes(null));
        return storyList;
    }

    @RequestMapping(value = "/ep", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getEpisodes(){
        List<Episode> episodes = new ArrayList<>();
        List<Story> storyList = storyService.getAll();
        storyList.forEach( story -> episodes.addAll(story.getEpisodes()));
        return episodes;
    }


    @RequestMapping(value = "/episodes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getEpisodes(@PathVariable("id") long story_id){
        Story story = storyService.getOne(story_id);
        return new ArrayList<>(story.getEpisodes());
    }

    @RequestMapping(value = "/equities", method = RequestMethod.GET)
    @ResponseBody
    public List<Equity> getAllEquities(){
        return equityService.getAll();
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public List<Article> getAllArticles(){
        return articleService.getAll();
    }
}
