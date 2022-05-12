package com.api.library.controller;

import com.api.library.entity.Rating;
import com.api.library.service.ArticleService;
import com.api.library.service.RatingService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;
    private final ArticleService articleService;

    public RatingController(RatingService ratingService, ArticleService articleService) {
        this.ratingService = ratingService;
        this.articleService = articleService;
    }

    @PostMapping("{id}")
    public Rating rateArticle(@PathVariable Long id, @RequestBody Rating rating ) {
        return articleService.findArticleById(id).map(article -> {
            rating.setArticle(article);
            return ratingService.rateArticle(rating);
        }).orElseThrow(() -> new BadCredentialsException("Err"));
    }

    @GetMapping("{id}")
    public Double getRating(@PathVariable Long id) {
        return ratingService.getRating(id);
    }

}
