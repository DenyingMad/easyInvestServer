package com.cgpanda.EasyInvestServer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "articles")
@Entity
public class Article {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_image")
    private String articleImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }
}
