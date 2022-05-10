package com.api.library.service.impl;

import com.api.library.entity.User;
import com.api.library.repository.UserRepository;
import com.api.library.service.UserService;
import org.hibernate.criterion.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
