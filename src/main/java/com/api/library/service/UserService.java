package com.api.library.service;

import com.api.library.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    Object create(User user);

    Optional<User> findUserById(String userId);

    User getUserByUsername(String username);

    User getUserByUsernameAndPassword(String username, String password);
}
