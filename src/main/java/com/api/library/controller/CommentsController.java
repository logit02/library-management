package com.api.library.controller;


import com.api.library.entity.Article;
import com.api.library.entity.Comment;
import com.api.library.service.impl.ArticleServiceImpl;
import com.api.library.service.impl.CommentsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsServiceImpl commentsServiceImpl;
    private final ArticleServiceImpl articleServiceImpl;

    public CommentsController(CommentsServiceImpl commentsServiceImpl, ArticleServiceImpl articleServiceImpl) {
        this.commentsServiceImpl = commentsServiceImpl;
        this.articleServiceImpl = articleServiceImpl;
    }


    @PostMapping("/{id}")
    public Comment addComment( @PathVariable Long id, @RequestBody Comment comment) {
       return articleServiceImpl.findArticleById(id).map(article -> {
            comment.setArticle(article);
            return commentsServiceImpl.addComment(comment);
        }).orElseThrow(() -> new BadCredentialsException("Error occurred"));
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Comment>> getCommentsById(@PathVariable Long id) {
        return ResponseEntity.ok(commentsServiceImpl.getCommentsById(id));
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteComment(@PathVariable Long id) {
        commentsServiceImpl.deleteComment(id);
        return HttpStatus.OK;
    }
}
