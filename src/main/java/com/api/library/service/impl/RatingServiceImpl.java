package com.api.library.service.impl;

import com.api.library.entity.Rating;
import com.api.library.repository.RatingRepository;
import com.api.library.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating rateArticle(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Double getRating(Long id) {
        double rate = 0.0;
        List<Rating> ratings = ratingRepository.findRatingByArticle_Id(id);
        for(Rating rating: ratings) {
            rate += rating.getValue();
        };
        return rate/ratings.size();
    }
}
