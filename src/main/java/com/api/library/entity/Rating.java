package com.api.library.entity;


import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Double getValue() {
        return value;
    }

    public void setValue(@NonNull Double value) {
        this.value = value;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;


}
