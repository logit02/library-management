package com.api.library.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String authorName;

    @NonNull
    private String title;

    @NonNull
    private String text;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean approved = false;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> rating = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @NonNull
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(@NonNull String authorName) {
        this.authorName = authorName;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    @NonNull
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(@NonNull Boolean approved) {
        this.approved = approved;
    }
}
