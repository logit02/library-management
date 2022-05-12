package com.api.library.repository;
import com.api.library.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByArticle_Id(Long id);
}
