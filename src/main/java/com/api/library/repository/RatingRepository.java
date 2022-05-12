package com.api.library.repository;

import com.api.library.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    public List<Rating> findRatingByArticle_Id(Long id);

}
