package com.api.library.repository;

import com.api.library.entity.Article;
import com.api.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}
