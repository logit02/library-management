package com.api.library.service;

import com.api.library.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> findByApprovedTrue();

    Optional<Article> findArticleById(Long articleId);

    Article createArticle(Article article);


    List<Article> findAll();
}
