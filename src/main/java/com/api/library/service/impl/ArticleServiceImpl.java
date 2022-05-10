package com.api.library.service.impl;

import com.api.library.entity.Article;
import com.api.library.repository.ArticleRepository;
import com.api.library.service.ArticleService;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findByApprovedTrue() {
        return articleRepository.findByApprovedIs(true);
    }

    @Override
    public Optional<Article> findArticleById(String articleId) {
        return articleRepository.findById(Long.parseLong(articleId));
    }
}
