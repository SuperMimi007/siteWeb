package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}


