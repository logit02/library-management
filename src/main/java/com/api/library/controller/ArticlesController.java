package com.api.library.controller;

import com.api.library.entity.Article;
import com.api.library.repository.ArticleRepository;
import com.api.library.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    private final ArticleService articleService;

    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Article>> getAll() {
        return ResponseEntity.ok(articleService.findByApprovedTrue());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.findAll());
    }
    @PostMapping("/request")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        return new ResponseEntity<Article>(articleService.createArticle(article), HttpStatus.CREATED);
    }


}
