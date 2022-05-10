package com.api.library.service;

import com.api.library.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> findByApprovedTrue();

    Optional<Article> findArticleById(String articleId);

}
