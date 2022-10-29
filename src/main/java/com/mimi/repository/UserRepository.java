package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    public Integer countById(Integer  id);
    public  User findByName(String name);

}


