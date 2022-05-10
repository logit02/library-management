package com.api.library.repository;

import com.api.library.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByApprovedIs(Boolean approved);
}
