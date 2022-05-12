package com.api.library.service;

import com.api.library.entity.Comment;

public interface CommentsService {

    Comment addComment(Comment comment);
    void deleteComment(Long id);
}
