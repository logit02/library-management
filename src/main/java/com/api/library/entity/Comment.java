package com.api.library.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;

    @NonNull
    public String getMessage() {
        return message;
    }

    public void setMessage(@NonNull String message) {
        this.message = message;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


}
