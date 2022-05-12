package com.api.library.service.impl;

import com.api.library.entity.Comment;
import com.api.library.repository.CommentsRepository;
import com.api.library.service.CommentsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentsRepository.save(comment);
    }

    public List<Comment> getCommentsById(Long id) {
        return commentsRepository.findAllByArticle_Id(id);
    }

    public Comment getCommentById(Long id) {
        return commentsRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("No such comment"));
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = getCommentById(id);
        if( comment != null ) {
            commentsRepository.delete(comment);
        }
    }
}
