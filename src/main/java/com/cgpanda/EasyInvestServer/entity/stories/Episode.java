package com.cgpanda.EasyInvestServer.entity.stories;

import com.cgpanda.EasyInvestServer.entity.stories.Story;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "episode_id")
    private long id;

    @Column(name = "episode_text")
    private String episode_text;

    @Column(name = "episode_image")
    private String episode_image;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    @JsonBackReference
    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public Episode() {
    }

    public Episode(long id, String text, String image) {
        this.id = id;
        this.episode_text = text;
        this.episode_image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEpisode_text() {
        return episode_text;
    }

    public void setEpisode_text(String episode_text) {
        this.episode_text = episode_text;
    }

    public String getEpisode_image() {
        return episode_image;
    }

    public void setEpisode_image(String episode_image) {
        this.episode_image = episode_image;
    }
}
