package com.api.library.service;

import com.api.library.entity.Rating;


public interface RatingService {
    public Rating rateArticle(Rating rating);

    Double getRating(Long id);
}
