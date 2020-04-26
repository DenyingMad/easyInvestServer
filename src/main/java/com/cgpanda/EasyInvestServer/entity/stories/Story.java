package com.cgpanda.EasyInvestServer.entity.stories;


import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "story_id")
    private long story_id;

    @Column(name = "story_title")
    private String story_title;

    @Column(name = "story_image")
    private String story_image;

    @Column(name = "is_featured")
    private boolean isFeatured;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Episode> episodes;

    @ManyToMany(mappedBy = "stories")
    Set<StoryCategory> categories;

    @JsonBackReference
    public Set<StoryCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<StoryCategory> categories) {
        this.categories = categories;
    }

    @JsonIgnore
    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Story() {
    }

    public Story(long story_id, String title, String image) {
        this.story_id = story_id;
        this.story_title = title;
        this.story_image = image;
    }

    public long getStory_id() {
        return story_id;
    }

    public void setStory_id(long id) {
        this.story_id = id;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getStory_image() {
        return story_image;
    }

    public void setStory_image(String story_image) {
        this.story_image = story_image;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

}
