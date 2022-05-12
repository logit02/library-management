package com.api.library.service.impl;

import com.api.library.entity.Article;
import com.api.library.entity.User;
import com.api.library.repository.ArticleRepository;
import com.api.library.repository.UserRepository;
import com.api.library.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public UserServiceImpl(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Object create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return userRepository.findById(Long.parseLong(userId));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Article setApprovedTrue(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
       if(article != null) {
           article.setApproved(true);
          return articleRepository.save(article);
       }
       throw new BadCredentialsException("No such article");
    }

    @Override
    public void delete(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        articleRepository.delete(article);
    }


}
