package com.api.library.controller;

import com.api.library.entity.Article;
import com.api.library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/article/{id}/approve")
    public ResponseEntity<Article> approveArticle(@PathVariable Long id ) {
        return ResponseEntity.ok(userService.setApprovedTrue(id));
    }
    @DeleteMapping("/article/{id}/delete")
    public HttpStatus deleteArticle(@PathVariable Long id ) {
        userService.delete(id);
        return HttpStatus.OK;
    }
}
